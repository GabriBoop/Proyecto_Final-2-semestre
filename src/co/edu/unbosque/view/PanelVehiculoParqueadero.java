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
 * Vista para consultar si un vehículo se encuentra en el parqueadero a partir de su placa. Muestra su estado y su propietario.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelVehiculoParqueadero {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldPlaca = new JTextField();
	private JLabel lblEstado = new JLabel("");
	private JLabel lblPropietario = new JLabel("");

	private JButton btnConsultar = new JButton("Consultar");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el campo de placa, las etiquetas de resultado y los botones, y los organiza bajo la imagen de título.
	 */
	public PanelVehiculoParqueadero() {
		panel.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);
		columna.setBackground(PanelMenuVehiculo.FONDO_VEHICULO);

		txtfieldPlaca.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

		Font fuenteResultado = new Font("Arial", Font.BOLD, 24);
		lblEstado.setFont(fuenteResultado);
		lblEstado.setForeground(Color.WHITE);
		lblPropietario.setFont(fuenteResultado);
		lblPropietario.setForeground(Color.WHITE);

		PanelMenu.crearBoton(btnConsultar, PanelMenu.COLOR_REGISTRAR, Color.WHITE);
		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(PanelMenu.crearLabel("Placa (AAA-###):"));
		columna.add(txtfieldPlaca);
		columna.add(PanelMenu.crearLabel("Estado:"));
		columna.add(lblEstado);
		columna.add(PanelMenu.crearLabel("Propietario:"));
		columna.add(lblPropietario);
		columna.add(btnConsultar);
		columna.add(btnVolver);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/ParqueaderoVehiculo.png");
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
	 * Obtiene la etiqueta del estado del vehículo.
	 *
	 * @return La etiqueta del estado del vehículo.
	 */
	public JLabel getLblEstado() {
		return lblEstado;
	}

	/**
	 * Establece la etiqueta del estado del vehículo.
	 *
	 * @param lblEstado Nueva etiqueta del estado del vehículo.
	 */
	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	/**
	 * Obtiene la etiqueta del propietario del vehículo.
	 *
	 * @return La etiqueta del propietario del vehículo.
	 */
	public JLabel getLblPropietario() {
		return lblPropietario;
	}

	/**
	 * Establece la etiqueta del propietario del vehículo.
	 *
	 * @param lblPropietario Nueva etiqueta del propietario del vehículo.
	 */
	public void setLblPropietario(JLabel lblPropietario) {
		this.lblPropietario = lblPropietario;
	}

	/**
	 * Obtiene el botón "Consultar".
	 *
	 * @return El botón "Consultar".
	 */
	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	/**
	 * Establece el botón "Consultar".
	 *
	 * @param btnConsultar Nuevo botón "Consultar".
	 */
	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
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