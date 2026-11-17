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
	private PanelVerRegistros pmVerRegistros;
	private PanelVerFacturas pmVerFacturas;
	private PanelReportesNoche prReportesNoche;
	private PanelReportes24h prReportes24h;
	private PanelReportesDineroMensual prReportesDineroMensual;
	private PanelBuscarFactura pbBuscarFactura;
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

	public void start() {
		ReproducirAudio.reproducir("eShop.wav");
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
                listado.append("Placa: ").append(r.getVehiculo().getPlaca())
                       .append(" | Propietario: ").append(r.getVehiculo().getPropietario().getNombre())
                       .append(" | Fecha: ").append(r.getHoraIngreso().toLocalDate())
                       .append(" | Hora: ").append(r.getHoraIngreso().format(formatoHora))
                       .append("\n");
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
				listaMen.append("Propietario: ").append(m.getPropietario().getNombre())
				        .append(" (Doc: ").append(m.getPropietario().getDocumento()).append(")")
				        .append(" | Inicio: ").append(m.getFechaInicio())
				        .append(" | Valor: $").append(m.getValor())
				        .append("\n   Vehículos: ");
				
				for (Vehiculo v : m.getVehiculos()) {
					listaMen.append("[").append(v.getPlaca()).append(" - ").append(v.getTipo()).append("] ");
				}
				listaMen.append("\n\n");
			}
			
			pmVerMensualidades.getAreaMensualidades().setText(
					listaMen.length() == 0 ? "No hay mensualidades registradas." : listaMen.toString()
				);
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
			for (Registro r : registroDAO.darLista()) {
				listaReg.append("Vehículo: ").append(r.getVehiculo().getPlaca())
				        .append(" (").append(r.getVehiculo().getTipo()).append(")")
				        .append(" | Ingreso: ").append(r.getHoraIngreso())
				        .append(" | Salida: ").append(r.getHoraSalida() == null ? "Aún en el parqueadero" : r.getHoraSalida())
				        .append("\n   Mensualidad: ").append(r.isPagaMensualidad() ? "Sí" : "No")
				        .append(" | Estado: ").append(r.isActivo() ? "Activo" : "Finalizado");
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
					"Total de Facturas: " + registroDAO.darLista().size());
			
			StringBuilder listaFac = new StringBuilder();
			for (Factura f : facturaDAO.darLista()) {
				listaFac.append("Factura N° ").append(f.getNum())
				        .append(" | Placa: ").append(f.getPlaca())
				        .append(" | Propietario: ").append(f.getNombrePropietario())
				        .append("\n   Ingreso: ").append(f.getHoraIngreso())
				        .append(" | Salida: ").append(f.getHoraSalida())
				        .append("\n   Forma de cobro: ").append(f.getFormaDeCobro())
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

			ve.mostrarSUCCESS(
					"Factura encontrada\n"
					+ "Factura #" + ultimaFactura.getNum() + "\n"
					+ "Placa: " + ultimaFactura.getPlaca() + "\n"
					+ "Propietario: " + ultimaFactura.getNombrePropietario() + "\n"
					+ "Hora de Ingreso: " + ultimaFactura.getHoraIngreso() + "\n"
					+ "Hora de Salida: " + ultimaFactura.getHoraSalida() + "\n"
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
