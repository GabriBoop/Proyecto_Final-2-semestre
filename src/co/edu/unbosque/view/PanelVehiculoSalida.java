package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Vista para registrar la salida de un vehículo a partir de su placa.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVehiculoSalida {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(2, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldPlaca = new JTextField();

	private JButton btnRegistrarSalida = new JButton("Registrar Salida");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el campo de placa y los botones, y los organiza bajo la imagen de título.
	 */
	public PanelVehiculoSalida() {
		panel.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);
		columna.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);

		txtfieldPlaca.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

		PanelMenu.crearBoton(btnRegistrarSalida, PanelMenu.COLOR_REGISTRAR, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Placa (AAA-###):"));
		columna.add(txtfieldPlaca);
		columna.add(btnRegistrarSalida);
		columna.add(btnVolver);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/SalidaVehiculo.png");
		PanelMenu.ajustarPanel(panel, imgTitulo, columna);
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
	public JPanel getColumna() {
		return columna;
	}

	/**
	 * Establece el panel que contiene los componentes principales.
	 *
	 * @param columna Nuevo panel que contiene los componentes principales.
	 */
	public void setColumna(JPanel columna) {
		this.columna = columna;
	}

	/**
	 * Obtiene la etiqueta auxiliar de texto.
	 *
	 * @return La etiqueta auxiliar de texto.
	 */
	public JLabel getTxt() {
		return txt;
	}

	/**
	 * Establece la etiqueta auxiliar de texto.
	 *
	 * @param txt Nueva etiqueta auxiliar de texto.
	 */
	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	/**
	 * Obtiene el campo de texto de la placa.
	 *
	 * @return El campo de texto de la placa.
	 */
	public JTextField getTxtfieldPlaca() {
		return txtfieldPlaca;
	}

	/**
	 * Establece el campo de texto de la placa.
	 *
	 * @param txtfieldPlaca Nuevo campo de texto de la placa.
	 */
	public void setTxtfieldPlaca(JTextField txtfieldPlaca) {
		this.txtfieldPlaca = txtfieldPlaca;
	}

	/**
	 * Obtiene el botón "Registrar Salida".
	 *
	 * @return El botón "Registrar Salida".
	 */
	public JButton getBtnRegistrarSalida() {
		return btnRegistrarSalida;
	}

	/**
	 * Establece el botón "Registrar Salida".
	 *
	 * @param btnRegistrarSalida Nuevo botón "Registrar Salida".
	 */
	public void setBtnRegistrarSalida(JButton btnRegistrarSalida) {
		this.btnRegistrarSalida = btnRegistrarSalida;
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