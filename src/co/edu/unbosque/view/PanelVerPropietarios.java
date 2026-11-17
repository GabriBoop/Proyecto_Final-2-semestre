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

public class PanelVerPropietarios {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalPropietarios = PanelMenu.crearLabel("Total de Propietarios: 0");
	private JTextArea areaPropietarios = new JTextArea(10, 35);
	private JScrollPane scrollPropietarios = new JScrollPane(areaPropietarios);

	private JButton btnVolver = new JButton("Volver");

	public PanelVerPropietarios() {
		panel.setBackground(PanelMenuPropietario.FONDO_PROPIETARIO);
		columna.setBackground(PanelMenuPropietario.FONDO_PROPIETARIO);

		lblTotalPropietarios.setHorizontalAlignment(SwingConstants.CENTER);

		areaPropietarios.setEditable(false);
		areaPropietarios.setLineWrap(true);
		areaPropietarios.setWrapStyleWord(true);
		areaPropietarios.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		scrollPropietarios.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalPropietarios, BorderLayout.NORTH);
		columna.add(scrollPropietarios, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerPropietarios.png");
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

	public JLabel getLblTotalPropietarios() {
		return lblTotalPropietarios;
	}

	public void setLblTotalPropietarios(JLabel lblTotalPropietarios) {
		this.lblTotalPropietarios = lblTotalPropietarios;
	}

	public JTextArea getAreaPropietarios() {
		return areaPropietarios;
	}

	public void setAreaPropietarios(JTextArea areaPropietarios) {
		this.areaPropietarios = areaPropietarios;
	}

	public JScrollPane getScrollPropietarios() {
		return scrollPropietarios;
	}

	public void setScrollPropietarios(JScrollPane scrollPropietarios) {
		this.scrollPropietarios = scrollPropietarios;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}