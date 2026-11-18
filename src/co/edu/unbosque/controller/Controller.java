package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.DatoVacioException;
import co.edu.unbosque.util.exceptions.DocumentoInvalidoException;
import co.edu.unbosque.util.exceptions.FacturaNoEncontradaException;
import co.edu.unbosque.util.exceptions.PlacaDeOtroPropietarioException;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;
import co.edu.unbosque.util.exceptions.PlacaNoEncontradaException;
import co.edu.unbosque.util.exceptions.PlacaYaRegistradaException;
import co.edu.unbosque.util.exceptions.PropietarioNoExisteException;
import co.edu.unbosque.util.exceptions.RegistroNoEncontradoException;
import co.edu.unbosque.util.exceptions.SoatVencidoException;
import co.edu.unbosque.util.exceptions.SobrecupoDeMensualidadesException;
import co.edu.unbosque.util.exceptions.SobrecupoParqueaderoException;
import co.edu.unbosque.util.exceptions.TelefonoInvalidoException;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;


/**
 * Controlador principal de la aplicación. Conecta las vistas con el modelo: asigna
 * los oyentes a los botones de cada panel y, según el comando recibido, valida
 * los datos ingresados, invoca la lógica del parqueadero y actualiza la vista.
 */
public class Controller implements ActionListener {
	
	// Visual
	/**
	 * Ventana principal donde se muestran los paneles.
	 */
	private MainFrame principal;
	/**
	 * Panel del menú principal.
	 */
	private PanelMenu pm;
	/**
	 * Panel con el formulario para registrar propietarios.
	 */
	private PanelPropietarioRegistrar ppRegistrar;
	/**
	 * Panel del submenú de propietarios.
	 */
	private PanelMenuPropietario pmPropietario;    
	/**
	 * Panel que lista los propietarios registrados.
	 */
	private PanelVerPropietarios pvPropietarios;  
	/**
	 * Panel del submenú de vehículos.
	 */
	private PanelMenuVehiculo pmVehiculo;
	/**
	 * Panel del submenú de mensualidades.
	 */
	private PanelMenuMensualidades pmMensualidad;
	/**
	 * Panel con el formulario para registrar mensualidades.
	 */
	private PanelMensualidadesRegistrar pmenRegistrar;
	/**
	 * Panel del submenú de consultas.
	 */
	private PanelMenuConsulta pmConsulta;
	/**
	 * Panel del submenú de reportes.
	 */
	private PanelMenuReportes pmReportes;
	/**
	 * Panel con el formulario de ingreso de vehículos.
	 */
	private PanelVehiculoRegistrar pvRegistrar;
	/**
	 * Panel con el formulario de salida de vehículos.
	 */
	private PanelVehiculoSalida pvSalida;
	/**
	 * Panel para consultar si un vehículo está parqueado.
	 */
	private PanelVehiculoParqueadero pvParqueadero;
	/**
	 * Panel que lista los vehículos parqueados y los cupos disponibles.
	 */
	private PanelVerParqueadero pvVerParqueadero;
	/**
	 * Panel que lista las mensualidades activas.
	 */
	private PanelVerMensualidades pmVerMensualidades;
	/**
	 * Panel que muestra las vacantes de mensualidades.
	 */
	private PanelMensualidadesVacantes pmVerMensualidadesVacantes;
	/**
	 * Panel que lista todos los registros de ingreso y salida.
	 */
	private PanelVerRegistros pmVerRegistros;
	/**
	 * Panel que lista todas las facturas.
	 */
	private PanelVerFacturas pmVerFacturas;
	/**
	 * Panel del reporte de vehículos que pasaron la noche.
	 */
	private PanelReportesNoche prReportesNoche;
	/**
	 * Panel del reporte de vehículos con más de 24 horas.
	 */
	private PanelReportes24h prReportes24h;
	/**
	 * Panel del reporte de dinero recaudado en el mes.
	 */
	private PanelReportesDineroMensual prReportesDineroMensual;
	/**
	 * Panel para buscar una factura por su número.
	 */
	private PanelBuscarFactura pbBuscarFactura;
	// DAO
	/**
	 * DAO encargado de la persistencia de los carros.
	 */
	private CarroDAO carroDAO;
	/**
	 * DAO encargado de la persistencia de las facturas.
	 */
	private FacturaDAO facturaDAO;
	/**
	 * DAO encargado de la persistencia de las mensualidades.
	 */
	private MensualidadDAO mensualidadDAO;
	/**
	 * DAO encargado de la persistencia de las motos.
	 */
	private MotoDAO motoDAO;
	/**
	 * DAO encargado de la persistencia de los propietarios.
	 */
	private PropietarioDAO propietarioDAO;
	/**
	 * DAO encargado de la persistencia de los registros.
	 */
	private RegistroDAO registroDAO;
	/**
	 * Ventana emergente para mostrar mensajes de error, éxito y confirmación.
	 */
	private VentanaEmergente ve;
	// Funcionalidad
	/**
	 * Lógica de negocio del parqueadero.
	 */
	private Parqueadero parqueadero;
	
	/**
	 * Construye el controlador, creando los paneles, los DAO y la instancia del
	 * parqueadero que gestiona la lógica del sistema.
	 */
	public Controller(){
	
		principal = new MainFrame();
		pm = new PanelMenu();
		ppRegistrar = new PanelPropietarioRegistrar();
		pmPropietario = new PanelMenuPropietario();     
		pvPropietarios = new PanelVerPropietarios(); 
		pmVehiculo = new PanelMenuVehiculo();
		pvRegistrar = new PanelVehiculoRegistrar();
		pvSalida = new PanelVehiculoSalida();
		pvParqueadero = new PanelVehiculoParqueadero();
		pvVerParqueadero = new PanelVerParqueadero();
		pmMensualidad = new PanelMenuMensualidades();
		pmenRegistrar = new PanelMensualidadesRegistrar();
		pmConsulta = new PanelMenuConsulta();
		pmReportes = new PanelMenuReportes();
		prReportesNoche = new PanelReportesNoche();
		prReportes24h = new PanelReportes24h();
		prReportesDineroMensual = new PanelReportesDineroMensual();
		pmVerMensualidades = new PanelVerMensualidades();
		pmVerMensualidadesVacantes = new PanelMensualidadesVacantes();
		pmVerRegistros = new PanelVerRegistros();
		pmVerFacturas = new PanelVerFacturas();
		pbBuscarFactura = new PanelBuscarFactura();
		
		ve = new VentanaEmergente();
		
		carroDAO = new CarroDAO();
		facturaDAO = new FacturaDAO();
		mensualidadDAO = new MensualidadDAO();
		motoDAO = new MotoDAO();
		propietarioDAO = new PropietarioDAO();
		registroDAO = new RegistroDAO();
		
		parqueadero = new Parqueadero(facturaDAO, mensualidadDAO, registroDAO);
	}

	/**
	 * Inicia la aplicación: reproduce la música de fondo, asigna los oyentes,
	 * muestra el menú principal y hace visible la ventana.
	 */
	public void start() {
		ReproducirAudio.reproducir("eShop.wav");
		asignarOyentes();
		principal.cambiarPanel(pm.getPanel());
		principal.setVisible(true);
		
	}

	/**
	 * Asigna a cada botón de los paneles su oyente (este controlador) y su comando
	 * de acción, para identificarlo en {@link #actionPerformed(ActionEvent)}.
	 */
	public void asignarOyentes() {
		
		pm.getBtnRegistrarPropietario().addActionListener(this);
		pm.getBtnRegistrarPropietario().setActionCommand("PROPIETARIO");
				
		pmPropietario.getBtnRegistrar().addActionListener(this);
		pmPropietario.getBtnRegistrar().setActionCommand("PROPIETARIO_REGISTRAR");

		pmPropietario.getBtnVer().addActionListener(this);
	    pmPropietario.getBtnVer().setActionCommand("VER_PROPIETARIOS");

		pmPropietario.getBtnVolver().addActionListener(this);
		pmPropietario.getBtnVolver().setActionCommand("VOLVER");
		
		ppRegistrar.getBtnRegistrar().addActionListener(this);
		ppRegistrar.getBtnRegistrar().setActionCommand("REGISTRAR_PROPIETARIO");

		ppRegistrar.getBtnVolver().addActionListener(this);
		ppRegistrar.getBtnVolver().setActionCommand("VOLVER_PROPIETARIO");   

		
		pvPropietarios.getBtnVolver().addActionListener(this);
		pvPropietarios.getBtnVolver().setActionCommand("VOLVER_PROPIETARIO");
		
		pm.getBtnVerVehiculos().addActionListener(this);
		pm.getBtnVerVehiculos().setActionCommand("VEHICULO");
		
		pvRegistrar.getBtnRegistrar().addActionListener(this);
		pvRegistrar.getBtnRegistrar().setActionCommand("REGISTRAR");
		
		pm.getBtnMensualidades().addActionListener(this);
		pm.getBtnMensualidades().setActionCommand("MENSUALIDADES");
		
		pmMensualidad.getBtnRegistrar().addActionListener(this);
		pmMensualidad.getBtnRegistrar().setActionCommand("MENSUALIDAD_REGISTRAR");

		pmenRegistrar.getBtnRegistrar().addActionListener(this);
		pmenRegistrar.getBtnRegistrar().setActionCommand("REGISTRAR_MENSUALIDAD");
		
		pmenRegistrar.getBtnVolver().addActionListener(this);
		pmenRegistrar.getBtnVolver().setActionCommand("MENSUALIDADES");
		
		pmMensualidad.getBtnVer().addActionListener(this);
		pmMensualidad.getBtnVer().setActionCommand("VER_MENSUALIDADES");

		pmMensualidad.getBtnVacantes().addActionListener(this);
		pmMensualidad.getBtnVacantes().setActionCommand("VACANTES_MENSUALIDADES");

		pmVerMensualidades.getBtnVolver().addActionListener(this);
		pmVerMensualidades.getBtnVolver().setActionCommand("MENSUALIDADES");

		pmVerMensualidadesVacantes.getBtnVolver().addActionListener(this);
		pmVerMensualidadesVacantes.getBtnVolver().setActionCommand("MENSUALIDADES");
		
		pm.getBtnConsultas().addActionListener(this);
		pm.getBtnConsultas().setActionCommand("CONSULTAS");
		
		pm.getBtnReportes().addActionListener(this);
		pm.getBtnReportes().setActionCommand("REPORTES");
		
		pm.getBtnSalir().addActionListener(this);
		pm.getBtnSalir().setActionCommand("SALIR");
		
		pmVehiculo.getBtnRegistrar().addActionListener(this);
		pmVehiculo.getBtnRegistrar().setActionCommand("VEHICULO_REGISTRAR");
		
		pmVehiculo.getBtnVolver().addActionListener(this);
		pmVehiculo.getBtnVolver().setActionCommand("VOLVER");
		
		pmVehiculo.getBtnSalida().addActionListener(this);
		pmVehiculo.getBtnSalida().setActionCommand("VEHICULO_SALIDA");

		pvSalida.getBtnRegistrarSalida().addActionListener(this);
		pvSalida.getBtnRegistrarSalida().setActionCommand("SALIDA_VEHICULO");

		pvSalida.getBtnVolver().addActionListener(this);
		pvSalida.getBtnVolver().setActionCommand("VOLVER_VEHICULO");	
		
		pvRegistrar.getBtnVolver().addActionListener(this);
		pvRegistrar.getBtnVolver().setActionCommand("VOLVER_VEHICULO");  
		
		pmVehiculo.getBtnParqueado().addActionListener(this);
		pmVehiculo.getBtnParqueado().setActionCommand("VEHICULO_PARQUEADO");

		pmVehiculo.getBtnVerParqueado().addActionListener(this);
		pmVehiculo.getBtnVerParqueado().setActionCommand("VER_PARQUEADO");
		
		pvParqueadero.getBtnConsultar().addActionListener(this);
		pvParqueadero.getBtnConsultar().setActionCommand("CONSULTAR_PARQUEADO");

		pvParqueadero.getBtnVolver().addActionListener(this);
		pvParqueadero.getBtnVolver().setActionCommand("VOLVER_VEHICULO");

		pvVerParqueadero.getBtnVolver().addActionListener(this);
		pvVerParqueadero.getBtnVolver().setActionCommand("VOLVER_VEHICULO");
		
		pmMensualidad.getBtnVolver().addActionListener(this);
		pmMensualidad.getBtnVolver().setActionCommand("VOLVER");
		
		pmConsulta.getBtnVolver().addActionListener(this);
		pmConsulta.getBtnVolver().setActionCommand("VOLVER");
		
		pmConsulta.getBtnVerRegistros().addActionListener(this);
		pmConsulta.getBtnVerRegistros().setActionCommand("VER_REGISTROS");
		
		pmVerRegistros.getBtnVolver().addActionListener(this);
		pmVerRegistros.getBtnVolver().setActionCommand("VOLVER_REGISTROS");
		
		pmConsulta.getBtnVerFacturas().addActionListener(this);
		pmConsulta.getBtnVerFacturas().setActionCommand("VER_FACTURAS");
		
		pmVerFacturas.getBtnVolver().addActionListener(this);
		pmVerFacturas.getBtnVolver().setActionCommand("VOLVER_FACTURAS");
		
		pmConsulta.getBtnBuscarFactura().addActionListener(this);
		pmConsulta.getBtnBuscarFactura().setActionCommand("BUSCAR_FACTURA");
		
		pbBuscarFactura.getBtnConsultar().addActionListener(this);
		pbBuscarFactura.getBtnConsultar().setActionCommand("CONSULTAR_FACTURA");
		
		pbBuscarFactura.getBtnVolver().addActionListener(this);
		pbBuscarFactura.getBtnVolver().setActionCommand("VOLVER_FACTURAS");
		
		pmConsulta.getBtnUltimaFactura().addActionListener(this);
		pmConsulta.getBtnUltimaFactura().setActionCommand("ULTIMA_FACTURA");
		
		pmReportes.getBtnVolver().addActionListener(this);
		pmReportes.getBtnVolver().setActionCommand("VOLVER");
		
		pmReportes.getBtnVehiculosNoche().addActionListener(this);
		pmReportes.getBtnVehiculosNoche().setActionCommand("REPORTE_NOCHE");

		pmReportes.getBtnVehiculos24h().addActionListener(this);
		pmReportes.getBtnVehiculos24h().setActionCommand("REPORTE_24H");

		pmReportes.getBtnDineroMensual().addActionListener(this);
		pmReportes.getBtnDineroMensual().setActionCommand("REPORTE_DINERO");

		prReportesNoche.getBtnVolver().addActionListener(this);
		prReportesNoche.getBtnVolver().setActionCommand("REPORTES");

		prReportes24h.getBtnVolver().addActionListener(this);
		prReportes24h.getBtnVolver().setActionCommand("REPORTES");

		prReportesDineroMensual.getBtnVolver().addActionListener(this);
		prReportesDineroMensual.getBtnVolver().setActionCommand("REPORTES");
		
	}

	/**
	 * Atiende los eventos de los botones. Según el comando de acción, cambia de
	 * panel, valida los datos de los formularios, registra propietarios, vehículos,
	 * mensualidades y salidas, y muestra consultas y reportes. Los errores de
	 * validación se muestran al usuario mediante ventanas emergentes.
	 *
	 * @param e Evento de acción generado por el botón presionado.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();

		switch (cmd) {
		
		case "PROPIETARIO":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmPropietario.getPanel());
			break;
		case "PROPIETARIO_REGISTRAR":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(ppRegistrar.getPanel());
			break;
		case "VOLVER_PROPIETARIO":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmPropietario.getPanel());
			break;
		case "VER_PROPIETARIOS":
			ReproducirAudio.reproducirSFX("Click.wav");
			pvPropietarios.getLblTotalPropietarios().setText(
					"Total de Propietarios: " + propietarioDAO.darLista().size());

			StringBuilder listaProp = new StringBuilder();
			for (Propietario p : propietarioDAO.darLista()) {
				listaProp.append("| Documento: ").append(p.getDocumento())
						.append("\n| Nombre: ").append(p.getNombre())
						.append("\n| Telefono: ").append(p.getTelefono())
						.append("\n\n");
			}
			String txt = "";
			
			if(listaProp.length() == 0) txt = " No hay propietarios registrados.";
			else txt = listaProp.toString();
			pvPropietarios.getAreaPropietarios().setText(txt);

			principal.cambiarPanel(pvPropietarios.getPanel());
			break;
		case "REGISTRAR_PROPIETARIO":
			try {
				String documento = ppRegistrar.getTxtfieldDocumento().getText().trim();
				String nombre = ppRegistrar.getTxtfieldNombre().getText().trim();
				String telefono = ppRegistrar.getTxtfieldTelefono().getText().trim();
				
				if(documento.isBlank()) throw new DatoVacioException("Documento.");
				if(!documento.matches("\\d+") || documento.length() != 10) throw new DocumentoInvalidoException();
				if(nombre.isBlank()) throw new DatoVacioException("Nombre. ");
				if(telefono.isBlank()) throw new DatoVacioException("Telefono. ");
				if(!telefono.matches("\\d+") || telefono.length() != 10) throw new TelefonoInvalidoException();
				
				if (propietarioDAO.existeDocumento(documento)) {
					ReproducirAudio.reproducirSFX("Error.wav");
					ve.mostrarERROR("[ERROR] Ya existe un propietario registrado con el documento: " + documento, "ERROR");
					break;
				}

				PropietarioDTO propDTO = new PropietarioDTO(documento,nombre,telefono);
				propietarioDAO.crear(propDTO);
				
				ReproducirAudio.reproducirSFX("Success.wav");
				ve.mostrarSUCCESS("Propietario " + nombre + " registrado correctamente.");
				ppRegistrar.getTxtfieldDocumento().setText("");
				ppRegistrar.getTxtfieldNombre().setText("");
				ppRegistrar.getTxtfieldTelefono().setText("");
			
			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (DocumentoInvalidoException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (TelefonoInvalidoException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			}
			break;
		
		case "VEHICULO":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmVehiculo.getPanel());
			break;
		case "VEHICULO_REGISTRAR":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pvRegistrar.getPanel());
			break;	
		case "REGISTRAR":
			try {
				
				String placa = pvRegistrar.getTxtfieldPlaca().getText().trim().toUpperCase();
				String tipoV = pvRegistrar.getBoxTiposVehiculo().getSelectedItem().toString();
				String documento = pvRegistrar.getTxtfieldPropietarioDoc().getText();
				String fechaSoat = pvRegistrar.getTxtfieldSOAT().getText().trim();
				String tipoTarifa = pvRegistrar.getBoxTarifa().getSelectedItem().toString();
				
				if (placa.isBlank()) throw new DatoVacioException("Placa.");
				if (documento.isBlank()) throw new DatoVacioException("Documento.");
				if (fechaSoat.isBlank()) throw new DatoVacioException("Fecha del SOAT.");
				
				LocalDate soat = LocalDate.parse(fechaSoat);
				if (!soat.isAfter(LocalDate.now())) throw new SoatVencidoException();
				
				boolean nocturna;
				if(tipoTarifa.equals("Por hora")) nocturna = false;
				else nocturna = true;
				
				if (propietarioDAO.existeDocumento(documento)) {
					
                    Propietario p = propietarioDAO.buscarPorDocumento(documento);
                    
                    if (tipoV.equals("Carro")) {
                    	Carro existe = carroDAO.buscarPorPlaca(placa);
                    	if(existe == null) {
                    		CarroDTO carro = new CarroDTO();
                    		carro.setPlaca(placa);
                    		carro.setPropietario(p);
                    		carro.setVencimientoSoat(soat);
                    		carroDAO.crear(carro);
                    		parqueadero.ingresarVehiculo(carro, nocturna); 
                    	} else {
                    		 if (!existe.getPropietario().getDocumento().equals(documento)) {
                    			  throw new PlacaDeOtroPropietarioException();
                    		 }         
                             parqueadero.ingresarVehiculo(existe, nocturna);
                             existe.setVencimientoSoat(soat);              
                             carroDAO.escribirArchivoSerializado();
                    	} 
                    } else {
                    	Moto existe = motoDAO.buscarPorPlaca(placa);
                    	if(existe == null) {
                    		MotoDTO moto = new MotoDTO();
                    		moto.setPlaca(placa);
                    		moto.setPropietario(p);
                    		moto.setVencimientoSoat(soat);
                    		motoDAO.crear(moto);
                    		parqueadero.ingresarVehiculo(moto, nocturna); 
                    	} else {
                    		 if (!existe.getPropietario().getDocumento().equals(documento)) {
                    			 throw new PlacaDeOtroPropietarioException();
                    		 }        
                             parqueadero.ingresarVehiculo(existe, nocturna);
                             existe.setVencimientoSoat(soat);               
                             motoDAO.escribirArchivoSerializado();
                    	}
                    }
                } else throw new PropietarioNoExisteException();
				
                ReproducirAudio.reproducirSFX("Success.wav");
				ve.mostrarSUCCESS(tipoV + " " + placa + " registrado.");
				pvRegistrar.getTxtfieldPlaca().setText("");
				pvRegistrar.getTxtfieldPropietarioDoc().setText("");
				pvRegistrar.getTxtfieldSOAT().setText("");
				
			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaInvalidaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");	
			} catch (DateTimeParseException  ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR("La fecha debe tener el formato. (AAAA-MM-DD)", "ERROR");
			} catch(PropietarioNoExisteException ex) {
                ReproducirAudio.reproducirSFX("Error.wav");
                ve.mostrarERROR(ex.getMessage(), "ERROR");
            } catch (PlacaYaRegistradaException ex) {
            	ReproducirAudio.reproducirSFX("Error.wav");
			    ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (SobrecupoParqueaderoException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			}  catch (SoatVencidoException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaDeOtroPropietarioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			}

			break;
		case "VEHICULO_SALIDA":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pvSalida.getPanel());
			break;
		case "SALIDA_VEHICULO":
			try {
				
				String placaSalida = pvSalida.getTxtfieldPlaca().getText().trim().toUpperCase();
				
				if (placaSalida.isBlank()) throw new DatoVacioException("Placa.");
				
				placaSalida = Vehiculo.validarPlaca(placaSalida);
				
				FacturaDTO factura = parqueadero.salidaVehiculo(placaSalida);
				
				ReproducirAudio.reproducirSFX("Success.wav");
				
				ve.mostrarSUCCESS(
						"Salida registrada correctamente\n"
						+ "Factura #" + factura.getNum() + "\n"
						+ "Placa: " + factura.getPlaca() + "\n"
						+ "Propietario: " + factura.getNombrePropietario() + "\n"
						+ "Forma de cobro: " + factura.getFormaDeCobro() + "\n"
						+ "Total a pagar: $" + factura.getValor()
					);
					pvSalida.getTxtfieldPlaca().setText("");
			
			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaInvalidaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");	
			} catch (PlacaNoEncontradaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (RegistroNoEncontradoException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");	
			}
			break;
		case "VEHICULO_PARQUEADO":
			ReproducirAudio.reproducirSFX("Click.wav");
			pvParqueadero.getTxtfieldPlaca().setText("");
			pvParqueadero.getLblEstado().setText("");
			pvParqueadero.getLblPropietario().setText("");
			principal.cambiarPanel(pvParqueadero.getPanel());
			break;
		case "CONSULTAR_PARQUEADO":
			try {
				
				String placa = pvParqueadero.getTxtfieldPlaca().getText().trim().toUpperCase();
				if (placa.isBlank()) throw new DatoVacioException("Placa.");

				Registro reg = parqueadero.buscarRegistro(placa);
				ReproducirAudio.reproducirSFX("Success.wav");
				pvParqueadero.getLblEstado().setText("Parqueado");
				pvParqueadero.getLblPropietario().setText(reg.getVehiculo().getPropietario().getNombre());
			
			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (RegistroNoEncontradoException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				pvParqueadero.getLblEstado().setText("No está parqueado");
				pvParqueadero.getLblPropietario().setText("-");
			}
			break;
		case "VER_PARQUEADO":
            ReproducirAudio.reproducirSFX("Click.wav");
            pvVerParqueadero.getLblCuposDisponibles().setText(
                "Parqueaderos disponibles: " + parqueadero.espaciosDisponibles() + " / 200"
            );

            StringBuilder listado = new StringBuilder();

            java.time.format.DateTimeFormatter formatoHora = java.time.format.DateTimeFormatter.ofPattern("HH:mm");

            for (Registro r : parqueadero.registrosActivos()) {
            	
                listado.append(" | Placa: ").append(r.getVehiculo().getPlaca())
                       .append(" | Propietario: ").append(r.getVehiculo().getPropietario().getNombre())
                       .append("\n")
                       .append(" | Fecha: ").append(r.getHoraIngreso().toLocalDate())
                       .append(" | Hora: ").append(r.getHoraIngreso().format(formatoHora))
                       .append("\n\n");
            }
            if (listado.length() == 0) {
                pvVerParqueadero.getAreaVehiculos().setText("No hay vehículos parqueados actualmente.");
            } else {
                pvVerParqueadero.getAreaVehiculos().setText(listado.toString());
            }

            principal.cambiarPanel(pvVerParqueadero.getPanel());
            break;
		case "VOLVER_VEHICULO":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmVehiculo.getPanel());
			break; 
		case "MENSUALIDADES":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmMensualidad.getPanel());
			break;
		case "MENSUALIDAD_REGISTRAR":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmenRegistrar.getPanel());
			break;
		case "REGISTRAR_MENSUALIDAD":
			try {
				String nombre = pmenRegistrar.getTxtfieldPropietarioNom().getText().trim();
				String documento = pmenRegistrar.getTxtfieldPropietarioDoc().getText().trim();
				String placa = pmenRegistrar.getTxtfieldPlaca().getText().trim().toUpperCase();
				String tipoV = pmenRegistrar.getBoxTiposVehiculo().getSelectedItem().toString();

				if (nombre.isBlank()) throw new DatoVacioException("Nombre del propietario.");
				if (documento.isBlank()) throw new DatoVacioException("Documento del propietario.");
				if (placa.isBlank()) throw new DatoVacioException("Placa.");

				placa = Vehiculo.validarPlaca(placa);
				if (!propietarioDAO.existeDocumento(documento)) throw new PropietarioNoExisteException();

				parqueadero.registrarMensualidad(documento, nombre, placa, tipoV, propietarioDAO, carroDAO, motoDAO);

				ReproducirAudio.reproducirSFX("Success.wav");
				ve.mostrarSUCCESS("Mensualidad registrada para " + tipoV + " " + placa + ".");
				pmenRegistrar.getTxtfieldPropietarioNom().setText("");
				pmenRegistrar.getTxtfieldPropietarioDoc().setText("");
				pmenRegistrar.getTxtfieldPlaca().setText("");

			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaInvalidaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PropietarioNoExisteException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaYaRegistradaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (SobrecupoDeMensualidadesException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaNoEncontradaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaDeOtroPropietarioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			}
			break;
		case "VER_MENSUALIDADES":
			ReproducirAudio.reproducirSFX("Click.wav");
			pmVerMensualidades.getLblTotalMensualidades().setText(
					"Mensualidades activas: " + mensualidadDAO.darLista().size()
					+ " | Vehículos suscritos: " + parqueadero.vehiculosMensualidad()
					);
			
			StringBuilder listaMen = new StringBuilder();
			for (Mensualidad m : mensualidadDAO.darLista()) {
				listaMen.append("| Propietario: ").append(m.getPropietario().getNombre())
				        .append(" (Doc: ").append(m.getPropietario().getDocumento()).append(")")
				        .append("\n| Inicio: ").append(m.getFechaInicio())
				        .append("\n| Valor: $").append(m.getValor())
				        .append("\n| Vehículos: ");
				
				for (Vehiculo v : m.getVehiculos()) {
					listaMen.append("[")
					.append(v.getPlaca()).append(" - ").append(v.getTipo())
					.append("] ");
				}
				listaMen.append("\n\n");
			}
			
			String txtMen = "";
			if (listaMen.length() == 0) txtMen = "No hay mensualidades registradas."; 
			else txtMen = listaMen.toString();
			
			pmVerMensualidades.getAreaMensualidades().setText(txtMen);
				principal.cambiarPanel(pmVerMensualidades.getPanel());
			break;
		case "VACANTES_MENSUALIDADES":
			ReproducirAudio.reproducirSFX("Click.wav");
			int maxCupos = parqueadero.cupoMaximoMensualidades();
			int ocupados = parqueadero.vehiculosMensualidad();
			int disponibles = parqueadero.espaciosDisponiblesMensualidad();

			pmVerMensualidadesVacantes.getLblVacantesDisponibles().setText(
				"Vacantes disponibles: " + disponibles + " / " + maxCupos
			);
			pmVerMensualidadesVacantes.getLblCuposOcupados().setText(
				"Cupos ocupados: " + ocupados
			);
			pmVerMensualidadesVacantes.getAreaVacantes().setText(
				"Capacidad total del parqueadero: 200 puestos\n"
				+ "Cupo máximo mensualidades (30%): " + maxCupos + " vehículos\n"
				+ "Vehículos con mensualidad activa: " + ocupados + "\n"
				+ "Cupos libres para nuevas mensualidades: " + disponibles
			);
			principal.cambiarPanel(pmVerMensualidadesVacantes.getPanel());
			break;
		case "CONSULTAS":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmConsulta.getPanel());
			break;
		case "VER_REGISTROS":
			ReproducirAudio.reproducirSFX("Click.wav");
			pmVerRegistros.getLblTotalRegistros().setText(
					"Total de Registros: " + registroDAO.darLista().size());
			
			StringBuilder listaReg = new StringBuilder();
			formatoHora = java.time.format.DateTimeFormatter.ofPattern("HH:mm");
			
			for (Registro r : registroDAO.darLista()) {
				
				String mensualidad;
				if (r.isPagaMensualidad()) mensualidad = "Si";
				else mensualidad = "No";
				
				String estado;
				if(r.isActivo()) estado = "Activo";
				else estado = "Finalizado";
				
				String salida;
				if(r.getHoraSalida() == null) salida = "Aun en el Parqueadero";
				else salida = r.getHoraSalida().format(formatoHora);
				
				listaReg.append("| Vehiculo: ").append(r.getVehiculo().getPlaca())
				        .append(" (").append(r.getVehiculo().getTipo()).append(")")
				        .append("\n| Ingreso: ").append(r.getHoraIngreso().format(formatoHora))
				        .append("\n| Salida: ").append(salida)
				        .append("\n| Mensualidad: ").append(mensualidad)
				        .append(" | Estado: ").append(estado);
				listaReg.append("\n\n");
			}

			if (listaReg.length() == 0) {
                pmVerRegistros.getAreaRegistros().setText("No hay Registros actualmente.");
            } else {
                pmVerRegistros.getAreaRegistros().setText(listaReg.toString());
            }
			principal.cambiarPanel(pmVerRegistros.getPanel());
			break;
		case "VOLVER_REGISTROS":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmConsulta.getPanel());
			break;
		case "VER_FACTURAS":
			ReproducirAudio.reproducirSFX("Click.wav");
			pmVerFacturas.getLblTotalFacturas().setText(
					"Total de Facturas: " + facturaDAO.darLista().size());
			
			StringBuilder listaFac = new StringBuilder(); 
			formatoHora = java.time.format.DateTimeFormatter.ofPattern("HH:mm");
			
			for (Factura f : facturaDAO.darLista()) {
				listaFac.append("| Factura #").append(f.getNum())
				        .append("\n| Placa: ").append(f.getPlaca())
				        .append(" | Propietario: ").append(f.getNombrePropietario())
				        .append("\n| Ingreso: ").append(f.getHoraIngreso().format(formatoHora))
				        .append(" | Salida: ").append(f.getHoraSalida().format(formatoHora))
				        .append("\n| Forma de cobro: ").append(f.getFormaDeCobro())
				        .append(" | Valor: $").append(f.getValor());
				listaFac.append("\n\n");
			}

			if (listaFac.length() == 0) {
                pmVerFacturas.getAreaFacturas().setText("No hay Facturas actualmente.");
            } else {
                pmVerFacturas.getAreaFacturas().setText(listaFac.toString());
            }

			principal.cambiarPanel(pmVerFacturas.getPanel());
			break;
		case "VOLVER_FACTURAS":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmConsulta.getPanel());
			break;
		case "BUSCAR_FACTURA":
			ReproducirAudio.reproducirSFX("Click.wav");
			pbBuscarFactura.getTxtfieldID().setText("");;
			principal.cambiarPanel(pbBuscarFactura.getPanel());
			break;
		case "ULTIMA_FACTURA":
			try{
			int idUltima = facturaDAO.darLista().size()-1;
			Factura ultimaFactura = parqueadero.buscarFactura(idUltima);

			ReproducirAudio.reproducirSFX("Success.wav");
			formatoHora = java.time.format.DateTimeFormatter.ofPattern("HH:mm");
			
			ve.mostrarSUCCESS(
					"Factura encontrada\n"
					+ "Factura #" + ultimaFactura.getNum() + "\n"
					+ "Placa: " + ultimaFactura.getPlaca() + "\n"
					+ "Propietario: " + ultimaFactura.getNombrePropietario() + "\n"
					+ "Hora de Ingreso: " + ultimaFactura.getHoraIngreso().format(formatoHora) + "\n"
					+ "Hora de Salida: " + ultimaFactura.getHoraSalida().format(formatoHora) + "\n"
					+ "Forma de cobro: " + ultimaFactura.getFormaDeCobro() + "\n"
					+ "Total pagado: $" + ultimaFactura.getValor()
				);
		} catch (FacturaNoEncontradaException ex) {
			ReproducirAudio.reproducirSFX("Error.wav");
			ve.mostrarERROR(ex.getMessage(), "ERROR");
		}
			break;
		case "CONSULTAR_FACTURA":
			try {

				String textoId = pbBuscarFactura.getTxtfieldID().getText().trim();

				if (textoId.isBlank()) throw new DatoVacioException("ID de la factura.");

				int idFactura = Integer.parseInt(textoId);

				Factura factura = parqueadero.buscarFactura(idFactura);

				ReproducirAudio.reproducirSFX("Success.wav");

				ve.mostrarSUCCESS(
						"Factura encontrada\n"
						+ "Factura #" + factura.getNum() + "\n"
						+ "Placa: " + factura.getPlaca() + "\n"
						+ "Propietario: " + factura.getNombrePropietario() + "\n"
						+ "Hora de Ingreso: " + factura.getHoraIngreso() + "\n"
						+ "Hora de Salida: " + factura.getHoraSalida() + "\n"
						+ "Forma de cobro: " + factura.getFormaDeCobro() + "\n"
						+ "Total pagado: $" + factura.getValor()
					);
				pbBuscarFactura.getTxtfieldID().setText("");

			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (NumberFormatException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR("El ID de la factura debe ser un número entero.", "ERROR");
			} catch (FacturaNoEncontradaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			}
			break;
		case "REPORTES":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmReportes.getPanel());
			break;
		case "REPORTE_NOCHE":
			ReproducirAudio.reproducirSFX("Click.wav");
			ArrayList<Registro> reporteNoche = parqueadero.vehiculosQuePasaronLaNoche();

			if (reporteNoche.isEmpty()) {
				prReportesNoche.getLblResumen().setText("Total vehículos: 0");
				prReportesNoche.getAreaReporte().setText("No hay vehículos que hayan pasado la noche en el parqueadero.");
			} 
			else {
				prReportesNoche.getLblResumen().setText("Total vehículos: " + reporteNoche.size());
				StringBuilder sbNoche = new StringBuilder();
				for (Registro r : reporteNoche) {
					sbNoche.append("Placa: ").append(r.getVehiculo().getPlaca())
					       .append(" | Propietario: ").append(r.getVehiculo().getPropietario().getNombre())
					       .append(" | Ingreso: ").append(r.getHoraIngreso())
					       .append("\n");
				}
				prReportesNoche.getAreaReporte().setText(sbNoche.toString());
			}
			principal.cambiarPanel(prReportesNoche.getPanel());
			break;
		case "REPORTE_24H":
			ReproducirAudio.reproducirSFX("Click.wav");
			ArrayList<Registro> lista24h = parqueadero.vehiculosMasDe24Horas();
			prReportes24h.getLblTotal().setText("Total vehículos: " + lista24h.size());

			StringBuilder sb24 = new StringBuilder();
			for (Registro r : lista24h) {
				sb24.append("Placa: ").append(r.getVehiculo().getPlaca())
				    .append(" | Propietario: ").append(r.getVehiculo().getPropietario().getNombre())
				    .append(" | Ingreso: ").append(r.getHoraIngreso())
				    .append("\n");
			}
			
			if (sb24.length() == 0) {
				prReportes24h.getAreaReporte().setText("No hay vehículos por hora con más de 24 horas de estancia");
			} 
			else {
				prReportes24h.getAreaReporte().setText(sb24.toString());
			}
			principal.cambiarPanel(prReportes24h.getPanel());
			break;
		case "REPORTE_DINERO":
			ReproducirAudio.reproducirSFX("Click.wav");
			String mesActual = java.time.YearMonth.now().toString();
			double totalMes = parqueadero.dineroRecaudadoMes();

			prReportesDineroMensual.getLblTotalRecaudado().setText("$" + totalMes);
			prReportesDineroMensual.getAreaDetalle().setText(
				"Periodo: " + mesActual + "\n"
				+ "Total recaudado en el mes: $" + totalMes
			);

			principal.cambiarPanel(prReportesDineroMensual.getPanel());
			break; 
		case "VOLVER":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pm.getPanel());
			break;
		case "SALIR":
			ReproducirAudio.reproducirSFX("Click.wav");
			int r = ve.preguntarSiNo("¿Desea Salir Del Programa?", "CONFIRMACION");
			if(r == 0) System.exit(0);
			break;
		}
	}

}