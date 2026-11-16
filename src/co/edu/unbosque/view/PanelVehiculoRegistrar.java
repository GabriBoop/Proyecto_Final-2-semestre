package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

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

	public JTextField getTxtfieldSOAT() {
		return txtfieldSOAT;
	}

	public void setTxtfieldSOAT(JTextField txtfieldSOAT) {
		this.txtfieldSOAT = txtfieldSOAT;
	}

	public JComboBox<String> getBoxTarifa() {
		return boxTarifa;
	}

	public void setBoxTarifa(JComboBox<String> boxTarifa) {
		this.boxTarifa = boxTarifa;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

}