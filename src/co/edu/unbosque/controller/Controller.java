package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.view.*;

public class Controller implements ActionListener {

	private FileHandler fh;

	private MainFrame principal = new MainFrame();
	private PanelMenu pm = new PanelMenu();
	private PanelMenuVehiculo pmVehiculo = new PanelMenuVehiculo();
	private PanelMenuMensualidades pmMensualidad = new PanelMenuMensualidades();

	public void start() {
		asignarOyentes();
		fh = new FileHandler();
		fh.crearYEscribirArchivo("Thomas.csv", "THOMAAAAAAAAAAAAAAAA");
		principal.cambiarPanel(pm.getPanel());
		principal.setVisible(true);
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
