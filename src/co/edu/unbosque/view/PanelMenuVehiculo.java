package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class PanelMenuVehiculo {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnRegistrar = new JButton("Registrar Vehiculo");
	private JButton btnSalida = new JButton("Salida de Vehiculo");
	private JButton btnParqueado = new JButton("Vehiculo Parqueado");
	private JButton btnVerParqueado = new JButton("Ver Vehiculo Parqueado");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuVehiculo() {
		txt.setText("<html>Vehiculo<br>");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 24));
		btnSalida.setFont(new Font("Arial", Font.PLAIN, 24));
		btnParqueado.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVerParqueado.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 24));

		columna.add(txt);
		columna.add(btnRegistrar);
		columna.add(btnSalida);
		columna.add(btnParqueado);
		columna.add(btnVerParqueado);
		columna.add(btnVolver);
		panel.add(columna);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnSalida() {
		return btnSalida;
	}

	public JButton getBtnParqueado() {
		return btnParqueado;
	}

	public JButton getBtnVerParqueado() {
		return btnVerParqueado;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}