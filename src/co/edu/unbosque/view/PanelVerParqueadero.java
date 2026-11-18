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

/**
 * Vista que muestra el estado del parqueadero: los cupos disponibles y los vehículos que se encuentran dentro.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVerParqueadero {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel contenedor = new JPanel(new BorderLayout(15, 15));

	private JLabel lblCuposDisponibles = new JLabel("", SwingConstants.CENTER);
	private JTextArea areaVehiculos = new JTextArea(12, 35);
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta de cupos, el área de texto de solo lectura y el botón, y los organiza bajo la imagen de título.
	 */
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

	/**
	 * Obtiene el panel principal.
	 *
	 * @return El panel principal.
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Establece el panel principal.
	 *
	 * @param panel Nuevo panel principal.
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Obtiene el panel que contiene los componentes principales.
	 *
	 * @return El panel que contiene los componentes principales.
	 */
	public JPanel getContenedor() {
		return contenedor;
	}

	/**
	 * Establece el panel que contiene los componentes principales.
	 *
	 * @param contenedor Nuevo panel que contiene los componentes principales.
	 */
	public void setContenedor(JPanel contenedor) {
		this.contenedor = contenedor;
	}

	/**
	 * Obtiene la etiqueta de los cupos disponibles.
	 *
	 * @return La etiqueta de los cupos disponibles.
	 */
	public JLabel getLblCuposDisponibles() {
		return lblCuposDisponibles;
	}

	/**
	 * Establece la etiqueta de los cupos disponibles.
	 *
	 * @param lblCuposDisponibles Nueva etiqueta de los cupos disponibles.
	 */
	public void setLblCuposDisponibles(JLabel lblCuposDisponibles) {
		this.lblCuposDisponibles = lblCuposDisponibles;
	}

	/**
	 * Obtiene el área de texto de los vehículos.
	 *
	 * @return El área de texto de los vehículos.
	 */
	public JTextArea getAreaVehiculos() {
		return areaVehiculos;
	}

	/**
	 * Establece el área de texto de los vehículos.
	 *
	 * @param areaVehiculos Nuevo área de texto de los vehículos.
	 */
	public void setAreaVehiculos(JTextArea areaVehiculos) {
		this.areaVehiculos = areaVehiculos;
	}

	/**
	 * Obtiene el botón "Volver".
	 *
	 * @return El botón "Volver".
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * Establece el botón "Volver".
	 *
	 * @param btnVolver Nuevo botón "Volver".
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}