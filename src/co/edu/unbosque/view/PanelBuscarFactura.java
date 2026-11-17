package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBuscarFactura {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(2, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldID = new JTextField();

	private JButton btnConsultar = new JButton("Consultar Factura");
	private JButton btnVolver = new JButton("Volver");

	public PanelBuscarFactura() {
		panel.setBackground(PanelMenuConsulta.FONDO_CONSULTA);
		columna.setBackground(PanelMenuConsulta.FONDO_CONSULTA);

		txtfieldID.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

		PanelMenu.crearBoton(btnConsultar, Color.BLACK, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Numero De la Factura"));
		columna.add(txtfieldID);
		columna.add(btnConsultar);
		columna.add(btnVolver);

		
		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerFacturas.png");
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

	public JTextField getTxtfieldID() {
		return txtfieldID;
	}

	public void setTxtfieldID(JTextField txtfieldPlaca) {
		this.txtfieldID = txtfieldPlaca;
	}
	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}