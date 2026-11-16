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

public class PanelMenu {
	
	protected static final Color FONDO = new Color(69, 36, 0);
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
		
		crearBotonImagen(btnRegistrarPropietario, "/co/edu/unbosque/images/BTN_Propietario.png");
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
	
	public static JLabel crearImagen(String ruta) {
		JLabel label = new JLabel();
		java.net.URL url = PanelMenu.class.getResource(ruta);

		if (url != null) {
			label.setIcon(new ImageIcon(url));
		}
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
	
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
	
	protected static JLabel crearLabel(String txt) {
		JLabel lbl = new JLabel(txt);
		lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		lbl.setForeground(Color.WHITE);
		return lbl;
	}
	
	protected static void crearBoton(JButton boton, Color color, Color txtColor) {
		boton.setPreferredSize(new Dimension(350,50));
		boton.setBackground(color);
		boton.setForeground(txtColor);
		boton.setOpaque(true);
		boton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		boton.setFocusPainted(false);
		boton.setBorder(BorderFactory.createLineBorder(txtColor, 4));
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
	

	public JButton getBtnRegistrarPropietario() {
		return btnRegistrarPropietario;
	}

	public void setBtnRegistrarPropietario(JButton btnRegistrarPropietario) {
		this.btnRegistrarPropietario = btnRegistrarPropietario;
	}

	public JButton getBtnVerVehiculos() {
		return btnVerVehiculos;
	}

	public void setBtnVerVehiculos(JButton btnVerVehiculos) {
		this.btnVerVehiculos = btnVerVehiculos;
	}

	public JButton getBtnMensualidades() {
		return btnMensualidades;
	}

	public void setBtnMensualidades(JButton btnMensualidades) {
		this.btnMensualidades = btnMensualidades;
	}

	public JButton getBtnConsultas() {
		return btnConsultas;
	}

	public void setBtnConsultas(JButton btnConsultas) {
		this.btnConsultas = btnConsultas;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}

	public void setBtnReportes(JButton btnReportes) {
		this.btnReportes = btnReportes;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}


}