package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Vista del menú de mensualidades. Permite registrar una mensualidad, ver las mensualidades y consultar las vacantes disponibles.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMenuMensualidades {

	/**
	 * Color de fondo de las pantallas del módulo de mensualidades.
	 */
	protected static final Color FONDO_MENSUALIDADES = new Color(60, 8, 30);  
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnRegistrar = new JButton("Registrar Mensualidad");
	private JButton btnVer = new JButton("Ver Mensualidades");
	private JButton btnVacantes = new JButton("Vacantes Mensualidades");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el fondo, crea los botones del menú y los organiza bajo la imagen de título.
	 */
	public PanelMenuMensualidades() {
		panel.setBackground(FONDO_MENSUALIDADES);
		columna.setBackground(FONDO_MENSUALIDADES);

		JLabel imgMensualidades = PanelMenu.crearImagen("/co/edu/unbosque/images/Mensualidades.png");

		PanelMenu.crearBoton(btnRegistrar, new Color(255, 50, 62), Color.WHITE);
		PanelMenu.crearBoton(btnVer, new Color(255, 50, 100), Color.WHITE);
		PanelMenu.crearBoton(btnVacantes, new Color(250, 50, 140), Color.WHITE);
		PanelMenu.crearBoton(btnVolver, new Color(235, 50, 180), Color.WHITE);

		columna.add(btnRegistrar);
		columna.add(btnVer);
		columna.add(btnVacantes);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgMensualidades, columna);
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
	 * Obtiene la etiqueta auxiliar de texto.
	 *
	 * @return La etiqueta auxiliar de texto.
	 */
	public JLabel getTxt() {
		return txt;
	}

	/**
	 * Establece la etiqueta auxiliar de texto.
	 *
	 * @param txt Nueva etiqueta auxiliar de texto.
	 */
	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	/**
	 * Obtiene el botón "Registrar Mensualidad".
	 *
	 * @return El botón "Registrar Mensualidad".
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * Establece el botón "Registrar Mensualidad".
	 *
	 * @param btnRegistrar Nuevo botón "Registrar Mensualidad".
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	/**
	 * Obtiene el botón "Ver Mensualidades".
	 *
	 * @return El botón "Ver Mensualidades".
	 */
	public JButton getBtnVer() {
		return btnVer;
	}

	/**
	 * Establece el botón "Ver Mensualidades".
	 *
	 * @param btnVer Nuevo botón "Ver Mensualidades".
	 */
	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	/**
	 * Obtiene el botón "Vacantes Mensualidades".
	 *
	 * @return El botón "Vacantes Mensualidades".
	 */
	public JButton getBtnVacantes() {
		return btnVacantes;
	}

	/**
	 * Establece el botón "Vacantes Mensualidades".
	 *
	 * @param btnVacantes Nuevo botón "Vacantes Mensualidades".
	 */
	public void setBtnVacantes(JButton btnVacantes) {
		this.btnVacantes = btnVacantes;
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