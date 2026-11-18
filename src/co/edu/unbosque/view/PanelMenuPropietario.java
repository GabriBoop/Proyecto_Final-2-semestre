package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Vista del menú de propietarios. Permite registrar un propietario o ver los propietarios registrados.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMenuPropietario {

	/**
	 * Color de fondo de las pantallas del módulo de propietarios.
	 */
	public static final Color FONDO_PROPIETARIO = new Color(4, 38, 34); 

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(3, 1, 0, 30));
	private JButton btnRegistrar = new JButton("Registrar Propietario");
	private JButton btnVer = new JButton("Ver Propietarios");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el fondo, crea los botones del menú y los organiza bajo la imagen de título.
	 */
	public PanelMenuPropietario() {
		panel.setBackground(FONDO_PROPIETARIO);
		columna.setBackground(FONDO_PROPIETARIO);

		JLabel imgPropietario = PanelMenu.crearImagen("/co/edu/unbosque/images/Propietarios.png");

		PanelMenu.crearBoton(btnRegistrar, new Color(33, 151, 0), Color.WHITE);
		PanelMenu.crearBoton(btnVer, new Color(24, 140, 60), Color.WHITE);
		PanelMenu.crearBoton(btnVolver, new Color(15, 125, 105), Color.WHITE);

		columna.add(btnRegistrar);
		columna.add(btnVer);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgPropietario, columna);
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
	 * Obtiene el panel que contiene los componentes principales.
	 *
	 * @return El panel que contiene los componentes principales.
	 */
	public JPanel getColumna() {
		return columna;
	}

	/**
	 * Establece el panel que contiene los componentes principales.
	 *
	 * @param columna Nuevo panel que contiene los componentes principales.
	 */
	public void setColumna(JPanel columna) {
		this.columna = columna;
	}

	/**
	 * Obtiene el botón "Registrar Propietario".
	 *
	 * @return El botón "Registrar Propietario".
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * Establece el botón "Registrar Propietario".
	 *
	 * @param btnRegistrar Nuevo botón "Registrar Propietario".
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	/**
	 * Obtiene el botón "Ver Propietarios".
	 *
	 * @return El botón "Ver Propietarios".
	 */
	public JButton getBtnVer() {
		return btnVer;
	}

	/**
	 * Establece el botón "Ver Propietarios".
	 *
	 * @param btnVer Nuevo botón "Ver Propietarios".
	 */
	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	/**
	 * Obtiene el botón "Volver".
	 *
	 * @return El botón "Volver".
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * Establece el botón "Volver".
	 *
	 * @param btnVolver Nuevo botón "Volver".
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}