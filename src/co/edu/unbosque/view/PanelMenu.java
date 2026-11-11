package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class PanelMenu {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(7, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVerVehiculos = new JButton("Vehiculos");
	private JButton btnMensualidades = new JButton("Mensualidades");
	private JButton btnConsultas = new JButton("Consultas");
	private JButton btnReportes = new JButton("Reportes");
	private JButton btnArchivo = new JButton("Archivos");
	private JButton btnSalir = new JButton("Salir");

	public PanelMenu() {
		txt.setText("<html>[ADMIN]<br>"
				+ "<html>Bienvenido Al Parqueadero UEB<br>");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		btnVerVehiculos.setFont(new Font("Arial", Font.PLAIN, 24));
		btnMensualidades.setFont(new Font("Arial", Font.PLAIN, 24));
		btnConsultas.setFont(new Font("Arial", Font.PLAIN, 24));
		btnReportes.setFont(new Font("Arial", Font.PLAIN, 24));
		btnArchivo.setFont(new Font("Arial", Font.PLAIN, 24));
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 24));

		columna.add(txt);
		columna.add(btnVerVehiculos);
		columna.add(btnMensualidades);
		columna.add(btnConsultas);
		columna.add(btnReportes);
		columna.add(btnArchivo);
		columna.add(btnSalir);
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

	public JButton getBtnVerVehiculos() {
		return btnVerVehiculos;
	}

	public void setBtnVerVehiculos(JButton btnVerVehiculos) {
		this.btnVerVehiculos = btnVerVehiculos;
	}

	public JButton getBtnMensualidades() {
		return btnMensualidades;
	}

	public void setBtnMensualidades(JButton btnMensualidades) {
		this.btnMensualidades = btnMensualidades;
	}

	public JButton getBtnConsultas() {
		return btnConsultas;
	}

	public void setBtnConsultas(JButton btnConsultas) {
		this.btnConsultas = btnConsultas;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}

	public void setBtnReportes(JButton btnReportes) {
		this.btnReportes = btnReportes;
	}

	public JButton getBtnArchivo() {
		return btnArchivo;
	}

	public void setBtnArchivo(JButton btnArchivo) {
		this.btnArchivo = btnArchivo;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


}