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
 * Vista que lista los registros de ingreso y salida y muestra su total.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVerRegistros {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalRegistros = PanelMenu.crearLabel("Total de Registros: 0");
	private JTextArea areaRegistros = new JTextArea(10, 35);
	private JScrollPane scrollRegistros = new JScrollPane(areaRegistros);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta del total, el área de texto de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelVerRegistros() {
		panel.setBackground(PanelMenuConsulta.FONDO_CONSULTA);
		columna.setBackground(PanelMenuConsulta.FONDO_CONSULTA);

		lblTotalRegistros.setHorizontalAlignment(SwingConstants.CENTER);

		areaRegistros.setEditable(false);
		areaRegistros.setLineWrap(true);
		areaRegistros.setWrapStyleWord(true);
		areaRegistros.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollRegistros.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalRegistros, BorderLayout.NORTH);
		columna.add(scrollRegistros, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerRegistros.png");
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
	 * Obtiene la etiqueta del total de registros.
	 *
	 * @return La etiqueta del total de registros.
	 */
	public JLabel getLblTotalRegistros() {
		return lblTotalRegistros;
	}

	/**
	 * Establece la etiqueta del total de registros.
	 *
	 * @param lblTotalRegistros Nueva etiqueta del total de registros.
	 */
	public void setLblTotalRegistros(JLabel lblTotalRegistros) {
		this.lblTotalRegistros = lblTotalRegistros;
	}

	/**
	 * Obtiene el área de texto de los registros.
	 *
	 * @return El área de texto de los registros.
	 */
	public JTextArea getAreaRegistros() {
		return areaRegistros;
	}

	/**
	 * Establece el área de texto de los registros.
	 *
	 * @param areaRegistros Nuevo área de texto de los registros.
	 */
	public void setAreaRegistros(JTextArea areaRegistros) {
		this.areaRegistros = areaRegistros;
	}

	/**
	 * Obtiene el panel de desplazamiento de los registros.
	 *
	 * @return El panel de desplazamiento de los registros.
	 */
	public JScrollPane getScrollRegistros() {
		return scrollRegistros;
	}

	/**
	 * Establece el panel de desplazamiento de los registros.
	 *
	 * @param scrollRegistros Nuevo panel de desplazamiento de los registros.
	 */
	public void setScrollRegistros(JScrollPane scrollRegistros) {
		this.scrollRegistros = scrollRegistros;
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