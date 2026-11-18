package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Vista del menú de reportes. Permite ver los vehículos que pasaron la noche, los que superan las 24 horas y el dinero recaudado en el mes.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMenuReportes {

	/**
	 * Color de fondo de las pantallas del módulo de reportes.
	 */
	public static final Color FONDO_REPORTES = new Color(6, 18, 56);
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 1, 0, 30));
	private JLabel txt = new JLabel();
	private JButton btnVehiculosNoche = new JButton("Vehículos que pasaron la Noche");
	private JButton btnVehiculos24h = new JButton("Vehículos con mas de 24 Horas");
	private JButton btnDineroMensual = new JButton("Dinero recaudado mensual");
	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura el fondo, crea los botones del menú y los organiza bajo la imagen de título.
	 */
	public PanelMenuReportes() {
		panel.setBackground(FONDO_REPORTES);
		columna.setBackground(FONDO_REPORTES);

		JLabel imgReportes = PanelMenu.crearImagen("/co/edu/unbosque/images/Reportes.png");

		crearBotonReportes(btnVehiculosNoche, new Color(0, 50, 255), Color.WHITE);
		crearBotonReportes(btnVehiculos24h, new Color(0, 90, 235), Color.WHITE);
		crearBotonReportes(btnDineroMensual, new Color(0, 130, 215), Color.WHITE);
		crearBotonReportes(btnVolver, new Color(0, 165, 195), Color.WHITE);

		columna.add(btnVehiculosNoche);
		columna.add(btnVehiculos24h);
		columna.add(btnDineroMensual);
		columna.add(btnVolver);
		PanelMenu.ajustarPanel(panel, imgReportes, columna);
	}
	
	/**
	 * Aplica el estilo de los botones del menú de reportes (más anchos que los estándar).
	 *
	 * @param boton Botón a configurar.
	 * @param color Color de fondo del botón.
	 * @param txtColor Color del texto y del borde del botón.
	 */
	private void crearBotonReportes(JButton boton, Color color, Color txtColor) {
		boton.setPreferredSize(new Dimension(450,50));
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
	 * Obtiene el botón "Vehículos que pasaron la Noche".
	 *
	 * @return El botón "Vehículos que pasaron la Noche".
	 */
	public JButton getBtnVehiculosNoche() {
		return btnVehiculosNoche;
	}

	/**
	 * Establece el botón "Vehículos que pasaron la Noche".
	 *
	 * @param btnVehiculosNoche Nuevo botón "Vehículos que pasaron la Noche".
	 */
	public void setBtnVehiculosNoche(JButton btnVehiculosNoche) {
		this.btnVehiculosNoche = btnVehiculosNoche;
	}

	/**
	 * Obtiene el botón "Vehículos con mas de 24 Horas".
	 *
	 * @return El botón "Vehículos con mas de 24 Horas".
	 */
	public JButton getBtnVehiculos24h() {
		return btnVehiculos24h;
	}

	/**
	 * Establece el botón "Vehículos con mas de 24 Horas".
	 *
	 * @param btnVehiculos24h Nuevo botón "Vehículos con mas de 24 Horas".
	 */
	public void setBtnVehiculos24h(JButton btnVehiculos24h) {
		this.btnVehiculos24h = btnVehiculos24h;
	}

	/**
	 * Obtiene el botón "Dinero recaudado mensual".
	 *
	 * @return El botón "Dinero recaudado mensual".
	 */
	public JButton getBtnDineroMensual() {
		return btnDineroMensual;
	}

	/**
	 * Establece el botón "Dinero recaudado mensual".
	 *
	 * @param btnDineroMensual Nuevo botón "Dinero recaudado mensual".
	 */
	public void setBtnDineroMensual(JButton btnDineroMensual) {
		this.btnDineroMensual = btnDineroMensual;
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