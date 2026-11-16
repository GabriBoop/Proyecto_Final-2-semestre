package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PanelVerParqueadero {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel contenedor = new JPanel(new BorderLayout(15, 15));

	private JLabel lblCuposDisponibles = new JLabel("", SwingConstants.CENTER);
	private JTextArea areaVehiculos = new JTextArea(12, 35);
	private JButton btnVolver = new JButton("Volver");

	public PanelVerParqueadero() {
		panel.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);
		contenedor.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);

		lblCuposDisponibles.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		lblCuposDisponibles.setForeground(Color.WHITE);

		areaVehiculos.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		areaVehiculos.setEditable(false);

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		contenedor.add(lblCuposDisponibles, BorderLayout.NORTH);
		contenedor.add(new JScrollPane(areaVehiculos), BorderLayout.CENTER);
		contenedor.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/Parqueadero.png");
		PanelMenu.ajustarPanel(panel, imgTitulo, contenedor);
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