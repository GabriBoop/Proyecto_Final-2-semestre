package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelPropietarioRegistrar {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 2, 15, 15));
	private JLabel txt = new JLabel();
	
	private JTextField txtfieldDocumento = new JTextField();
	private JTextField txtfieldNombre = new JTextField();
	private JTextField txtfieldTelefono = new JTextField();
	
	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnVolver = new JButton("Volver");

	public PanelPropietarioRegistrar() {
		txt.setText("Registrar Propietario");
		txt.setHorizontalAlignment(SwingConstants.CENTER);

		columna.add(txt);
		columna.add(new JLabel());
		columna.add(new JLabel("Documento del propietario:"));
		columna.add(txtfieldDocumento);
		columna.add(new JLabel("Nombre del propietario:"));
		columna.add(txtfieldNombre);
		columna.add(new JLabel("Telefono del propietario:"));
		columna.add(txtfieldTelefono);
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

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public JTextField getTxtfieldDocumento() {
		return txtfieldDocumento;
	}

	public void setTxtfieldDocumento(JTextField txtfieldDocumento) {
		this.txtfieldDocumento = txtfieldDocumento;
	}

	public JTextField getTxtfieldNombre() {
		return txtfieldNombre;
	}

	public void setTxtfieldNombre(JTextField txtfieldNombre) {
		this.txtfieldNombre = txtfieldNombre;
	}

	public JTextField getTxtfieldTelefono() {
		return txtfieldTelefono;
	}

	public void setTxtfieldTelefono(JTextField txtfieldTelefono) {
		this.txtfieldTelefono = txtfieldTelefono;
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
