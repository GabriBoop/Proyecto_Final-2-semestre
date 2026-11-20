package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.*;

/**
 * Clase que contiene la lógica de negocio del parqueadero: ingreso y salida de
 * vehículos, cobro de tarifas, mensualidades, facturas y reportes.
 */
public class Parqueadero {
	
    /**
     * Porcentaje de los espacios del parqueadero reservado para mensualidades.
     */
    private static final double PORCENTAJE = 0.30;
    /**
     * Cantidad máxima de espacios del parqueadero.
     */
    private static final int CANTIDAD_MAX = 200;
    
    /**
     * Número consecutivo que se asignará a la próxima factura.
     */
    private int numeroFacturas;
	/**
	 * Sistema que consulta el estado policial de un vehículo.
	 */
	private InformacionPolicia sistemaPolicia;

    /**
     * DAO que gestiona las facturas.
     */
    private FacturaDAO facturas;
    /**
     * DAO que gestiona las mensualidades.
     */
    private MensualidadDAO mensualidades;
    /**
     * DAO que gestiona los registros de ingreso y salida.
     */
    private RegistroDAO registros;
    /**
     * Generador de alertas para vehículos robados o incautados.
     */
    private AlertaPolicia alertaPolicia;
    /**
     * Generador de alertas para vehículos con el SOAT próximo a vencer.
     */
    private AlertaSoat alertaSoat;
    
    /**
     * Construye el parqueadero con los DAO necesarios. El número de la próxima
     * factura se calcula según las facturas ya existentes.
     *
     * @param facturas      DAO de facturas.
     * @param mensualidades DAO de mensualidades.
     * @param registros      DAO de registros.
     */
    public Parqueadero(FacturaDAO facturas,MensualidadDAO mensualidades,RegistroDAO registros) {
		sistemaPolicia = new InformacionPolicia();
		alertaPolicia = new AlertaPolicia();
		alertaSoat =  new AlertaSoat();
		this.facturas = facturas;
		this.mensualidades = mensualidades;
		this.registros = registros;	
		numeroFacturas = facturas.darLista().size();
    }
    
    /**
     * Calcula los espacios libres del parqueadero según los registros activos.
     *
     * @return Cantidad de espacios disponibles.
     */
    public int espaciosDisponibles() {
    	return CANTIDAD_MAX - registrosActivos().size();
    }
    
    /**
     * Calcula el cupo máximo de vehículos con mensualidad (30% de la capacidad).
     *
     * @return Cantidad máxima de vehículos con mensualidad.
     */
    public int cupoMaximoMensualidades() {
		return (int) (CANTIDAD_MAX * PORCENTAJE);
	}
    
    /**
     * Calcula los cupos de mensualidad que aún están libres.
     *
     * @return Cantidad de cupos de mensualidad disponibles.
     */
    public int espaciosDisponiblesMensualidad() {
		return cupoMaximoMensualidades() - vehiculosMensualidad();
	}
    
    /**
     * Cuenta todos los vehículos suscritos a una mensualidad.
     *
     * @return Total de vehículos con mensualidad.
     */
    public int vehiculosMensualidad() {
    	int total = 0;
    	for (Mensualidad m : mensualidades.darLista()) {
    		total += m.getVehiculos().size();
    	}
    	return total;
    }
    
    /**
     * Verifica si una placa pertenece a un vehículo con mensualidad.
     *
     * @param placa Placa del vehículo.
     * @return true si el vehículo tiene mensualidad, false en caso contrario.
     */
    public boolean tieneMensualidad(String placa) {
    	for(Mensualidad m : mensualidades.darLista()) {
    		if(m.mismaPlaca(placa)) return true;
    	}
    	return false;
    }
    
    /**
     * Registra una mensualidad para un vehículo ya existente. Si el propietario
     * ya tiene una mensualidad, se agrega el vehículo a ella (máximo dos); si no,
     * se crea una nueva y los registros activos del vehículo pasan a mensualidad.
     *
     * @param documento     Documento del propietario.
     * @param nombre        Nombre del propietario.
     * @param placa         Placa del vehículo.
     * @param tipoVehiculo  Tipo de vehículo (Carro o Moto).
     * @param propietarioDAO DAO de propietarios.
     * @param carroDAO      DAO de carros.
     * @param motoDAO       DAO de motos.
     * @throws PlacaInvalidaException              Si la placa no es válida.
     * @throws PlacaYaRegistradaException          Si la placa ya tiene mensualidad.
     * @throws SobrecupoDeMensualidadesException   Si no hay cupos de mensualidad.
     * @throws PropietarioNoExisteException        Si el propietario no existe.
     * @throws PlacaNoEncontradaException          Si el vehículo no está registrado.
     * @throws PlacaDeOtroPropietarioException     Si la placa es de otro propietario.
     */
    public void registrarMensualidad(String documento, String nombre, String placa, String tipoVehiculo,
    		PropietarioDAO propietarioDAO, CarroDAO carroDAO, MotoDAO motoDAO)
    		throws PlacaInvalidaException, PlacaYaRegistradaException, SobrecupoDeMensualidadesException,
    		PropietarioNoExisteException, PlacaNoEncontradaException, PlacaDeOtroPropietarioException {

    	placa = Vehiculo.validarPlaca(placa);

    	if (tieneMensualidad(placa)) {
    		throw new PlacaYaRegistradaException();
    	}
    	if (espaciosDisponiblesMensualidad() <= 0) {
    		throw new SobrecupoDeMensualidadesException();
    	}

    	Propietario prop = propietarioDAO.buscarPorDocumento(documento);
    	if (prop == null) {
    		throw new PropietarioNoExisteException();
    	}

    	Vehiculo vehiculo;
    	if (tipoVehiculo.equalsIgnoreCase("Carro")) {
    		vehiculo = carroDAO.buscarPorPlaca(placa);
    	} else {
    		vehiculo = motoDAO.buscarPorPlaca(placa);
    	}
    	if (vehiculo == null) {
    		throw new PlacaNoEncontradaException(placa);  
    	}
    	if (!vehiculo.getPropietario().getDocumento().equals(documento)) {
    		throw new PlacaDeOtroPropietarioException();
    	}

    	int indice = mensualidades.buscarIndicePorDocumento(documento);
    	if (indice != -1) {
    		Mensualidad existente = mensualidades.darLista().get(indice);
    		if (existente.getVehiculos().size() >= Mensualidad.VEHICULOS_MAX) {
    			throw new SobrecupoDeMensualidadesException();
    		}
    		existente.agregarVehiculo(vehiculo);
    		mensualidades.actualizar(indice, DataMapper.convertirMensualidadAMensualidadDTO(existente));
    	}
    	else {
    		for (Registro r : registros.darLista()) {
    		    if (r.isActivo() && r.getVehiculo().getPlaca().equals(placa)) {
    		        r.setPagaMensualidad(true);
    		        r.setTarifaAplicada(null);
    		    }
    		}
    		registros.escribirArchivoSerializado();
    		registros.escribirArchivo();
    		MensualidadDTO nueva = new MensualidadDTO(prop, Mensualidad.VALOR_MENSUALIDAD, LocalDate.now());
    		nueva.agregarVehiculo(vehiculo);
    		agregarMensualidad(nueva);
    	}
    }
    
    /**
     * Agrega una mensualidad nueva verificando que no se supere el cupo máximo.
     *
     * @param m Mensualidad a agregar.
     * @throws SobrecupoDeMensualidadesException Si se supera el cupo de mensualidades.
     */
    public void agregarMensualidad(MensualidadDTO m) throws SobrecupoDeMensualidadesException {	
    	if (vehiculosMensualidad() + m.getVehiculos().size() > cupoMaximoMensualidades()) throw new SobrecupoDeMensualidadesException();
    	mensualidades.crear(m);
    }
    
    /**
     * Indica si el SOAT de un vehículo vence en siete días o menos.
     *
     * @param v Vehículo a revisar.
     * @return true si el SOAT está por vencer, false en caso contrario.
     */
    public boolean soatPorVencer(Vehiculo v) {
    	if(ChronoUnit.DAYS.between(LocalDate.now(), v.getVencimientoSoat()) <= 7) return true;
    	else return false;
    }
    
    /**
     * Registra el ingreso de un vehículo. Consulta el sistema de la policía (y
     * genera la alerta si está robado o incautado) y asigna la tarifa según el tipo
     * de cobro, salvo que tenga mensualidad.
     *
     * @param v        Vehículo que ingresa.
     * @param nocturna true para tarifa nocturna fija, false para tarifa por hora.
     * @return Registro creado para el ingreso.
     * @throws PlacaYaRegistradaException     Si el vehículo ya está en el parqueadero.
     * @throws SobrecupoParqueaderoException  Si no hay espacios disponibles.
     */
    public RegistroDTO ingresarVehiculo(Vehiculo v, boolean nocturna) throws PlacaYaRegistradaException, SobrecupoParqueaderoException{
    	
    	if(isRegistroActivo(v.getPlaca()) == true) throw new PlacaYaRegistradaException();
    	if(espaciosDisponibles() == 0) throw new SobrecupoParqueaderoException();
    	
		String sp = sistemaPolicia.consultaPolicia(v.getPlaca());
		switch(sp) {
		case "LIMPIO":
			break;
		case "ROBADO":
			alertaPolicia.mandarAlerta(v, sp);
			break;
		case "INCAUTADO":
			alertaPolicia.mandarAlerta(v, sp);
			break;
		default :
			break;
		}
    	Tarifa t = null;
    	if(!tieneMensualidad(v.getPlaca())) {
    		if(nocturna) t = new TarifaNocturnaFija();
    		else t = new TarifaPorHora();
    	}
    	RegistroDTO r = new RegistroDTO(v, LocalDateTime.now(), tieneMensualidad(v.getPlaca()), t);
    	registros.crear(r);
    	return r;
    }
    
    /**
     * Registra la salida de un vehículo: calcula el cobro según su tarifa (o lo
     * marca como mensual), genera la alerta de SOAT si corresponde, cierra el
     * registro y crea la factura.
     *
     * @param placa Placa del vehículo que sale.
     * @return Factura generada por la salida.
     * @throws PlacaNoEncontradaException      Si la placa no existe.
     * @throws RegistroNoEncontradoException   Si el vehículo no está en el parqueadero.
     */
    public FacturaDTO salidaVehiculo(String placa) throws PlacaNoEncontradaException, RegistroNoEncontradoException {
    	Registro r = buscarRegistro(placa);
    	Vehiculo v = r.getVehiculo();
		r.setHoraSalida(LocalDateTime.now());
		double total = 0;
		FormaDeCobro cobro = FormaDeCobro.MENSUAL;
		
		if (!r.isPagaMensualidad() && !tieneMensualidad(v.getPlaca())) {
    		total = r.getTarifaAplicada().calcularCosto(r);
   				 if (r.getTarifaAplicada() instanceof TarifaNocturnaFija) {
       				 cobro = FormaDeCobro.FIJA;
    			} else {
        			cobro = FormaDeCobro.HORA;
    			}
		} else {
    		r.setPagaMensualidad(true);
    		r.setTarifaAplicada(null);
		}
		
		boolean s = soatPorVencer(v);
		if (s == true) alertaSoat.mandarAlerta(v);
		
		r.setActivo(false);
		registros.escribirArchivoSerializado();
		registros.escribirArchivo();
		FacturaDTO f = new FacturaDTO(numeroFacturas++,v.getPlaca(),v.getPropietario().getNombre(),r.getHoraIngreso(),r.getHoraSalida(),cobro,total);
		facturas.crear(f);
    	return f;
    }
    
    /**
     * Busca el registro activo de una placa.
     *
     * @param placa Placa del vehículo.
     * @return Registro activo del vehículo.
     * @throws RegistroNoEncontradoException Si no hay un registro activo con esa placa.
     */
    public Registro buscarRegistro(String placa) throws RegistroNoEncontradoException {
    	placa = placa.toUpperCase();
    	for(Registro r : registros.darLista()) {
    		if(r.isActivo() && placa.equals(r.getVehiculo().getPlaca())) return r;
    	}
    	throw new RegistroNoEncontradoException(placa);
	}
    
    /**
     * Obtiene los registros de los vehículos que están actualmente en el parqueadero.
     *
     * @return Lista de registros activos.
     */
    public ArrayList<Registro> registrosActivos() {
    	ArrayList<Registro> list = new ArrayList<Registro>();
    	for(Registro r : registros.darLista()) {
    		if(r.isActivo()) list.add(r);
    	}
    	return list;
	}
    
    /**
     * Verifica si una placa tiene un registro activo en el parqueadero.
     *
     * @param placa Placa del vehículo.
     * @return true si el vehículo está parqueado, false en caso contrario.
     */
    public boolean isRegistroActivo(String placa) {
    	placa = placa.toUpperCase();
    	for(Registro r : registros.darLista()) {
    		if(r.isActivo() && (r.getVehiculo().getPlaca().equals(placa))) return true;
    	}
    	return false;
	}
    
    /**
     * Busca una factura por su número.
     *
     * @param num Número de la factura.
     * @return Factura encontrada.
     * @throws FacturaNoEncontradaException Si no existe una factura con ese número.
     */
    public Factura buscarFactura(int num) throws FacturaNoEncontradaException {
    	for(Factura f : facturas.darLista()) {
    		if(f.getNum() == num) return f;
    	}
    	throw new FacturaNoEncontradaException();
	}
    
    /**
     * Obtiene los registros de vehículos que pasaron la noche en el parqueadero,
     * es decir, cuya fecha de ingreso es anterior a la fecha de salida (o a la
     * fecha actual si aún no han salido).
     *
     * @return Lista de registros que pasaron la noche.
     */
    public ArrayList<Registro> vehiculosQuePasaronLaNoche() {
        ArrayList<Registro> lista = new ArrayList<Registro>();
        for (Registro r : registros.darLista()) {
            LocalDateTime hora;
            if (r.getHoraSalida() != null)  hora = r.getHoraSalida(); 
            else hora = LocalDateTime.now();
            if (r.getHoraIngreso().toLocalDate().isBefore(hora.toLocalDate())) lista.add(r);
        }
        return lista;
    }
    
    /**
     * Obtiene los registros de vehículos con más de 24 horas de permanencia.
     *
     * @return Lista de registros con más de 24 horas.
     */
    public ArrayList<Registro> vehiculosMasDe24Horas() {
        ArrayList<Registro> lista = new ArrayList<Registro>();
        for (Registro r : registros.darLista()) {
        	LocalDateTime hora;
        	if(r.getHoraSalida() != null) hora = r.getHoraSalida();
        	else hora = LocalDateTime.now();
            if (ChronoUnit.HOURS.between(r.getHoraIngreso(), hora) > 24) lista.add(r);
        }
        return lista;
    }
    
    /**
     * Calcula el dinero recaudado en el mes actual, sumando las facturas con
     * salida en este mes y las mensualidades que iniciaron en él.
     *
     * @return Total recaudado en el mes.
     */
    public double dineroRecaudadoMes() {
        YearMonth mes = YearMonth.now();
        double total = 0;
        for (Factura f : facturas.darLista()) {
            if (YearMonth.from(f.getHoraSalida()).equals(mes)) total += f.getValor();
        }
        for (Mensualidad m : mensualidades.darLista()) {
            if (YearMonth.from(m.getFechaInicio()).equals(mes)) total += m.getValor();
        }
        return total;
    }
    
    /**
     * Obtiene el número consecutivo de la próxima factura.
     *
     * @return Número de factura.
     */
    public int getNumeroFacturas() {
		return numeroFacturas;
	}
    
}