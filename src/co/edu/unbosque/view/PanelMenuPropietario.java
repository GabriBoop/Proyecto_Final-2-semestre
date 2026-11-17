package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuPropietario {

	public static final Color FONDO_PROPIETARIO = new Color(4, 38, 34); 

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(3, 1, 0, 30));
	private JButton btnRegistrar = new JButton("Registrar Propietario");
	private JButton btnVer = new JButton("Ver Propietarios");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuPropietario() {
		panel.setBackground(FONDO_PROPIETARIO);
		columna.setBackground(FONDO_PROPIETARIO);

		JLabel imgPropietario = PanelMenu.crearImagen("/co/edu/unbosque/images/Propietarios.png");

		PanelMenu.crearBoton(btnRegistrar, new Color(33, 151, 0), Color.WHITE);
		PanelMenu.crearBoton(btnVer, new Color(24, 140, 60), Color.WHITE);
		PanelMenu.crearBoton(btnVolver, new Color(15, 125, 105), Color.WHITE);

		columna.add(btnRegistrar);
		columna.add(btnVer);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgPropietario, columna);
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

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}