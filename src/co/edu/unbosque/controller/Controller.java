package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.DatoVacioException;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;
import co.edu.unbosque.util.exceptions.PlacaYaRegistradaException;
import co.edu.unbosque.util.exceptions.PropietarioNoExisteException;
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
		pmMensualidad = new PanelMenuMensualidades();
		pmenRegistrar = new PanelMensualidadesRegistrar();
		pmConsulta = new PanelMenuConsulta();
		pmReportes = new PanelMenuReportes();
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
		
		pvRegistrar.getBtnVolver().addActionListener(this);
		pvRegistrar.getBtnVolver().setActionCommand("VOLVER");
		
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
				
				if(documento.isBlank()) throw new DatoVacioException("Documento. ");
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
                        registroDAO.crear(parqueadero.ingresarVehiculo(carro, nocturna)); 
                        
                    } else {
                        MotoDTO moto = new MotoDTO();
                        moto.setPlaca(placa);
                        moto.setPropietario(p);
                        moto.setVencimientoSoat(soat);
                        registroDAO.crear(parqueadero.ingresarVehiculo(moto, nocturna)); 
                        parqueadero.ingresarVehiculo(moto, nocturna);
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
			    ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (SobrecupoParqueaderoException ex) {
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (Exception ex) {
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} 

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
