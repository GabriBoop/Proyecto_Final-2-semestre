package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelVehiculoParqueadero {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldPlaca = new JTextField();
	private JLabel lblEstado = new JLabel("");
	private JLabel lblPropietario = new JLabel("");

	private JButton btnConsultar = new JButton("Consultar");
	private JButton btnVolver = new JButton("Volver");

	public PanelVehiculoParqueadero() {
		panel.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);
		columna.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);

		txtfieldPlaca.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

		Font fuenteResultado = new Font("Arial", Font.BOLD, 24);
		lblEstado.setFont(fuenteResultado);
		lblEstado.setForeground(Color.WHITE);
		lblPropietario.setFont(fuenteResultado);
		lblPropietario.setForeground(Color.WHITE);

		PanelMenu.crearBoton(btnConsultar, PanelMenu.COLOR_REGISTRAR, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Placa (AAA-###):"));
		columna.add(txtfieldPlaca);
		columna.add(PanelMenu.crearLabel("Estado:"));
		columna.add(lblEstado);
		columna.add(PanelMenu.crearLabel("Propietario:"));
		columna.add(lblPropietario);
		columna.add(btnConsultar);
		columna.add(btnVolver);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/ParqueaderoVehiculo.png");
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

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public JLabel getLblPropietario() {
		return lblPropietario;
	}

	public void setLblPropietario(JLabel lblPropietario) {
		this.lblPropietario = lblPropietario;
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