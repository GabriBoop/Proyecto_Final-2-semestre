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
 * Vista del reporte del dinero recaudado durante el mes actual.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelReportesDineroMensual {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalRecaudado = PanelMenu.crearLabel("");
	private JTextArea areaDetalle = new JTextArea();
	private JScrollPane scrollDetalle = new JScrollPane(areaDetalle);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura la etiqueta del total recaudado, el área de detalle de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelReportesDineroMensual() {
		panel.setBackground(PanelMenuReportes.FONDO_REPORTES);
		columna.setBackground(PanelMenuReportes.FONDO_REPORTES);

		lblTotalRecaudado.setHorizontalAlignment(SwingConstants.CENTER);

		areaDetalle.setEditable(false);
		areaDetalle.setLineWrap(true);
		areaDetalle.setWrapStyleWord(true);
		areaDetalle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		scrollDetalle.setPreferredSize(new Dimension(550, 180));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalRecaudado, BorderLayout.NORTH);
		columna.add(scrollDetalle, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/RecaudoDineroMensual.png");
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
	 * Obtiene la etiqueta del dinero total recaudado.
	 *
	 * @return La etiqueta del dinero total recaudado.
	 */
	public JLabel getLblTotalRecaudado() {
		return lblTotalRecaudado;
	}

	/**
	 * Establece la etiqueta del dinero total recaudado.
	 *
	 * @param lblTotalRecaudado Nueva etiqueta del dinero total recaudado.
	 */
	public void setLblTotalRecaudado(JLabel lblTotalRecaudado) {
		this.lblTotalRecaudado = lblTotalRecaudado;
	}

	/**
	 * Obtiene el área de texto del detalle del recaudo.
	 *
	 * @return El área de texto del detalle del recaudo.
	 */
	public JTextArea getAreaDetalle() {
		return areaDetalle;
	}

	/**
	 * Establece el área de texto del detalle del recaudo.
	 *
	 * @param areaDetalle Nuevo área de texto del detalle del recaudo.
	 */
	public void setAreaDetalle(JTextArea areaDetalle) {
		this.areaDetalle = areaDetalle;
	}

	/**
	 * Obtiene el panel de desplazamiento del detalle del recaudo.
	 *
	 * @return El panel de desplazamiento del detalle del recaudo.
	 */
	public JScrollPane getScrollDetalle() {
		return scrollDetalle;
	}

	/**
	 * Establece el panel de desplazamiento del detalle del recaudo.
	 *
	 * @param scrollDetalle Nuevo panel de desplazamiento del detalle del recaudo.
	 */
	public void setScrollDetalle(JScrollPane scrollDetalle) {
		this.scrollDetalle = scrollDetalle;
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