package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Vista para buscar una factura por su número.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelBuscarFactura {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(2, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldID = new JTextField();

	private JButton btnConsultar = new JButton("Consultar Factura");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el fondo, el campo de texto del número de factura y los botones, y los organiza bajo la imagen de título.
	 */
	public PanelBuscarFactura() {
		panel.setBackground(PanelMenuConsulta.FONDO_CONSULTA);
		columna.setBackground(PanelMenuConsulta.FONDO_CONSULTA);

		txtfieldID.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

		PanelMenu.crearBoton(btnConsultar, PanelMenu.COLOR_REGISTRAR, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Numero De la Factura"));
		columna.add(txtfieldID);
		columna.add(btnConsultar);
		columna.add(btnVolver);

		
		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/BuscarFacturas.png");
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
	 * Obtiene el campo de texto del número de factura.
	 *
	 * @return El campo de texto del número de factura.
	 */
	public JTextField getTxtfieldID() {
		return txtfieldID;
	}

	/**
	 * Establece el campo de texto del número de factura.
	 *
	 * @param txtfieldPlaca Nuevo campo de texto del número de factura.
	 */
	public void setTxtfieldID(JTextField txtfieldPlaca) {
		this.txtfieldID = txtfieldPlaca;
	}
	/**
	 * Obtiene el botón "Consultar Factura".
	 *
	 * @return El botón "Consultar Factura".
	 */
	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	/**
	 * Establece el botón "Consultar Factura".
	 *
	 * @param btnConsultar Nuevo botón "Consultar Factura".
	 */
	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
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