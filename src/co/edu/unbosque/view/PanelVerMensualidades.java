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

public class PanelVerMensualidades {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));

	private JLabel lblTotalMensualidades = PanelMenu.crearLabel("Mensualidades activas: 0");
	private JTextArea areaMensualidades = new JTextArea(12, 45);
	private JScrollPane scrollMensualidades = new JScrollPane(areaMensualidades);

	private JButton btnVolver = new JButton("Volver");

	public PanelVerMensualidades() {
		panel.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);
		columna.setBackground(PanelMenuMensualidades.FONDO_MENSUALIDADES);

		lblTotalMensualidades.setHorizontalAlignment(SwingConstants.CENTER);

		areaMensualidades.setEditable(false);
		areaMensualidades.setLineWrap(true);
		areaMensualidades.setWrapStyleWord(true);
		areaMensualidades.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollMensualidades.setPreferredSize(new Dimension(700, 280));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalMensualidades, BorderLayout.NORTH);
		columna.add(scrollMensualidades, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerMensualidades.png");
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

	public JLabel getLblTotalMensualidades() {
		return lblTotalMensualidades;
	}

	public void setLblTotalMensualidades(JLabel lblTotalMensualidades) {
		this.lblTotalMensualidades = lblTotalMensualidades;
	}

	public JTextArea getAreaMensualidades() {
		return areaMensualidades;
	}

	public void setAreaMensualidades(JTextArea areaMensualidades) {
		this.areaMensualidades = areaMensualidades;
	}

	public JScrollPane getScrollMensualidades() {
		return scrollMensualidades;
	}

	public void setScrollMensualidades(JScrollPane scrollMensualidades) {
		this.scrollMensualidades = scrollMensualidades;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	
}
