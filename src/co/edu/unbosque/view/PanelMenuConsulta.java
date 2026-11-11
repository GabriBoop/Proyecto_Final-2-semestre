package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMenuConsulta extends JPanel {
	
	private JLabel txt = new JLabel();
	private JButton btnVerRegistros;
    private JButton btnVerFacturas;
    private JButton btnUltimaFactura;
    private JButton btnBuscarFactura;
    private JButton btnVolver;
    
    public PanelMenuConsulta() {
    	setLayout(new GridLayout(6, 1, 15, 15));
    	setBorder(new EmptyBorder(20, 50, 20, 50));
    	inicializarComponentes();
    }
    
    public void inicializarComponentes() {
    	txt.setText("Consultas");
    	btnVerRegistros = new JButton("Ver Registros");
    	btnVerRegistros.setActionCommand("VER_REGISTROS");
    	
    	btnVerFacturas = new JButton("Ver Facturas");
        btnVerFacturas.setActionCommand("VER_FACTURAS");

        btnUltimaFactura = new JButton("Última Factura");
        btnUltimaFactura.setActionCommand("ULTIMA_FACTURA");

        btnBuscarFactura = new JButton("Buscar Factura");
        btnBuscarFactura.setActionCommand("BUSCAR_FACTURA");

        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER_MENU_PRINCIPAL");

        add(txt);
        add(btnVerRegistros);
        add(btnVerFacturas);
        add(btnUltimaFactura);
        add(btnBuscarFactura);
        add(btnVolver);
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
