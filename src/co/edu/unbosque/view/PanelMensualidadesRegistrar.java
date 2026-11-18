package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Vista con el formulario para registrar una mensualidad (nombre y documento del propietario, placa y tipo de vehículo).
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMensualidadesRegistrar {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldPlaca = new JTextField();
	private JComboBox<String> boxTiposVehiculo = new JComboBox<String>();
	private JTextField txtfieldPropietarioDoc = new JTextField();
	private JTextField txtfieldPropietarioNom = new JTextField();

	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el formulario, carga los tipos de vehículo (Carro y Moto) en la lista desplegable y organiza los componentes bajo la imagen de título.
	 */
	public PanelMensualidadesRegistrar() {
		panel.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		columna.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);

		boxTiposVehiculo.addItem("Carro");
		boxTiposVehiculo.addItem("Moto");

		Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		txtfieldPropietarioNom.setFont(fuente);
		txtfieldPropietarioDoc.setFont(fuente);
		txtfieldPlaca.setFont(fuente);
		boxTiposVehiculo.setFont(fuente);

		PanelMenu.crearBoton(btnRegistrar, PanelMenu.COLOR_REGISTRAR, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Nombre del propietario:"));
		columna.add(txtfieldPropietarioNom);
		columna.add(PanelMenu.crearLabel("Documento del propietario:"));
		columna.add(txtfieldPropietarioDoc);
		columna.add(PanelMenu.crearLabel("Placa:"));
		columna.add(txtfieldPlaca);
		columna.add(PanelMenu.crearLabel("Tipo de vehiculo:"));
		columna.add(boxTiposVehiculo);
		columna.add(btnRegistrar);
		columna.add(btnVolver);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/RegistrarMensualidad.png");
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
	 * Obtiene el campo de texto de la placa.
	 *
	 * @return El campo de texto de la placa.
	 */
	public JTextField getTxtfieldPlaca() {
		return txtfieldPlaca;
	}

	/**
	 * Establece el campo de texto de la placa.
	 *
	 * @param txtfieldPlaca Nuevo campo de texto de la placa.
	 */
	public void setTxtfieldPlaca(JTextField txtfieldPlaca) {
		this.txtfieldPlaca = txtfieldPlaca;
	}

	/**
	 * Obtiene la lista desplegable de los tipos de vehículo.
	 *
	 * @return La lista desplegable de los tipos de vehículo.
	 */
	public JComboBox<String> getBoxTiposVehiculo() {
		return boxTiposVehiculo;
	}

	/**
	 * Establece la lista desplegable de los tipos de vehículo.
	 *
	 * @param boxTiposVehiculo Nueva lista desplegable de los tipos de vehículo.
	 */
	public void setBoxTiposVehiculo(JComboBox<String> boxTiposVehiculo) {
		this.boxTiposVehiculo = boxTiposVehiculo;
	}

	/**
	 * Obtiene el campo de texto del documento del propietario.
	 *
	 * @return El campo de texto del documento del propietario.
	 */
	public JTextField getTxtfieldPropietarioDoc() {
		return txtfieldPropietarioDoc;
	}

	/**
	 * Establece el campo de texto del documento del propietario.
	 *
	 * @param txtfieldPropietarioDoc Nuevo campo de texto del documento del propietario.
	 */
	public void setTxtfieldPropietarioDoc(JTextField txtfieldPropietarioDoc) {
		this.txtfieldPropietarioDoc = txtfieldPropietarioDoc;
	}

	/**
	 * Obtiene el campo de texto del nombre del propietario.
	 *
	 * @return El campo de texto del nombre del propietario.
	 */
	public JTextField getTxtfieldPropietarioNom() {
		return txtfieldPropietarioNom;
	}

	/**
	 * Establece el campo de texto del nombre del propietario.
	 *
	 * @param txtfieldPropietarioNom Nuevo campo de texto del nombre del propietario.
	 */
	public void setTxtfieldPropietarioNom(JTextField txtfieldPropietarioNom) {
		this.txtfieldPropietarioNom = txtfieldPropietarioNom;
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