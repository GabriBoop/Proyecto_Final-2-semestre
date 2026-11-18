package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Vista que muestra los cupos de mensualidad disponibles y ocupados, junto con el detalle de las vacantes.
 * Los eventos de los botones se asignan desde el controlador.
 */
public class PanelMensualidadesVacantes {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JPanel superior = new JPanel(new GridLayout(2, 1, 15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblVacantesDisponibles = PanelMenu.crearLabel("Vacantes disponibles: 0 / 0");
	private JLabel lblCuposOcupados = PanelMenu.crearLabel("Cupos ocupados: 0");
	private JTextArea areaVacantes = new JTextArea(8, 35);
	private JScrollPane scrollVacantes = new JScrollPane(areaVacantes);

	private JButton btnVolver = new JButton("Volver");

	/**
	 * Configura las etiquetas de resumen, el área de texto de solo lectura con desplazamiento y el botón, y los organiza bajo la imagen de título.
	 */
	public PanelMensualidadesVacantes() {
		panel.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		columna.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		superior.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);

		lblVacantesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuposOcupados.setHorizontalAlignment(SwingConstants.CENTER);

		areaVacantes.setEditable(false);
		areaVacantes.setLineWrap(true);
		areaVacantes.setWrapStyleWord(true);
		areaVacantes.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollVacantes.setPreferredSize(new Dimension(550, 180));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		superior.add(lblVacantesDisponibles);
		superior.add(lblCuposOcupados);
		columna.add(superior, BorderLayout.NORTH);
		columna.add(scrollVacantes, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VacantesMensualidades.png");
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
	 * Obtiene la etiqueta de las vacantes disponibles.
	 *
	 * @return La etiqueta de las vacantes disponibles.
	 */
	public JLabel getLblVacantesDisponibles() {
		return lblVacantesDisponibles;
	}

	/**
	 * Establece la etiqueta de las vacantes disponibles.
	 *
	 * @param lblVacantesDisponibles Nueva etiqueta de las vacantes disponibles.
	 */
	public void setLblVacantesDisponibles(JLabel lblVacantesDisponibles) {
		this.lblVacantesDisponibles = lblVacantesDisponibles;
	}

	/**
	 * Obtiene la etiqueta de los cupos ocupados.
	 *
	 * @return La etiqueta de los cupos ocupados.
	 */
	public JLabel getLblCuposOcupados() {
		return lblCuposOcupados;
	}

	/**
	 * Establece la etiqueta de los cupos ocupados.
	 *
	 * @param lblCuposOcupados Nueva etiqueta de los cupos ocupados.
	 */
	public void setLblCuposOcupados(JLabel lblCuposOcupados) {
		this.lblCuposOcupados = lblCuposOcupados;
	}

	/**
	 * Obtiene el área de texto de las vacantes.
	 *
	 * @return El área de texto de las vacantes.
	 */
	public JTextArea getAreaVacantes() {
		return areaVacantes;
	}

	/**
	 * Establece el área de texto de las vacantes.
	 *
	 * @param areaVacantes Nuevo área de texto de las vacantes.
	 */
	public void setAreaVacantes(JTextArea areaVacantes) {
		this.areaVacantes = areaVacantes;
	}

	/**
	 * Obtiene el panel de desplazamiento de las vacantes.
	 *
	 * @return El panel de desplazamiento de las vacantes.
	 */
	public JScrollPane getScrollVacantes() {
		return scrollVacantes;
	}

	/**
	 * Establece el panel de desplazamiento de las vacantes.
	 *
	 * @param scrollVacantes Nuevo panel de desplazamiento de las vacantes.
	 */
	public void setScrollVacantes(JScrollPane scrollVacantes) {
		this.scrollVacantes = scrollVacantes;
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

	/**
	 * Obtiene el panel superior con las etiquetas de resumen.
	 *
	 * @return El panel superior con las etiquetas de resumen.
	 */
	public JPanel getSuperior() {
		return superior;
	}

	/**
	 * Establece el panel superior con las etiquetas de resumen.
	 *
	 * @param superior Nuevo panel superior con las etiquetas de resumen.
	 */
	public void setSuperior(JPanel superior) {
		this.superior = superior;
	}
	
}