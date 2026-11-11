package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenuReportes {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVehiculosNoche = new JButton("Vehículos que pasaron la Noche");
    private JButton btnVehiculos24h = new JButton("Vehículos con mas de 24 Horas");
    private JButton btnDineroMensual = new JButton("Dinero recaudado mensual");
    private JButton btnVolver = new JButton("Volver");
    
    public PanelMenuReportes() {
    	txt.setText("<html>Reportes<br>");
    	txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		btnVehiculosNoche.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVehiculos24h.setFont(new Font("Arial", Font.PLAIN, 24));
		btnDineroMensual.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 24));
		
		columna.add(txt);
		columna.add(btnVehiculosNoche);
		columna.add(btnVehiculos24h);
		columna.add(btnDineroMensual);
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
