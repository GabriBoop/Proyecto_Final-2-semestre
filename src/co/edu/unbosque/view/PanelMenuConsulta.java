package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Vista del menú de consultas. Permite acceder a ver registros, ver facturas, consultar la última factura y buscar una factura.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMenuConsulta {

	/**
	 * Color de fondo de las pantallas del módulo de consultas.
	 */
	protected static final Color FONDO_CONSULTA = new Color(48, 8, 58);   

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVerRegistros = new JButton("Ver Registros");
	private JButton btnVerFacturas = new JButton("Ver Facturas");
	private JButton btnUltimaFactura = new JButton("Última Factura");
	private JButton btnBuscarFactura = new JButton("Buscar Factura");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el fondo, crea los botones del menú y los organiza bajo la imagen de título.
	 */
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
	 * Obtiene el botón "Ver Registros".
	 *
	 * @return El botón "Ver Registros".
	 */
	public JButton getBtnVerRegistros() {
		return btnVerRegistros;
	}

	/**
	 * Establece el botón "Ver Registros".
	 *
	 * @param btnVerRegistros Nuevo botón "Ver Registros".
	 */
	public void setBtnVerRegistros(JButton btnVerRegistros) {
		this.btnVerRegistros = btnVerRegistros;
	}

	/**
	 * Obtiene el botón "Ver Facturas".
	 *
	 * @return El botón "Ver Facturas".
	 */
	public JButton getBtnVerFacturas() {
		return btnVerFacturas;
	}

	/**
	 * Establece el botón "Ver Facturas".
	 *
	 * @param btnVerFacturas Nuevo botón "Ver Facturas".
	 */
	public void setBtnVerFacturas(JButton btnVerFacturas) {
		this.btnVerFacturas = btnVerFacturas;
	}

	/**
	 * Obtiene el botón "Última Factura".
	 *
	 * @return El botón "Última Factura".
	 */
	public JButton getBtnUltimaFactura() {
		return btnUltimaFactura;
	}

	/**
	 * Establece el botón "Última Factura".
	 *
	 * @param btnUltimaFactura Nuevo botón "Última Factura".
	 */
	public void setBtnUltimaFactura(JButton btnUltimaFactura) {
		this.btnUltimaFactura = btnUltimaFactura;
	}

	/**
	 * Obtiene el botón "Buscar Factura".
	 *
	 * @return El botón "Buscar Factura".
	 */
	public JButton getBtnBuscarFactura() {
		return btnBuscarFactura;
	}

	/**
	 * Establece el botón "Buscar Factura".
	 *
	 * @param btnBuscarFactura Nuevo botón "Buscar Factura".
	 */
	public void setBtnBuscarFactura(JButton btnBuscarFactura) {
		this.btnBuscarFactura = btnBuscarFactura;
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