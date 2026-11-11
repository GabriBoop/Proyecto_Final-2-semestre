package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class PanelMenuMensualidades {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnRegistrar = new JButton("Registrar Mensualidad");
	private JButton btnVer = new JButton("Ver Mensualidades");
	private JButton btnVacantes= new JButton("Vacantes Mensualidades");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuMensualidades() {
		txt.setText("<html>Mensualidades<br>");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVer.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVacantes.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 24));

		columna.add(txt);
		columna.add(btnRegistrar);
		columna.add(btnVer);
		columna.add(btnVacantes);
		columna.add(btnVolver);
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