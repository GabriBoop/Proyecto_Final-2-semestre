package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenuConsulta {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVerRegistros = new JButton("Ver Registros");
    private JButton btnVerFacturas = new JButton("Ver Facturas");
    private JButton btnUltimaFactura = new JButton("Última Factura");
    private JButton btnBuscarFactura = new JButton("Buscar Factura");
    private JButton btnVolver = new JButton("Volver");
    
    public PanelMenuConsulta() {
    	txt.setText("<html>Consultas<br>");
    	txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		btnVerRegistros.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVerFacturas.setFont(new Font("Arial", Font.PLAIN, 24));
		btnUltimaFactura.setFont(new Font("Arial", Font.PLAIN, 24));
		btnBuscarFactura.setFont(new Font("Arial", Font.PLAIN, 24));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 24));
    	
		columna.add(txt);
		columna.add(btnVerRegistros);
		columna.add(btnVerFacturas);
		columna.add(btnUltimaFactura);
		columna.add(btnBuscarFactura);
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

	public JButton getBtnVerRegistros() {
		return btnVerRegistros;
	}

	public void setBtnVerRegistros(JButton btnVerRegistros) {
		this.btnVerRegistros = btnVerRegistros;
	}

	public JButton getBtnVerFacturas() {
		return btnVerFacturas;
	}

	public void setBtnVerFacturas(JButton btnVerFacturas) {
		this.btnVerFacturas = btnVerFacturas;
	}

	public JButton getBtnUltimaFactura() {
		return btnUltimaFactura;
	}

	public void setBtnUltimaFactura(JButton btnUltimaFactura) {
		this.btnUltimaFactura = btnUltimaFactura;
	}

	public JButton getBtnBuscarFactura() {
		return btnBuscarFactura;
	}

	public void setBtnBuscarFactura(JButton btnBuscarFactura) {
		this.btnBuscarFactura = btnBuscarFactura;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
    
}
