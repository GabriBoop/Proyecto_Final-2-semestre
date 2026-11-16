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

	public PanelMensualidadesVacantes() {
		panel.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		columna.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		superior.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);

		lblVacantesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuposOcupados.setHorizontalAlignment(SwingConstants.CENTER);

		areaVacantes.setEditable(false);
		areaVacantes.setLineWrap(true);
		areaVacantes.setWrapStyleWord(true);
		areaVacantes.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
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

	public JLabel getLblVacantesDisponibles() {
		return lblVacantesDisponibles;
	}

	public void setLblVacantesDisponibles(JLabel lblVacantesDisponibles) {
		this.lblVacantesDisponibles = lblVacantesDisponibles;
	}

	public JLabel getLblCuposOcupados() {
		return lblCuposOcupados;
	}

	public void setLblCuposOcupados(JLabel lblCuposOcupados) {
		this.lblCuposOcupados = lblCuposOcupados;
	}

	public JTextArea getAreaVacantes() {
		return areaVacantes;
	}

	public void setAreaVacantes(JTextArea areaVacantes) {
		this.areaVacantes = areaVacantes;
	}

	public JScrollPane getScrollVacantes() {
		return scrollVacantes;
	}

	public void setScrollVacantes(JScrollPane scrollVacantes) {
		this.scrollVacantes = scrollVacantes;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JPanel getSuperior() {
		return superior;
	}

	public void setSuperior(JPanel superior) {
		this.superior = superior;
	}
	
}
