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
 * Vista que lista las mensualidades activas y muestra su total.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVerMensualidades {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));

	private JLabel lblTotalMensualidades = PanelMenu.crearLabel("Mensualidades activas: 0");
	private JTextArea areaMensualidades = new JTextArea(12, 45);
	private JScrollPane scrollMensualidades = new JScrollPane(areaMensualidades);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta del total, el área de texto de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelVerMensualidades() {
		panel.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		columna.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);

		lblTotalMensualidades.setHorizontalAlignment(SwingConstants.CENTER);

		areaMensualidades.setEditable(false);
		areaMensualidades.setLineWrap(true);
		areaMensualidades.setWrapStyleWord(true);
		areaMensualidades.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollMensualidades.setPreferredSize(new Dimension(700, 280));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalMensualidades, BorderLayout.NORTH);
		columna.add(scrollMensualidades, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerMensualidades.png");
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
	 * Obtiene la etiqueta del total de mensualidades.
	 *
	 * @return La etiqueta del total de mensualidades.
	 */
	public JLabel getLblTotalMensualidades() {
		return lblTotalMensualidades;
	}

	/**
	 * Establece la etiqueta del total de mensualidades.
	 *
	 * @param lblTotalMensualidades Nueva etiqueta del total de mensualidades.
	 */
	public void setLblTotalMensualidades(JLabel lblTotalMensualidades) {
		this.lblTotalMensualidades = lblTotalMensualidades;
	}

	/**
	 * Obtiene el área de texto de las mensualidades.
	 *
	 * @return El área de texto de las mensualidades.
	 */
	public JTextArea getAreaMensualidades() {
		return areaMensualidades;
	}

	/**
	 * Establece el área de texto de las mensualidades.
	 *
	 * @param areaMensualidades Nuevo área de texto de las mensualidades.
	 */
	public void setAreaMensualidades(JTextArea areaMensualidades) {
		this.areaMensualidades = areaMensualidades;
	}

	/**
	 * Obtiene el panel de desplazamiento de las mensualidades.
	 *
	 * @return El panel de desplazamiento de las mensualidades.
	 */
	public JScrollPane getScrollMensualidades() {
		return scrollMensualidades;
	}

	/**
	 * Establece el panel de desplazamiento de las mensualidades.
	 *
	 * @param scrollMensualidades Nuevo panel de desplazamiento de las mensualidades.
	 */
	public void setScrollMensualidades(JScrollPane scrollMensualidades) {
		this.scrollMensualidades = scrollMensualidades;
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