package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPropietarioRegistrar {
	
	private static final Color FONDO = new Color(14,60,0);
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 2, 15, 15));
	private JLabel txt = new JLabel();
	
	private JTextField txtfieldDocumento = new JTextField();
	private JTextField txtfieldNombre = new JTextField();
	private JTextField txtfieldTelefono = new JTextField();
	
	private JButton btnRegistrar = new JButton("Registrar");
	private JButton btnVolver = new JButton("Volver");

	public PanelPropietarioRegistrar() {
		panel.setBackground(FONDO);
		columna.setBackground(FONDO);
		
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

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/propietario.png");
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
