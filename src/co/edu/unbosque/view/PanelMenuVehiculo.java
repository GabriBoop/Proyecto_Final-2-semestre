package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelMenuVehiculo {
	
	protected static final Color FONDO_VEHICULO = new Color(88, 31, 0);
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 1, 0, 30));
	private JButton btnRegistrar = new JButton("Registrar Vehiculo");
	private JButton btnSalida = new JButton("Salida de Vehiculo");
	private JButton btnParqueado = new JButton("Vehiculo Parqueado");
	private JButton btnVerParqueado = new JButton("Estado de Parqueadero");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuVehiculo() {
		panel.setBackground(FONDO_VEHICULO);
		columna.setBackground(FONDO_VEHICULO);
		
		JLabel imgVehiculo = PanelMenu.crearImagen("/co/edu/unbosque/images/vehiculo.png");
		
		PanelMenu.crearBoton(btnRegistrar,new Color(255, 120, 22),Color.WHITE);
		PanelMenu.crearBoton(btnSalida,new Color(255,94,22),Color.WHITE);
		PanelMenu.crearBoton(btnParqueado,new Color(255,81,22),Color.WHITE);
		PanelMenu.crearBoton(btnVerParqueado,new Color(255,63,22),Color.WHITE);
		PanelMenu.crearBoton(btnVolver,new Color(255,34,22),Color.WHITE);
		
		columna.add(btnRegistrar);
		columna.add(btnSalida);
		columna.add(btnParqueado);
		columna.add(btnVerParqueado);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgVehiculo, columna);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnSalida() {
		return btnSalida;
	}

	public JButton getBtnParqueado() {
		return btnParqueado;
	}

	public JButton getBtnVerParqueado() {
		return btnVerParqueado;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}