package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PanelVerParqueadero {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel contenedor = new JPanel(new BorderLayout(15, 15));
	private JPanel cabecera = new JPanel(new GridLayout(2, 1, 10, 10));

	private JLabel txt = new JLabel("Estado del Parqueadero", SwingConstants.CENTER);
	private JLabel lblCuposDisponibles = new JLabel("", SwingConstants.CENTER);
	private JTextArea areaVehiculos = new JTextArea(12, 35);
	private JButton btnVolver = new JButton("Volver");
	
	public PanelVerParqueadero() {
		panel.setBackground(PanelMenu.FONDO);
		contenedor.setBackground(PanelMenu.FONDO);
		cabecera.setBackground(PanelMenu.FONDO);
		txt.setFont(new Font("Arial", Font.BOLD, 24));
		lblCuposDisponibles.setFont(new Font("Arial", Font.PLAIN, 18));
		areaVehiculos.setFont(new Font("Arial", Font.PLAIN, 16));
		areaVehiculos.setEditable(false);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cabecera.add(txt);
		cabecera.add(lblCuposDisponibles);
		
		contenedor.add(cabecera, BorderLayout.NORTH);
		contenedor.add(new JScrollPane(areaVehiculos), BorderLayout.CENTER);
		contenedor.add(btnVolver, BorderLayout.SOUTH);

		panel.add(contenedor);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getContenedor() {
		return contenedor;
	}

	public void setContenedor(JPanel contenedor) {
		this.contenedor = contenedor;
	}

	public JPanel getCabecera() {
		return cabecera;
	}

	public void setCabecera(JPanel cabecera) {
		this.cabecera = cabecera;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public JLabel getLblCuposDisponibles() {
		return lblCuposDisponibles;
	}

	public void setLblCuposDisponibles(JLabel lblCuposDisponibles) {
		this.lblCuposDisponibles = lblCuposDisponibles;
	}

	public JTextArea getAreaVehiculos() {
		return areaVehiculos;
	}

	public void setAreaVehiculos(JTextArea areaVehiculos) {
		this.areaVehiculos = areaVehiculos;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}
