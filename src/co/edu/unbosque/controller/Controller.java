package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.DatoVacioException;
import co.edu.unbosque.util.exceptions.DocumentoInvalidoException;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;
import co.edu.unbosque.util.exceptions.PlacaNoEncontradaException;
import co.edu.unbosque.util.exceptions.PlacaYaRegistradaException;
import co.edu.unbosque.util.exceptions.PropietarioNoExisteException;
import co.edu.unbosque.util.exceptions.RegistroNoEncontradoException;
import co.edu.unbosque.util.exceptions.SoatVencidoException;
import co.edu.unbosque.util.exceptions.SobrecupoDeMensualidadesException;
import co.edu.unbosque.util.exceptions.SobrecupoParqueaderoException;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;


public class Controller implements ActionListener {
	
	// Visual
	private MainFrame principal;
	private PanelMenu pm;
	private PanelPropietarioRegistrar ppRegistrar;
	private PanelMenuVehiculo pmVehiculo;
	private PanelMenuMensualidades pmMensualidad;
	private PanelMensualidadesRegistrar pmenRegistrar;
	private PanelMenuConsulta pmConsulta;
	private PanelMenuReportes pmReportes;
	private PanelVehiculoRegistrar pvRegistrar;
	private PanelVehiculoSalida pvSalida;
	private PanelVehiculoParqueadero pvParqueadero;
	private PanelVerParqueadero pvVerParqueadero;
	private PanelVerMensualidades pmVerMensualidades;
	private PanelMensualidadesVacantes pmVerMensualidadesVacantes;
	// DAO
	private CarroDAO carroDAO;
	private FacturaDAO facturaDAO;
	private MensualidadDAO mensualidadDAO;
	private MotoDAO motoDAO;
	private PropietarioDAO propietarioDAO;
	private RegistroDAO registroDAO;
	private VentanaEmergente ve;
	// Funcionalidad
	private Parqueadero parqueadero;
	
	public Controller(){
	
		principal = new MainFrame();
		pm = new PanelMenu();
		ppRegistrar = new PanelPropietarioRegistrar();
		pmVehiculo = new PanelMenuVehiculo();
		pvRegistrar = new PanelVehiculoRegistrar();
		pvSalida = new PanelVehiculoSalida();
		pvParqueadero = new PanelVehiculoParqueadero();
		pvVerParqueadero = new PanelVerParqueadero();
		pmMensualidad = new PanelMenuMensualidades();
		pmenRegistrar = new PanelMensualidadesRegistrar();
		pmConsulta = new PanelMenuConsulta();
		pmReportes = new PanelMenuReportes();
		pmVerMensualidades = new PanelVerMensualidades();
		pmVerMensualidadesVacantes = new PanelMensualidadesVacantes();
		
		ve = new VentanaEmergente();
		
		carroDAO = new CarroDAO();
		facturaDAO = new FacturaDAO();
		mensualidadDAO = new MensualidadDAO();
		motoDAO = new MotoDAO();
		propietarioDAO = new PropietarioDAO();
		registroDAO = new RegistroDAO();
		
		parqueadero = new Parqueadero(facturaDAO, mensualidadDAO, registroDAO);
	}

	public void start() {
		asignarOyentes();
		principal.cambiarPanel(pm.getPanel());
		principal.setVisible(true);
		
	}

	public void asignarOyentes() {
		pm.getBtnRegistrarPropietario().addActionListener(this);
		pm.getBtnRegistrarPropietario().setActionCommand("PROPIETARIO");
		
		ppRegistrar.getBtnRegistrar().addActionListener(this);
		ppRegistrar.getBtnRegistrar().setActionCommand("REGISTRAR_PROPIETARIO");
		
		ppRegistrar.getBtnVolver().addActionListener(this);
		ppRegistrar.getBtnVolver().setActionCommand("VOLVER");
		
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
		pvSalida.getBtnVolver().setActionCommand("VOLVER");
		
		pvRegistrar.getBtnVolver().addActionListener(this);
		pvRegistrar.getBtnVolver().setActionCommand("VOLVER");
		
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
		
		pmReportes.getBtnVolver().addActionListener(this);
		pmReportes.getBtnVolver().setActionCommand("VOLVER");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();

		switch (cmd) {
		
		case "PROPIETARIO":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(ppRegistrar.getPanel());
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
				
				if (propietarioDAO.existeDocumento(documento)) {
					ReproducirAudio.reproducirSFX("Error.wav");
					ve.mostrarERROR("[ERROR] Ya existe un propietario registrado con el documento: " + documento, "ERROR");
					break;
				}

				PropietarioDTO propDTO = new PropietarioDTO(documento,nombre,telefono);
				Propietario prop = new Propietario(documento,nombre,telefono);
				propietarioDAO.crear(propDTO);
				
				ReproducirAudio.reproducirSFX("Success.wav");
				ve.mostrar("Propietario " + nombre + " registrado correctamente.");
				ppRegistrar.getTxtfieldDocumento().setText("");
				ppRegistrar.getTxtfieldNombre().setText("");
				ppRegistrar.getTxtfieldTelefono().setText("");
			
			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (DocumentoInvalidoException ex) {
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
				if (!documento.matches("\\d+") || documento.length() != 10) throw new DocumentoInvalidoException();
				if (documento.isBlank()) throw new DatoVacioException("Documento.");
				if (fechaSoat.isBlank()) throw new DatoVacioException("Fecha del SOAT.");
				
				LocalDate soat = LocalDate.parse(fechaSoat);
				if (!soat.isAfter(LocalDate.now())) throw new SoatVencidoException();
				
				boolean nocturna;
				if(tipoTarifa.equals("Por Hora")) nocturna = false;
				else nocturna = true;
				
				if (propietarioDAO.existeDocumento(documento)) {
                    Propietario p = propietarioDAO.buscarPorDocumento(documento);
                    
                    if (tipoV.equals("Carro")) {
                        CarroDTO carro = new CarroDTO();
                        carro.setPlaca(placa);
                        carro.setPropietario(p);
                        carro.setVencimientoSoat(soat);
                        carroDAO.crear(carro);
                        parqueadero.ingresarVehiculo(carro, nocturna); 
                        
                    } else {
                        MotoDTO moto = new MotoDTO();
                        moto.setPlaca(placa);
                        moto.setPropietario(p);
                        moto.setVencimientoSoat(soat);
                        parqueadero.ingresarVehiculo(moto, nocturna); 
                        motoDAO.crear(moto);
                    }
                }else throw new PropietarioNoExisteException();
                ReproducirAudio.reproducirSFX("Success.wav");
				ve.mostrar(tipoV + " " + placa + " registrado.");
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
			} catch (Exception ex) {
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
				
				ve.mostrar(
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
			
			for (Registro r : parqueadero.registrosActivos()) {
				listado.append("Placa: ").append(r.getVehiculo().getPlaca())
				       .append(" | Propietario: ").append(r.getVehiculo().getPropietario().getNombre())
				       .append(" | Ingreso: ").append(r.getHoraIngreso())
				       .append("\n");
			}
			pvVerParqueadero.getAreaVehiculos().setText(
				listado.length() == 0 ? "No hay vehículos parqueados actualmente." : listado.toString()
			);
			
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
				
				parqueadero.registrarMensualidad(documento, nombre, placa, tipoV, propietarioDAO, carroDAO, motoDAO);
				
				ReproducirAudio.reproducirSFX("Success.wav");
				ve.mostrar("Mensualidad registrada para " + tipoV + " " + placa + ".");
				pmenRegistrar.getTxtfieldPropietarioNom().setText("");
				pmenRegistrar.getTxtfieldPropietarioDoc().setText("");
				pmenRegistrar.getTxtfieldPlaca().setText("");
			
			} catch (DatoVacioException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaInvalidaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (PlacaYaRegistradaException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (SobrecupoDeMensualidadesException ex) {
				ReproducirAudio.reproducirSFX("Error.wav");
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			}
			break;
		case "CONSULTAS":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmConsulta.getPanel());
			break;
		case "REPORTES":
			ReproducirAudio.reproducirSFX("Click.wav");
			principal.cambiarPanel(pmReportes.getPanel());
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
