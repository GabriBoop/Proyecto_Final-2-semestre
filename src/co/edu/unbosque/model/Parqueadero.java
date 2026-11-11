package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FacturaDAO;
import co.edu.unbosque.model.persistence.MensualidadDAO;
import co.edu.unbosque.model.persistence.RegistroDAO;
import co.edu.unbosque.util.exceptions.FacturaNoEncontradaException;
import co.edu.unbosque.util.exceptions.PlacaNoEncontradaException;
import co.edu.unbosque.util.exceptions.PlacaYaRegistradaException;
import co.edu.unbosque.util.exceptions.RegistroNoEncontradoException;
import co.edu.unbosque.util.exceptions.SobrecupoDeMensualidadesException;
import co.edu.unbosque.util.exceptions.SobrecupoParqueaderoException;

public class Parqueadero {
	
    private static final double PORCENTAJE = 0.30;
    private static final int CANTIDAD_MAX = 200;
    
    private int cantidad = 0;
    private int numeroFacturas = 0;
	private InformacionPolicia sistemaPolicia;

    private FacturaDAO facturas = new FacturaDAO();
    private MensualidadDAO mensualidades = new MensualidadDAO();
    private RegistroDAO registros = new RegistroDAO();
    
    public Parqueadero() {
		sistemaPolicia = new InformacionPolicia();
    }
    
    public int espaciosDisponibles() {
    	return CANTIDAD_MAX - cantidad;
    }
    
    public int cupoMaximoMensualidades() {
		return (int) (CANTIDAD_MAX * PORCENTAJE);
	}
    
    public int espaciosDisponiblesMensualidad() {
		return cupoMaximoMensualidades() - vehiculosMensualidad();
	}
    
    public int vehiculosMensualidad() {
    	int total = 0;
    	for (Mensualidad m : mensualidades.darLista()) {
    		total += m.getVehiculos().size();
    	}
    	return total;
    }
    
    public boolean tieneMensualidad(String placa) {
    	for(Mensualidad m : mensualidades.darLista()) {
    		if(m.mismaPlaca(placa)) return true;
    	}
    	return false;
    }
    
    public void agregarMensualidad(MensualidadDTO m) throws SobrecupoDeMensualidadesException {	
    	if (vehiculosMensualidad() + m.getVehiculos().size() > cupoMaximoMensualidades()) throw new SobrecupoDeMensualidadesException();
    	mensualidades.crear(m);
    }
    
    public boolean soatPorVencer(Vehiculo v) {
    	if(ChronoUnit.DAYS.between(LocalDate.now(), v.getVencimientoSoat()) <= 7) return true;
    	else return false;
    }
    
    public RegistroDTO ingresarVehiculo(Vehiculo v, boolean nocturna) throws Exception {
    	

    	if(isRegistroActivo(v.getPlaca()) == true) throw new PlacaYaRegistradaException();
    	if(espaciosDisponibles() == 0) throw new SobrecupoParqueaderoException();
    	
		String sp = sistemaPolicia.consultaPolicia(v.getPlaca());
		switch(sp) {
		case "LIMPIO":
			
		case "ROBADO":
			
		case "INCAUTADO":
			
		default :
			
		}
    	Tarifa t = null;
    	if(!tieneMensualidad(v.getPlaca())) {
    		if(nocturna) t = new TarifaNocturnaFija();
    		else t = new TarifaPorHora();
    	}
    	RegistroDTO r = new RegistroDTO(v, LocalDateTime.now(), tieneMensualidad(v.getPlaca()),t);
    	registros.crear(r);
    	cantidad++;
    	return r;
    }
    
    public FacturaDTO salidaVehiculo(String placa) throws PlacaNoEncontradaException, RegistroNoEncontradoException {
    	Registro r = buscarRegistro(placa);
    	Vehiculo v = r.getVehiculo();
		r.setHoraSalida(LocalDateTime.now());
		double total = 0;
		FormaDeCobro cobro = FormaDeCobro.MENSUAL;
		
		if(!r.isPagaMensualidad()) {
			total = r.getTarifaAplicada().calcularCosto(r);
			if(r.getTarifaAplicada() instanceof TarifaNocturnaFija) {
				cobro = FormaDeCobro.FIJA;
			}
			else cobro = FormaDeCobro.HORA;
		}
		
		FacturaDTO f = new FacturaDTO(numeroFacturas++,v.getPlaca(),v.getPropietario().getNombre(),r.getHoraIngreso(),r.getHoraSalida(),cobro,total);
		facturas.crear(f);
		cantidad--;
    	return f;
    }
    
    public Registro buscarRegistro(String placa) throws RegistroNoEncontradoException {
    	placa = placa.toUpperCase();
    	for(Registro r : registros.darLista()) {
    		if(r.isActivo() && placa.equals(r.getVehiculo().getPlaca())) return r;
    	}
    	throw new RegistroNoEncontradoException(placa);
	}
    
    public ArrayList<Registro> registrosActivos() {
    	ArrayList<Registro> list = new ArrayList<Registro>();
    	for(Registro r : registros.darLista()) {
    		if(r.isActivo()) list.add(r);
    	}
    	return list;
	}
    
    public boolean isRegistroActivo(String placa) {
    	placa = placa.toUpperCase();
    	for(Registro r : registros.darLista()) {
    		if(r.isActivo() && (r.getVehiculo().getPlaca().equals(placa))) return true;
    	}
    	return false;
	}
    
    public Factura buscarFactura(int num) throws FacturaNoEncontradaException {
    	for(Factura f : facturas.darLista()) {
    		if(f.getNum() == num) return f;
    	}
    	throw new FacturaNoEncontradaException();
	}
    
    public int getNumeroFacturas() {
		return numeroFacturas;
	}
  
}
