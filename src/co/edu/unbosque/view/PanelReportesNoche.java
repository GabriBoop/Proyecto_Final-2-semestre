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

public class PanelReportesNoche {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JPanel superior = new JPanel(new GridLayout(2, 1, 10, 10));
	private JLabel txt = new JLabel();

	private JLabel lblResumen = new JLabel("");
	private JTextArea areaReporte = new JTextArea();
	private JScrollPane scrollReporte = new JScrollPane(areaReporte);
	
	private JButton btnVolver = new JButton("Volver");
	
	public PanelReportesNoche() {
		txt.setText("Vehículos que Pasaron la Noche");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumen.setHorizontalAlignment(SwingConstants.CENTER);

		areaReporte.setEditable(false);
		areaReporte.setLineWrap(true);
		areaReporte.setWrapStyleWord(true);
		scrollReporte.setPreferredSize(new Dimension(550, 220));

		superior.add(txt);
		superior.add(lblResumen);

		columna.add(superior, BorderLayout.NORTH);
		columna.add(scrollReporte, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		for (Component c : superior.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		txt.setFont(new Font("Arial", Font.BOLD, 24));
		areaReporte.setFont(new Font("Arial", Font.PLAIN, 16));
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

	public JPanel getSuperior() {
		return superior;
	}

	public void setSuperior(JPanel superior) {
		this.superior = superior;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public JLabel getLblResumen() {
		return lblResumen;
	}

	public void setLblResumen(JLabel lblResumen) {
		this.lblResumen = lblResumen;
	}

	public JTextArea getAreaReporte() {
		return areaReporte;
	}

	public void setAreaReporte(JTextArea areaReporte) {
		this.areaReporte = areaReporte;
	}

	public JScrollPane getScrollReporte() {
		return scrollReporte;
	}

	public void setScrollReporte(JScrollPane scrollReporte) {
		this.scrollReporte = scrollReporte;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}
