package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Vista que lista los propietarios registrados y muestra su total.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVerPropietarios {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalPropietarios = PanelMenu.crearLabel("Total de Propietarios: 0");
	private JTextArea areaPropietarios = new JTextArea(10, 35);
	private JScrollPane scrollPropietarios = new JScrollPane(areaPropietarios);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta del total, el área de texto de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelVerPropietarios() {
		panel.setBackground(PanelMenuPropietario.FONDO_PROPIETARIO);
		columna.setBackground(PanelMenuPropietario.FONDO_PROPIETARIO);

		lblTotalPropietarios.setHorizontalAlignment(SwingConstants.CENTER);

		areaPropietarios.setEditable(false);
		areaPropietarios.setLineWrap(true);
		areaPropietarios.setWrapStyleWord(true);
		areaPropietarios.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollPropietarios.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalPropietarios, BorderLayout.NORTH);
		columna.add(scrollPropietarios, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerPropietarios.png");
		PanelMenu.ajustarPanel(panel, imgTitulo, columna);
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
	 * Obtiene la etiqueta del total de propietarios.
	 *
	 * @return La etiqueta del total de propietarios.
	 */
	public JLabel getLblTotalPropietarios() {
		return lblTotalPropietarios;
	}

	/**
	 * Establece la etiqueta del total de propietarios.
	 *
	 * @param lblTotalPropietarios Nueva etiqueta del total de propietarios.
	 */
	public void setLblTotalPropietarios(JLabel lblTotalPropietarios) {
		this.lblTotalPropietarios = lblTotalPropietarios;
	}

	/**
	 * Obtiene el área de texto de los propietarios.
	 *
	 * @return El área de texto de los propietarios.
	 */
	public JTextArea getAreaPropietarios() {
		return areaPropietarios;
	}

	/**
	 * Establece el área de texto de los propietarios.
	 *
	 * @param areaPropietarios Nuevo área de texto de los propietarios.
	 */
	public void setAreaPropietarios(JTextArea areaPropietarios) {
		this.areaPropietarios = areaPropietarios;
	}

	/**
	 * Obtiene el panel de desplazamiento de los propietarios.
	 *
	 * @return El panel de desplazamiento de los propietarios.
	 */
	public JScrollPane getScrollPropietarios() {
		return scrollPropietarios;
	}

	/**
	 * Establece el panel de desplazamiento de los propietarios.
	 *
	 * @param scrollPropietarios Nuevo panel de desplazamiento de los propietarios.
	 */
	public void setScrollPropietarios(JScrollPane scrollPropietarios) {
		this.scrollPropietarios = scrollPropietarios;
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