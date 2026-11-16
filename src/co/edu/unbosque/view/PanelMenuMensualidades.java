package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelMenuMensualidades {

	protected static final Color FONDO_MENSUALIDADES = new Color(60, 8, 30);  
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnRegistrar = new JButton("Registrar Mensualidad");
	private JButton btnVer = new JButton("Ver Mensualidades");
	private JButton btnVacantes = new JButton("Vacantes Mensualidades");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuMensualidades() {
		panel.setBackground(FONDO_MENSUALIDADES);
		columna.setBackground(FONDO_MENSUALIDADES);

		JLabel imgMensualidades = PanelMenu.crearImagen("/co/edu/unbosque/images/Mensualidades.png");

		PanelMenu.crearBoton(btnRegistrar, new Color(255, 50, 62), Color.WHITE);
		PanelMenu.crearBoton(btnVer, new Color(255, 50, 100), Color.WHITE);
		PanelMenu.crearBoton(btnVacantes, new Color(250, 50, 140), Color.WHITE);
		PanelMenu.crearBoton(btnVolver, new Color(235, 50, 180), Color.WHITE);

		columna.add(btnRegistrar);
		columna.add(btnVer);
		columna.add(btnVacantes);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgMensualidades, columna);
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

	public JButton getBtnVacantes() {
		return btnVacantes;
	}

	public void setBtnVacantes(JButton btnVacantes) {
		this.btnVacantes = btnVacantes;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}