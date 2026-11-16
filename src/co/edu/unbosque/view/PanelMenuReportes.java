package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuReportes {

	public static final Color FONDO_REPORTES = new Color(6, 18, 56);
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVehiculosNoche = new JButton("Vehículos que pasaron la Noche");
	private JButton btnVehiculos24h = new JButton("Vehículos con mas de 24 Horas");
	private JButton btnDineroMensual = new JButton("Dinero recaudado mensual");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuReportes() {
		panel.setBackground(FONDO_REPORTES);
		columna.setBackground(FONDO_REPORTES);

		JLabel imgReportes = PanelMenu.crearImagen("/co/edu/unbosque/images/Reportes.png");

		crearBotonReportes(btnVehiculosNoche, new Color(0, 50, 255), Color.WHITE);
		crearBotonReportes(btnVehiculos24h, new Color(0, 90, 235), Color.WHITE);
		crearBotonReportes(btnDineroMensual, new Color(0, 130, 215), Color.WHITE);
		crearBotonReportes(btnVolver, new Color(0, 165, 195), Color.WHITE);

		columna.add(btnVehiculosNoche);
		columna.add(btnVehiculos24h);
		columna.add(btnDineroMensual);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgReportes, columna);
	}
	
	private void crearBotonReportes(JButton boton, Color color, Color txtColor) {
		boton.setPreferredSize(new Dimension(450,50));
		boton.setBackground(color);
		boton.setForeground(txtColor);
		boton.setOpaque(true);
		boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		boton.setFocusPainted(false);
		boton.setBorder(BorderFactory.createLineBorder(txtColor, 4));
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

	public JButton getBtnVehiculosNoche() {
		return btnVehiculosNoche;
	}

	public void setBtnVehiculosNoche(JButton btnVehiculosNoche) {
		this.btnVehiculosNoche = btnVehiculosNoche;
	}

	public JButton getBtnVehiculos24h() {
		return btnVehiculos24h;
	}

	public void setBtnVehiculos24h(JButton btnVehiculos24h) {
		this.btnVehiculos24h = btnVehiculos24h;
	}

	public JButton getBtnDineroMensual() {
		return btnDineroMensual;
	}

	public void setBtnDineroMensual(JButton btnDineroMensual) {
		this.btnDineroMensual = btnDineroMensual;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
    
}
