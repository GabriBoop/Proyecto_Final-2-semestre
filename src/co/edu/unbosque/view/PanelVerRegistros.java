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


public class PanelVerRegistros {
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JPanel superior = new JPanel(new GridLayout(4, 1, 15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalRegistros = new JLabel("Total de Registros: 0");
	private JTextArea areaRegistros = new JTextArea(10, 35);
	private JScrollPane scrollRegistros = new JScrollPane(areaRegistros);

	private JButton btnVolver = new JButton("Volver");
	
	public PanelVerRegistros() {
		panel.setBackground(PanelMenu.FONDO);
		columna.setBackground(PanelMenu.FONDO);
		superior.setBackground(PanelMenu.FONDO);
		txt.setText("Registros del Parqueadero");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalRegistros.setHorizontalAlignment(SwingConstants.CENTER);

		areaRegistros.setEditable(false);
		areaRegistros.setLineWrap(true);
		areaRegistros.setWrapStyleWord(true);
		scrollRegistros.setPreferredSize(new Dimension(550, 220));

		superior.add(txt);
		superior.add(lblTotalRegistros);
		columna.add(superior, BorderLayout.NORTH);
		columna.add(scrollRegistros, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		for (Component c : superior.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		areaRegistros.setFont(new Font("Arial", Font.PLAIN, 16));
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

	public JLabel getLblTotalRegistros() {
		return lblTotalRegistros;
	}

	public void setLblTotalRegistros(JLabel lblTotalRegistros) {
		this.lblTotalRegistros = lblTotalRegistros;
	}

	public JTextArea getAreaRegistros() {
		return areaRegistros;
	}

	public void setAreaRegistros(JTextArea areaRegistros) {
		this.areaRegistros = areaRegistros;
	}

	public JScrollPane getScrollRegistros() {
		return scrollRegistros;
	}

	public void setScrollRegistros(JScrollPane scrollRegistros) {
		this.scrollRegistros = scrollRegistros;
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

