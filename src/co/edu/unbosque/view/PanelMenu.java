package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;

import javax.swing.*;

public class PanelMenu {
	
	protected static final Color FONDO = new Color(255, 238, 153);

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnRegistrarPropietario = new JButton("Registrar Propietario");
	private JButton btnVerVehiculos = new JButton("Vehiculos");
	private JButton btnMensualidades = new JButton("Mensualidades");
	private JButton btnConsultas = new JButton("Consultas");
	private JButton btnReportes = new JButton("Reportes");
	private JButton btnSalir = new JButton("Salir");

	public PanelMenu() {
		panel.setBackground(FONDO);
		columna.setBackground(FONDO);
		
		URL url = getClass().getResource("/co/edu/unbosque/images/Logo.png");
		
		if (url != null) {
			ImageIcon img = new ImageIcon(url);
			Image logo = img.getImage();
			txt.setIcon(new ImageIcon(logo));
		} else {
			txt.setText("Parqueadero UEB"); 
			txt.setFont(new Font("Arial", Font.BOLD, 26));
		}
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		btnRegistrarPropietario.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVerVehiculos.setFont(new Font("Arial", Font.PLAIN, 24));
		btnMensualidades.setFont(new Font("Arial", Font.PLAIN, 24));
		btnConsultas.setFont(new Font("Arial", Font.PLAIN, 24));
		btnReportes.setFont(new Font("Arial", Font.PLAIN, 24));
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 24));

		columna.add(btnRegistrarPropietario);
		columna.add(btnVerVehiculos);
		columna.add(btnMensualidades);
		columna.add(btnConsultas);
		columna.add(btnReportes);
		columna.add(btnSalir);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 30, 0);
		panel.add(txt, gbc);

		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(columna, gbc);
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
	

	public JButton getBtnRegistrarPropietario() {
		return btnRegistrarPropietario;
	}

	public void setBtnRegistrarPropietario(JButton btnRegistrarPropietario) {
		this.btnRegistrarPropietario = btnRegistrarPropietario;
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


	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


}