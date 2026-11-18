package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

/**
 * Vista con el formulario para registrar el ingreso de un vehículo (placa, tipo, documento del propietario, vencimiento del SOAT y tipo de cobro nocturno).
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVehiculoRegistrar {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 2, 15, 15));

	private JTextField txtfieldPlaca = new JTextField();
	private JComboBox<String> boxTiposVehiculo = new JComboBox<String>();
	private JTextField txtfieldPropietarioDoc = new JTextField();
	private JTextField txtfieldSOAT = new JTextField();
	private JComboBox<String> boxTarifa = new JComboBox<String>();

	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura los campos del formulario, carga las opciones de tipo de vehículo y de tarifa, y organiza los componentes bajo la imagen de título.
	 */
	public PanelVehiculoRegistrar() {
		panel.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);
		columna.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);

		boxTiposVehiculo.addItem("Carro");
		boxTiposVehiculo.addItem("Moto");
		boxTarifa.addItem("Por hora");
		boxTarifa.addItem("Fija nocturna");

		Font fuente = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		txtfieldPlaca.setFont(fuente);
		txtfieldPropietarioDoc.setFont(fuente);
		txtfieldSOAT.setFont(fuente);
		boxTiposVehiculo.setFont(fuente);
		boxTarifa.setFont(fuente);

		PanelMenu.crearBoton(btnRegistrar, PanelMenu.COLOR_REGISTRAR, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Placa (AAA-###):"));
		columna.add(txtfieldPlaca);
		columna.add(PanelMenu.crearLabel("Tipo de vehiculo:"));
		columna.add(boxTiposVehiculo);
		columna.add(PanelMenu.crearLabel("Documento del propietario:"));
		columna.add(txtfieldPropietarioDoc);
		columna.add(PanelMenu.crearLabel("Vencimiento SOAT (AAAA-MM-DD):"));
		columna.add(txtfieldSOAT);
		columna.add(PanelMenu.crearLabel("Cobro nocturno:"));
		columna.add(boxTarifa);
		columna.add(btnRegistrar);
		columna.add(btnVolver);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/RegistrarVehiculo.png");
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
	 * Obtiene el campo de texto del vencimiento del SOAT.
	 *
	 * @return El campo de texto del vencimiento del SOAT.
	 */
	public JTextField getTxtfieldSOAT() {
		return txtfieldSOAT;
	}

	/**
	 * Establece el campo de texto del vencimiento del SOAT.
	 *
	 * @param txtfieldSOAT Nuevo campo de texto del vencimiento del SOAT.
	 */
	public void setTxtfieldSOAT(JTextField txtfieldSOAT) {
		this.txtfieldSOAT = txtfieldSOAT;
	}

	/**
	 * Obtiene la lista desplegable de la tarifa de cobro nocturno.
	 *
	 * @return La lista desplegable de la tarifa de cobro nocturno.
	 */
	public JComboBox<String> getBoxTarifa() {
		return boxTarifa;
	}

	/**
	 * Establece la lista desplegable de la tarifa de cobro nocturno.
	 *
	 * @param boxTarifa Nueva lista desplegable de la tarifa de cobro nocturno.
	 */
	public void setBoxTarifa(JComboBox<String> boxTarifa) {
		this.boxTarifa = boxTarifa;
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
	 * Obtiene el botón "Volver".
	 *
	 * @return El botón "Volver".
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

}