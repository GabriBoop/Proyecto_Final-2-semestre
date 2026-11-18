package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;

import javax.swing.*;

/**
 * Vista del menú principal del sistema. Muestra el logo del parqueadero y los botones de acceso a Propietarios, Vehículos, Mensualidades, Consultas, Reportes y Salir.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMenu {
	
	/**
	 * Color de fondo del menú principal.
	 */
	protected static final Color FONDO = new Color(37, 4, 2);
	/**
	 * Color de los botones de acción principal (registrar, consultar).
	 */
	protected static final Color COLOR_REGISTRAR = new Color(75, 30, 255);
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(6, 1, 0, 10));
	private JLabel txt = new JLabel();
	private JButton btnRegistrarPropietario = new JButton("Registrar Propietario");
	private JButton btnVerVehiculos = new JButton("Vehiculos");
	private JButton btnMensualidades = new JButton("Mensualidades");
	private JButton btnConsultas = new JButton("Consultas");
	private JButton btnReportes = new JButton("Reportes");
	private JButton btnSalir = new JButton("Salir");

	/**
	 * Construye el menú principal: configura los colores, carga el logo (o un texto si la imagen no existe), crea los botones con imagen y los organiza en la columna.
	 */
	public PanelMenu() {
		panel.setBackground(FONDO);
		columna.setBackground(FONDO);
		
		URL url = getClass().getResource("/co/edu/unbosque/images/Logo.png");
		
		if (url != null) {
			ImageIcon img = new ImageIcon(url);
			Image logo = img.getImage();
			txt.setIcon(new ImageIcon(logo));
		} else {
			txt.setText("Parqueadero UEB"); 
			txt.setFont(new Font("Arial", Font.BOLD, 26));
		}
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		txt.setFont(new Font("Arial", Font.BOLD, 26));
		
		crearBotonImagen(btnRegistrarPropietario, "/co/edu/unbosque/images/BTN_Propietarios.png");
		crearBotonImagen(btnVerVehiculos, "/co/edu/unbosque/images/BTN_Vehiculo.png");
		crearBotonImagen(btnMensualidades, "/co/edu/unbosque/images/BTN_Mensualidades.png");
		crearBotonImagen(btnConsultas, "/co/edu/unbosque/images/BTN_Consultas.png");
		crearBotonImagen(btnReportes, "/co/edu/unbosque/images/BTN_Reportes.png");
		crearBotonImagen(btnSalir, "/co/edu/unbosque/images/BTN_Salir.png");

		columna.add(btnRegistrarPropietario);
		columna.add(btnVerVehiculos);
		columna.add(btnMensualidades);
		columna.add(btnConsultas);
		columna.add(btnReportes);
		columna.add(btnSalir);
		txt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 24));
		ajustarPanel(panel,txt,columna);
	}
	
	/**
	 * Configura un botón para que muestre una imagen en lugar de texto, sin borde ni relleno.
	 * Si la imagen no se encuentra, usa el texto del botón con una fuente estándar.
	 *
	 * @param boton Botón a configurar.
	 * @param ruta Ruta de la imagen dentro del classpath.
	 */
	private void crearBotonImagen(JButton boton, String ruta) {
		URL url = getClass().getResource(ruta);
		boton.setPreferredSize(new Dimension(350,100));
		if (url != null) {
			ImageIcon img = new ImageIcon(url);
			Image imagen = img.getImage();
			boton.setIcon(new ImageIcon(imagen));
			boton.setText("");
			boton.setBorderPainted(false);
			boton.setContentAreaFilled(false);
			boton.setFocusPainted(false);
		} else {
			boton.setFont(new Font("Arial", Font.PLAIN, 24));
		}
	}
	
	/**
	 * Crea una etiqueta centrada que muestra una imagen. Si la imagen no existe, la etiqueta queda vacía.
	 *
	 * @param ruta Ruta de la imagen dentro del classpath.
	 * @return Etiqueta con la imagen cargada.
	 */
	public static JLabel crearImagen(String ruta) {
		JLabel label = new JLabel();
		URL url = PanelMenu.class.getResource(ruta);

		if (url != null) {
			label.setIcon(new ImageIcon(url));
		}
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
	
	/**
	 * Organiza un panel con la imagen de título arriba y el contenido debajo, usando GridBagLayout.
	 *
	 * @param panel Panel principal que se va a organizar.
	 * @param titulo Etiqueta con la imagen de título.
	 * @param contenido Panel con los componentes principales.
	 */
	protected static void ajustarPanel(JPanel panel, JLabel titulo, JPanel contenido) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 30, 0);
		panel.add(titulo, gbc);

		gbc.gridy = 1;
		gbc.insets = new Insets(0, 0, 0, 0);
		panel.add(contenido, gbc);
	}
	
	/**
	 * Crea una etiqueta con la fuente y el color estándar de los formularios (negrita 24, texto blanco).
	 *
	 * @param txt Texto de la etiqueta.
	 * @return Etiqueta configurada.
	 */
	protected static JLabel crearLabel(String txt) {
		JLabel lbl = new JLabel(txt);
		lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		lbl.setForeground(Color.WHITE);
		return lbl;
	}
	
	/**
	 * Aplica el estilo estándar a un botón (tamaño, colores, fuente y borde).
	 *
	 * @param boton Botón a configurar.
	 * @param color Color de fondo del botón.
	 * @param txtColor Color del texto y del borde del botón.
	 */
	protected static void crearBoton(JButton boton, Color color, Color txtColor) {
		boton.setPreferredSize(new Dimension(350,50));
		boton.setBackground(color);
		boton.setForeground(txtColor);
		boton.setOpaque(true);
		boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		boton.setFocusPainted(false);
		boton.setBorder(BorderFactory.createLineBorder(txtColor, 4));
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
	 * Obtiene el botón "Registrar Propietario".
	 *
	 * @return El botón "Registrar Propietario".
	 */
	public JButton getBtnRegistrarPropietario() {
		return btnRegistrarPropietario;
	}

	/**
	 * Establece el botón "Registrar Propietario".
	 *
	 * @param btnRegistrarPropietario Nuevo botón "Registrar Propietario".
	 */
	public void setBtnRegistrarPropietario(JButton btnRegistrarPropietario) {
		this.btnRegistrarPropietario = btnRegistrarPropietario;
	}

	/**
	 * Obtiene el botón "Vehiculos".
	 *
	 * @return El botón "Vehiculos".
	 */
	public JButton getBtnVerVehiculos() {
		return btnVerVehiculos;
	}

	/**
	 * Establece el botón "Vehiculos".
	 *
	 * @param btnVerVehiculos Nuevo botón "Vehiculos".
	 */
	public void setBtnVerVehiculos(JButton btnVerVehiculos) {
		this.btnVerVehiculos = btnVerVehiculos;
	}

	/**
	 * Obtiene el botón "Mensualidades".
	 *
	 * @return El botón "Mensualidades".
	 */
	public JButton getBtnMensualidades() {
		return btnMensualidades;
	}

	/**
	 * Establece el botón "Mensualidades".
	 *
	 * @param btnMensualidades Nuevo botón "Mensualidades".
	 */
	public void setBtnMensualidades(JButton btnMensualidades) {
		this.btnMensualidades = btnMensualidades;
	}

	/**
	 * Obtiene el botón "Consultas".
	 *
	 * @return El botón "Consultas".
	 */
	public JButton getBtnConsultas() {
		return btnConsultas;
	}

	/**
	 * Establece el botón "Consultas".
	 *
	 * @param btnConsultas Nuevo botón "Consultas".
	 */
	public void setBtnConsultas(JButton btnConsultas) {
		this.btnConsultas = btnConsultas;
	}

	/**
	 * Obtiene el botón "Reportes".
	 *
	 * @return El botón "Reportes".
	 */
	public JButton getBtnReportes() {
		return btnReportes;
	}

	/**
	 * Establece el botón "Reportes".
	 *
	 * @param btnReportes Nuevo botón "Reportes".
	 */
	public void setBtnReportes(JButton btnReportes) {
		this.btnReportes = btnReportes;
	}


	/**
	 * Obtiene el botón "Salir".
	 *
	 * @return El botón "Salir".
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Establece el botón "Salir".
	 *
	 * @param btnSalir Nuevo botón "Salir".
	 */
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


}