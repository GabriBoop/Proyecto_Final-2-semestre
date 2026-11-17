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

public class PanelReportesDineroMensual {

	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblTotalRecaudado = PanelMenu.crearLabel("");
	private JTextArea areaDetalle = new JTextArea();
	private JScrollPane scrollDetalle = new JScrollPane(areaDetalle);

	private JButton btnVolver = new JButton("Volver");

	public PanelReportesDineroMensual() {
		panel.setBackground(PanelMenuReportes.FONDO_REPORTES);
		columna.setBackground(PanelMenuReportes.FONDO_REPORTES);

		lblTotalRecaudado.setHorizontalAlignment(SwingConstants.CENTER);

		areaDetalle.setEditable(false);
		areaDetalle.setLineWrap(true);
		areaDetalle.setWrapStyleWord(true);
		areaDetalle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		scrollDetalle.setPreferredSize(new Dimension(550, 180));

		PanelMenu.crearBoton(btnVolver, Color.BLACK, Color.WHITE);

		columna.add(lblTotalRecaudado, BorderLayout.NORTH);
		columna.add(scrollDetalle, BorderLayout.CENTER);
		columna.add(btnVolver, BorderLayout.SOUTH);

		JLabel imgTitulo = PanelMenu.crearImagen("/co/edu/unbosque/images/RecaudoDineroMensual.png");
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

	public JLabel getLblTotalRecaudado() {
		return lblTotalRecaudado;
	}

	public void setLblTotalRecaudado(JLabel lblTotalRecaudado) {
		this.lblTotalRecaudado = lblTotalRecaudado;
	}

	public JTextArea getAreaDetalle() {
		return areaDetalle;
	}

	public void setAreaDetalle(JTextArea areaDetalle) {
		this.areaDetalle = areaDetalle;
	}

	public JScrollPane getScrollDetalle() {
		return scrollDetalle;
	}

	public void setScrollDetalle(JScrollPane scrollDetalle) {
		this.scrollDetalle = scrollDetalle;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}
