package co.edu.unbosque.view;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
public class PanelVehiculoRegistrar {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(9, 2, 15, 15));
	private JLabel txt = new JLabel();
	
	private JTextField txtfieldPlaca = new JTextField();
	private JComboBox<String> boxTiposVehiculo = new JComboBox<String>();
	private JTextField txtfieldPropietarioDoc = new JTextField();
	private JTextField txtfieldPropietarioNom = new JTextField();
	private JTextField txtfieldPropietarioTel = new JTextField();
	private JTextField txtfieldSOAT = new JTextField();
	private JComboBox<String> boxTarifa = new JComboBox<String>();
	
	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnVolver = new JButton("Volver");
	
	public PanelVehiculoRegistrar() {
		txt.setText("Registrar Vehiculo");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		
		boxTiposVehiculo.addItem("Carro");
		boxTiposVehiculo.addItem("Moto");
		boxTarifa.addItem("Por hora");
		boxTarifa.addItem("Fija nocturna");
		
		
		columna.add(txt);
		columna.add(new JLabel());
		columna.add(new JLabel("Placa (AAA-###):"));
		columna.add(txtfieldPlaca);
		columna.add(new JLabel("Tipo de vehiculo:"));
		columna.add(boxTiposVehiculo);
		columna.add(new JLabel("Documento del propietario:"));
		columna.add(txtfieldPropietarioDoc);
		columna.add(new JLabel("Nombre del propietario:"));
		columna.add(txtfieldPropietarioNom);
		columna.add(new JLabel("Telefono del propietario:"));
		columna.add(txtfieldPropietarioTel);
		columna.add(new JLabel("Vencimiento SOAT (AAAA-MM-DD):"));
		columna.add(txtfieldSOAT);
		columna.add(new JLabel("Cobro nocturno:"));
		columna.add(boxTarifa);
		columna.add(btnRegistrar);
		columna.add(btnVolver);
		
		for (Component c : columna.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		txt.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(columna);
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

	public JTextField getTxtfieldPropietarioNom() {
		return txtfieldPropietarioNom;
	}

	public void setTxtfieldPropietarioNom(JTextField txtfieldPropietarioNom) {
		this.txtfieldPropietarioNom = txtfieldPropietarioNom;
	}

	public JTextField getTxtfieldPropietarioTel() {
		return txtfieldPropietarioTel;
	}

	public void setTxtfieldPropietarioTel(JTextField txtfieldPropietarioTel) {
		this.txtfieldPropietarioTel = txtfieldPropietarioTel;
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
