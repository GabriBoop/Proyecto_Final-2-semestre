package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Vista del menú de vehículos. Permite registrar el ingreso, registrar la salida, consultar un vehículo parqueado y ver el estado del parqueadero.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMenuVehiculo {
	
	/**
	 * Color de fondo de las pantallas del módulo de vehículos.
	 */
	protected static final Color FONDO_VEHICULO = new Color(88, 31, 0);
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 1, 0, 30));
	private JButton btnRegistrar = new JButton("Registrar Vehiculo");
	private JButton btnSalida = new JButton("Salida de Vehiculo");
	private JButton btnParqueado = new JButton("Vehiculo Parqueado");
	private JButton btnVerParqueado = new JButton("Estado de Parqueadero");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el fondo, crea los botones del menú y los organiza bajo la imagen de título.
	 */
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

	/**
	 * Obtiene el panel principal.
	 *
	 * @return El panel principal.
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Establece el panel principal.
	 *
	 * @param panel Nuevo panel principal.
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Obtiene el botón "Registrar Vehiculo".
	 *
	 * @return El botón "Registrar Vehiculo".
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * Obtiene el botón "Salida de Vehiculo".
	 *
	 * @return El botón "Salida de Vehiculo".
	 */
	public JButton getBtnSalida() {
		return btnSalida;
	}

	/**
	 * Obtiene el botón "Vehiculo Parqueado".
	 *
	 * @return El botón "Vehiculo Parqueado".
	 */
	public JButton getBtnParqueado() {
		return btnParqueado;
	}

	/**
	 * Obtiene el botón "Estado de Parqueadero".
	 *
	 * @return El botón "Estado de Parqueadero".
	 */
	public JButton getBtnVerParqueado() {
		return btnVerParqueado;
	}

	/**
	 * Obtiene el botón "Volver".
	 *
	 * @return El botón "Volver".
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}
}