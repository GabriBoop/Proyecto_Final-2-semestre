package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Component;
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


public class PanelVerFacturas {


private JPanel panel = new JPanel(new GridBagLayout());
private JPanel columna = new JPanel(new BorderLayout(15, 15));
private JPanel superior = new JPanel(new GridLayout(4, 1, 15, 15));
private JLabel txt = new JLabel();

private JLabel lblTotalFacturas = new JLabel("Total de Facturas: 0");
private JTextArea areaFacturas = new JTextArea(10, 35);
private JScrollPane scrollFacturas = new JScrollPane(areaFacturas);

private JButton btnVolver = new JButton("Volver");

public PanelVerFacturas() {
	panel.setBackground(PanelMenu.FONDO);
	columna.setBackground(PanelMenu.FONDO);
	superior.setBackground(PanelMenu.FONDO);
	txt.setText("Facturas del Parqueadero");
	txt.setHorizontalAlignment(SwingConstants.CENTER);
	lblTotalFacturas.setHorizontalAlignment(SwingConstants.CENTER);

	areaFacturas.setEditable(false);
	areaFacturas.setLineWrap(true);
	areaFacturas.setWrapStyleWord(true);
	scrollFacturas.setPreferredSize(new Dimension(550, 220));

	superior.add(txt);
	superior.add(lblTotalFacturas);
	columna.add(superior, BorderLayout.NORTH);
	columna.add(scrollFacturas, BorderLayout.CENTER);
	columna.add(btnVolver, BorderLayout.SOUTH);

	for (Component c : superior.getComponents()) {
		c.setFont(new Font("Arial", Font.PLAIN, 18));
	}
	areaFacturas.setFont(new Font("Arial", Font.PLAIN, 16));
	txt.setFont(new Font("Arial", Font.BOLD, 24));
	btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
	panel.add(columna);
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

public JPanel getSuperior() {
	return superior;
}

public void setSuperior(JPanel superior) {
	this.superior = superior;
}


}

