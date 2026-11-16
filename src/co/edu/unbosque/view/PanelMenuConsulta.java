package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenuConsulta {

	protected static final Color FONDO_CONSULTA = new Color(48, 8, 58);   

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVerRegistros = new JButton("Ver Registros");
	private JButton btnVerFacturas = new JButton("Ver Facturas");
	private JButton btnUltimaFactura = new JButton("Última Factura");
	private JButton btnBuscarFactura = new JButton("Buscar Factura");
	private JButton btnVolver = new JButton("Volver");

	public PanelMenuConsulta() {
		panel.setBackground(FONDO_CONSULTA);
		columna.setBackground(FONDO_CONSULTA);

		JLabel imgConsultas = PanelMenu.crearImagen("/co/edu/unbosque/images/Consultas.png");

		PanelMenu.crearBoton(btnVerRegistros, new Color(255, 4, 254), Color.WHITE);
		PanelMenu.crearBoton(btnVerFacturas, new Color(228, 4, 254), Color.WHITE);
		PanelMenu.crearBoton(btnUltimaFactura, new Color(200, 4, 254), Color.WHITE);
		PanelMenu.crearBoton(btnBuscarFactura, new Color(172, 4, 254), Color.WHITE);
		PanelMenu.crearBoton(btnVolver, new Color(144, 4, 254), Color.WHITE);

		columna.add(btnVerRegistros);
		columna.add(btnVerFacturas);
		columna.add(btnUltimaFactura);
		columna.add(btnBuscarFactura);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgConsultas, columna);
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
