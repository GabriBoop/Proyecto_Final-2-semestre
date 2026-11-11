package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;


public class Controller implements ActionListener {
	
	private Consola con;
	private MainFrame principal = new MainFrame();
	private PanelMenu pm = new PanelMenu();
	private PanelMenuVehiculo pmVehiculo = new PanelMenuVehiculo();
	private PanelMenuMensualidades pmMensualidad = new PanelMenuMensualidades();
	private CarroDAO carroDAO;
	private FacturaDAO facturaDAO;
	private MensualidadDAO mensualidadDAO;
	private MotoDAO motoDAO;
	private PropietarioDAO propietarioDAO;
	private RegistroDAO registroDAO;
	
	public Controller(){
		con = new Consola();
		carroDAO = new CarroDAO();
		facturaDAO = new FacturaDAO();
		mensualidadDAO = new MensualidadDAO();
		motoDAO = new MotoDAO();
		propietarioDAO = new PropietarioDAO();
		registroDAO = new RegistroDAO();
	}

	public void start() {
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
		
		pm.getBtnMensualidades().addActionListener(this);
		pm.getBtnMensualidades().setActionCommand("MENSUALIDADES");
		
		pm.getBtnSalir().addActionListener(this);
		pm.getBtnSalir().setActionCommand("SALIR");

		pmVehiculo.getBtnVolver().addActionListener(this);
		pmVehiculo.getBtnVolver().setActionCommand("VOLVER");
		
		pmMensualidad.getBtnVolver().addActionListener(this);
		pmMensualidad.getBtnVolver().setActionCommand("VOLVER");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		switch (cmd) {
		case "VEHICULO":
			principal.cambiarPanel(pmVehiculo.getPanel());
			break;
		case "MENSUALIDADES":
			principal.cambiarPanel(pmMensualidad.getPanel());
			break;
		case "VOLVER":
			principal.cambiarPanel(pm.getPanel());
			break;
		case "SALIR":
			System.exit(0);
			break;
		}
	}

}
