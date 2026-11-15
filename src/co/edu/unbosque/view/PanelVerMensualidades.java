package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PanelVerMensualidades {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(4, 1, 15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalMensualidades = new JLabel("Mensualidades activas: 0");
	private JTextArea areaMensualidades = new JTextArea(10, 35);
	private JScrollPane scrollMensualidades = new JScrollPane(areaMensualidades);

	private JButton btnVolver = new JButton("Volver");
	
	public PanelVerMensualidades() {
		txt.setText("Mensualidades Registradas");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalMensualidades.setHorizontalAlignment(SwingConstants.CENTER);

		areaMensualidades.setEditable(false);

		columna.add(txt);
		columna.add(lblTotalMensualidades);
		columna.add(scrollMensualidades);
		columna.add(btnVolver);

		for (Component c : columna.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		areaMensualidades.setFont(new Font("Arial", Font.PLAIN, 16));
		txt.setFont(new Font("Arial", Font.BOLD, 24));
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
