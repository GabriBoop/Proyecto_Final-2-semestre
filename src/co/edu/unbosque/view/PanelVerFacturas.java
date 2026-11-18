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
 * Vista que lista todas las facturas generadas y muestra su total.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVerFacturas {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalFacturas = PanelMenu.crearLabel("Total de Facturas: 0");
	private JTextArea areaFacturas = new JTextArea(10, 35);
	private JScrollPane scrollFacturas = new JScrollPane(areaFacturas);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta del total, el área de texto de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelVerFacturas() {
		panel.setBackground(PanelMenuConsulta.FONDO_CONSULTA);
		columna.setBackground(PanelMenuConsulta.FONDO_CONSULTA);

		lblTotalFacturas.setHorizontalAlignment(SwingConstants.CENTER);

		areaFacturas.setEditable(false);
		areaFacturas.setLineWrap(true);
		areaFacturas.setWrapStyleWord(true);
		areaFacturas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollFacturas.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalFacturas, BorderLayout.NORTH);
		columna.add(scrollFacturas, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerFacturas.png");
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
 * Obtiene la etiqueta del total de facturas.
 *
 * @return La etiqueta del total de facturas.
 */
public JLabel getLblTotalFacturas() {
	return lblTotalFacturas;
}

/**
 * Establece la etiqueta del total de facturas.
 *
 * @param lblTotalFacturas Nueva etiqueta del total de facturas.
 */
public void setLblTotalFacturas(JLabel lblTotalFacturas) {
	this.lblTotalFacturas = lblTotalFacturas;
}

/**
 * Obtiene el área de texto de las facturas.
 *
 * @return El área de texto de las facturas.
 */
public JTextArea getAreaFacturas() {
	return areaFacturas;
}

/**
 * Establece el área de texto de las facturas.
 *
 * @param areaFacturas Nuevo área de texto de las facturas.
 */
public void setAreaFacturas(JTextArea areaFacturas) {
	this.areaFacturas = areaFacturas;
}

/**
 * Obtiene el panel de desplazamiento de las facturas.
 *
 * @return El panel de desplazamiento de las facturas.
 */
public JScrollPane getScrollFacturas() {
	return scrollFacturas;
}

/**
 * Establece el panel de desplazamiento de las facturas.
 *
 * @param scrollFacturas Nuevo panel de desplazamiento de las facturas.
 */
public void setScrollFacturas(JScrollPane scrollFacturas) {
	this.scrollFacturas = scrollFacturas;
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