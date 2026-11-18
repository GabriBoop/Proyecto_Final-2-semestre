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
 * Vista con el formulario para registrar un propietario (documento, nombre y teléfono).
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelPropietarioRegistrar {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 2, 15, 15));
	private JLabel txt = new JLabel();
	
	private JTextField txtfieldDocumento = new JTextField();
	private JTextField txtfieldNombre = new JTextField();
	private JTextField txtfieldTelefono = new JTextField();
	
	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura los campos de texto y los botones del formulario y los organiza bajo la imagen de título.
	 */
	public PanelPropietarioRegistrar() {
		panel.setBackground(PanelMenuPropietario.FONDO_PROPIETARIO);
		columna.setBackground(PanelMenuPropietario.FONDO_PROPIETARIO);
		
		txtfieldDocumento.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		txtfieldNombre.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		txtfieldTelefono.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		
		PanelMenu.crearBoton(btnRegistrar,PanelMenu.COLOR_REGISTRAR ,Color.WHITE);
		PanelMenu.crearBoton(btnVolver,Color.BLACK,Color.WHITE);
		
		columna.add(PanelMenu.crearLabel("Documento del propietario:"));
		columna.add(txtfieldDocumento);
		columna.add(PanelMenu.crearLabel("Nombre del propietario:"));
		columna.add(txtfieldNombre);
		columna.add(PanelMenu.crearLabel("Telefono del propietario:"));
		columna.add(txtfieldTelefono);
		columna.add(btnRegistrar);
		columna.add(btnVolver);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/CrearPropietario.png");
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
	 * Obtiene el campo de texto del documento del propietario.
	 *
	 * @return El campo de texto del documento del propietario.
	 */
	public JTextField getTxtfieldDocumento() {
		return txtfieldDocumento;
	}

	/**
	 * Establece el campo de texto del documento del propietario.
	 *
	 * @param txtfieldDocumento Nuevo campo de texto del documento del propietario.
	 */
	public void setTxtfieldDocumento(JTextField txtfieldDocumento) {
		this.txtfieldDocumento = txtfieldDocumento;
	}

	/**
	 * Obtiene el campo de texto del nombre del propietario.
	 *
	 * @return El campo de texto del nombre del propietario.
	 */
	public JTextField getTxtfieldNombre() {
		return txtfieldNombre;
	}

	/**
	 * Establece el campo de texto del nombre del propietario.
	 *
	 * @param txtfieldNombre Nuevo campo de texto del nombre del propietario.
	 */
	public void setTxtfieldNombre(JTextField txtfieldNombre) {
		this.txtfieldNombre = txtfieldNombre;
	}

	/**
	 * Obtiene el campo de texto del teléfono del propietario.
	 *
	 * @return El campo de texto del teléfono del propietario.
	 */
	public JTextField getTxtfieldTelefono() {
		return txtfieldTelefono;
	}

	/**
	 * Establece el campo de texto del teléfono del propietario.
	 *
	 * @param txtfieldTelefono Nuevo campo de texto del teléfono del propietario.
	 */
	public void setTxtfieldTelefono(JTextField txtfieldTelefono) {
		this.txtfieldTelefono = txtfieldTelefono;
	}

	/**
	 * Obtiene el botón "Registrar".
	 *
	 * @return El botón "Registrar".
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * Establece el botón "Registrar".
	 *
	 * @param btnRegistrar Nuevo botón "Registrar".
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
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