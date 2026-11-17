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

public class PanelReportes24h {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotal = PanelMenu.crearLabel("");
	private JTextArea areaReporte = new JTextArea();
	private JScrollPane scrollReporte = new JScrollPane(areaReporte);

	private JButton btnVolver = new JButton("Volver");

	public PanelReportes24h() {
		panel.setBackground(PanelMenuReportes.FONDO_REPORTES);
		columna.setBackground(PanelMenuReportes.FONDO_REPORTES);

		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);

		areaReporte.setEditable(false);
		areaReporte.setLineWrap(true);
		areaReporte.setWrapStyleWord(true);
		areaReporte.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		scrollReporte.setPreferredSize(new Dimension(550, 220));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotal, BorderLayout.NORTH);
		columna.add(scrollReporte, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/Vehiculos24H.png");
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

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
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
