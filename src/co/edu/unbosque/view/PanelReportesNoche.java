package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Vista del reporte de vehículos que pasaron la noche en el parqueadero.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelReportesNoche {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblResumen = PanelMenu.crearLabel("");
	private JTextArea areaReporte = new JTextArea();
	private JScrollPane scrollReporte = new JScrollPane(areaReporte);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta de resumen, el área de texto de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelReportesNoche() {
		panel.setBackground(PanelMenuReportes.FONDO_REPORTES);
		columna.setBackground(PanelMenuReportes.FONDO_REPORTES);

		lblResumen.setHorizontalAlignment(SwingConstants.CENTER);

		areaReporte.setEditable(false);
		areaReporte.setLineWrap(true);
		areaReporte.setWrapStyleWord(true);
		areaReporte.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		scrollReporte.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblResumen, BorderLayout.NORTH);
		columna.add(scrollReporte, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VehiculosNoche.png");
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
	 * Obtiene la etiqueta del resumen del reporte.
	 *
	 * @return La etiqueta del resumen del reporte.
	 */
	public JLabel getLblResumen() {
		return lblResumen;
	}

	/**
	 * Establece la etiqueta del resumen del reporte.
	 *
	 * @param lblResumen Nueva etiqueta del resumen del reporte.
	 */
	public void setLblResumen(JLabel lblResumen) {
		this.lblResumen = lblResumen;
	}

	/**
	 * Obtiene el área de texto del reporte.
	 *
	 * @return El área de texto del reporte.
	 */
	public JTextArea getAreaReporte() {
		return areaReporte;
	}

	/**
	 * Establece el área de texto del reporte.
	 *
	 * @param areaReporte Nuevo área de texto del reporte.
	 */
	public void setAreaReporte(JTextArea areaReporte) {
		this.areaReporte = areaReporte;
	}

	/**
	 * Obtiene el panel de desplazamiento del reporte.
	 *
	 * @return El panel de desplazamiento del reporte.
	 */
	public JScrollPane getScrollReporte() {
		return scrollReporte;
	}

	/**
	 * Establece el panel de desplazamiento del reporte.
	 *
	 * @param scrollReporte Nuevo panel de desplazamiento del reporte.
	 */
	public void setScrollReporte(JScrollPane scrollReporte) {
		this.scrollReporte = scrollReporte;
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