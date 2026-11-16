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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getColumna() {
		return columna;
	}

	public void setColumna(JPanel columna) {
		this.columna = columna;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public JTextField getTxtfieldPlaca() {
		return txtfieldPlaca;
	}

	public void setTxtfieldPlaca(JTextField txtfieldPlaca) {
		this.txtfieldPlaca = txtfieldPlaca;
	}

	public JComboBox<String> getBoxTiposVehiculo() {
		return boxTiposVehiculo;
	}

	public void setBoxTiposVehiculo(JComboBox<String> boxTiposVehiculo) {
		this.boxTiposVehiculo = boxTiposVehiculo;
	}

	public JTextField getTxtfieldPropietarioDoc() {
		return txtfieldPropietarioDoc;
	}

	public void setTxtfieldPropietarioDoc(JTextField txtfieldPropietarioDoc) {
		this.txtfieldPropietarioDoc = txtfieldPropietarioDoc;
	}

	public JTextField getTxtfieldPropietarioNom() {
		return txtfieldPropietarioNom;
	}

	public void setTxtfieldPropietarioNom(JTextField txtfieldPropietarioNom) {
		this.txtfieldPropietarioNom = txtfieldPropietarioNom;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}