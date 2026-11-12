package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.DatoVacioException;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;


public class Controller implements ActionListener {
	private ReproducirAudio r = new ReproducirAudio();
	
	// Visual
	private Consola con; //matarlo
	private MainFrame principal;
	private PanelMenu pm;
	private PanelMenuVehiculo pmVehiculo;
	private PanelMenuMensualidades pmMensualidad;
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
	
	public Controller(){
		
		con = new Consola();
		principal = new MainFrame();
		pm = new PanelMenu();
		pmVehiculo = new PanelMenuVehiculo();
		pvRegistrar = new PanelVehiculoRegistrar();
		pmMensualidad = new PanelMenuMensualidades();
		pmConsulta = new PanelMenuConsulta();
		pmReportes = new PanelMenuReportes();
		ve = new VentanaEmergente();
		
		carroDAO = new CarroDAO();
		facturaDAO = new FacturaDAO();
		mensualidadDAO = new MensualidadDAO();
		motoDAO = new MotoDAO();
		propietarioDAO = new PropietarioDAO();
		registroDAO = new RegistroDAO();	
	}

	public void start() {
		r.reproducir("rhythm-heaven.wav");
		asignarOyentes();
		
		cicloPrincipal : while(true) {
			principal.cambiarPanel(pm.getPanel());
			propietarioDAO.crear(new PropietarioDTO("1032941791","thomas","12345213"));
			principal.setVisible(true);
			con.imprimirConSalto("Bienvenido al menu principal del parquadero");
			con.imprimirConSalto("Seleccione la opcion que necesita");
			con.imprimirConSalto("1.Registrar un propietario");
			con.imprimirConSalto("2.Ingresar un vehiculo");
			con.imprimirConSalto("3.Registrar la salida de un vehiculo");
			con.imprimirConSalto("4.Ver propietarios");
			con.imprimirConSalto("5.Ver vehiculos");
			con.imprimirConSalto("6.Salir");

			int a = con.leerEntero();
			switch(a) {
			case 1:
			case 2:
			case 3:
			case 4:
				con.imprimirConSalto(propietarioDAO.mostrarTodo());
			case 5:
				con.imprimirConSalto(motoDAO.mostrarTodo());
				con.imprimirConSalto(carroDAO.mostrarTodo());
			case 6: 
				break cicloPrincipal;
			}

			principal.cambiarPanel(pm.getPanel());
			principal.setVisible(true);
		}
	}

	public void asignarOyentes() {
		pm.getBtnVerVehiculos().addActionListener(this);
		pm.getBtnVerVehiculos().setActionCommand("VEHICULO");
		
		pvRegistrar.getBtnRegistrar().addActionListener(this);
		pvRegistrar.getBtnRegistrar().setActionCommand("REGISTRAR");
		
		pm.getBtnMensualidades().addActionListener(this);
		pm.getBtnMensualidades().setActionCommand("MENSUALIDADES");
		
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
		case "VEHICULO":
			principal.cambiarPanel(pmVehiculo.getPanel());
			break;
		case "VEHICULO_REGISTRAR":
			principal.cambiarPanel(pvRegistrar.getPanel());
			break;	
		case "REGISTRAR":
			try {
				String placa = pvRegistrar.getTxtfieldPlaca().getText().trim().toUpperCase();
				String tipoV = pvRegistrar.getBoxTiposVehiculo().getSelectedItem().toString();
				String documento = pvRegistrar.getTxtfieldPropietarioDoc().getText();
				String nombre = pvRegistrar.getTxtfieldPropietarioNom().getText().trim();
				String telefono = pvRegistrar.getTxtfieldPropietarioTel().getText().trim();
				String fechaSoat = pvRegistrar.getTxtfieldSOAT().getText().trim();
				String tipoTarifa = pvRegistrar.getBoxTarifa().getSelectedItem().toString();
				
				if (placa.isBlank()) throw new DatoVacioException("placa");
				if (documento.isBlank()) throw new DatoVacioException("documento");
				if (nombre.isBlank()) throw new DatoVacioException("nombre");
				if (telefono.isBlank()) throw new DatoVacioException("telefono");
				if (fechaSoat.isBlank()) throw new DatoVacioException("SOAT");

				LocalDate soat = LocalDate.parse(fechaSoat);
				
				PropietarioDTO propDTO = new PropietarioDTO(documento,nombre,telefono);
				Propietario prop = new Propietario(documento,nombre,telefono);
				propietarioDAO.crear(propDTO);
				
				if (tipoV.equals("Carro")) {
					CarroDTO carro = new CarroDTO();
					carro.setPlaca(placa);
					carro.setPropietario(prop);
					carro.setVencimientoSoat(soat);
					carroDAO.crear(carro);
				} else {
					MotoDTO moto = new MotoDTO();
					moto.setPlaca(placa);
					moto.setPropietario(prop);
					moto.setVencimientoSoat(soat);
					motoDAO.crear(moto);
				}
				
				ve.mostrar(tipoV + " " + placa + " registrado.");
				pvRegistrar.getTxtfieldPlaca().setText("");
				pvRegistrar.getTxtfieldPropietarioDoc().setText("");
				pvRegistrar.getTxtfieldPropietarioNom().setText("");
				pvRegistrar.getTxtfieldPropietarioTel().setText("");
				pvRegistrar.getTxtfieldSOAT().setText("");
			} catch (DatoVacioException ex) {
				ve.mostrarERROR(ex.getMessage(), "ERROR");
			} catch (DateTimeParseException  ex) {
				ve.mostrarERROR("La fecha debe tener el formato AAAA-MM-DD.", "ERROR");
			}
			break;
		case "MENSUALIDADES":
			principal.cambiarPanel(pmMensualidad.getPanel());
			break;
		case "CONSULTAS":
			principal.cambiarPanel(pmConsulta.getPanel());
			break;
		case "REPORTES":
			principal.cambiarPanel(pmReportes.getPanel());
			break;
		case "VOLVER":
			principal.cambiarPanel(pm.getPanel());
			break;
		case "SALIR":
			int r = ve.preguntarSiNo("¿Desea Salir Del Programa?", "CONFIRMACION");
			if(r == 0) System.exit(0);
			break;
		}
	}

}
