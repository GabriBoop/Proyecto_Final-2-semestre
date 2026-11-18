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

public class PanelVerFacturas {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalFacturas = PanelMenu.crearLabel("Total de Facturas: 0");
	private JTextArea areaFacturas = new JTextArea(10, 35);
	private JScrollPane scrollFacturas = new JScrollPane(areaFacturas);

	private JButton btnVolver = new JButton("Volver");

	public PanelVerFacturas() {
		panel.setBackground(PanelMenuConsulta.FONDO_CONSULTA);
		columna.setBackground(PanelMenuConsulta.FONDO_CONSULTA);

		lblTotalFacturas.setHorizontalAlignment(SwingConstants.CENTER);

		areaFacturas.setEditable(false);
		areaFacturas.setLineWrap(true);
		areaFacturas.setWrapStyleWord(true);
		areaFacturas.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		scrollFacturas.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalFacturas, BorderLayout.NORTH);
		columna.add(scrollFacturas, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/VerFacturas.png");
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

public JLabel getLblTotalFacturas() {
	return lblTotalFacturas;
}

public void setLblTotalFacturas(JLabel lblTotalFacturas) {
	this.lblTotalFacturas = lblTotalFacturas;
}

public JTextArea getAreaFacturas() {
	return areaFacturas;
}

public void setAreaFacturas(JTextArea areaFacturas) {
	this.areaFacturas = areaFacturas;
}

public JScrollPane getScrollFacturas() {
	return scrollFacturas;
}

public void setScrollFacturas(JScrollPane scrollFacturas) {
	this.scrollFacturas = scrollFacturas;
}

public JButton getBtnVolver() {
	return btnVolver;
}

public void setBtnVolver(JButton btnVolver) {
	this.btnVolver = btnVolver;
}

}

