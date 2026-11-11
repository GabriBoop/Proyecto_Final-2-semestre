package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMenuReportes extends JPanel {
	
	private JButton btnVehiculosNoche;
    private JButton btnVehiculos24h;
    private JButton btnDineroMensual;
    private JButton btnVolver;
    
    public PanelMenuReportes() {
        setLayout(new GridLayout(4, 1, 15, 15));
        setBorder(new EmptyBorder(20, 50, 20, 50));
        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
    	btnVehiculosNoche = new JButton("Vehículos que pasaron la Noche");
        btnVehiculosNoche.setActionCommand("REP_VEHICULOS_NOCHE");

        btnVehiculos24h = new JButton("Vehículos con mas de 24 Horas");
        btnVehiculos24h.setActionCommand("REP_VEHICULOS_+24H");

        btnDineroMensual = new JButton("Dinero recaudado mensual");
        btnDineroMensual.setActionCommand("REP_DINERO_MENSUAL");
        
        btnVolver = new JButton("Volver");
        btnVolver.setActionCommand("VOLVER_MENU_PRINCIPAL");

        add(btnVehiculosNoche);
        add(btnVehiculos24h);
        add(btnDineroMensual);
        add(btnVolver);
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
