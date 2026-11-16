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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelReportesDineroMensual {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new BorderLayout(15, 15));
	private JPanel superior = new JPanel(new GridLayout(3, 2, 15, 15));
	private JPanel inferior = new JPanel(new GridLayout(1, 2, 15, 15));
	private JLabel txt = new JLabel();
	
	private JTextField txtfieldMes = new JTextField();
	private JLabel lblTotalRecaudado = new JLabel("");
	private JTextArea areaDetalle = new JTextArea();
	private JScrollPane scrollDetalle = new JScrollPane(areaDetalle);
	
	private JButton btnConsultar = new JButton("Consultar");
	private JButton btnVolver = new JButton("Volver");
	
	public PanelReportesDineroMensual() {
		txt.setText("Recaudacion Mensual");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		
		areaDetalle.setEditable(false);
		areaDetalle.setLineWrap(true);
		areaDetalle.setWrapStyleWord(true);
		scrollDetalle.setPreferredSize(new Dimension(550, 180));

		superior.add(txt);
		superior.add(new JLabel());
		superior.add(new JLabel("Mes y ano (AAAA-MM):"));
		superior.add(txtfieldMes);
		superior.add(new JLabel("Total recaudado:"));
		superior.add(lblTotalRecaudado);

		inferior.add(btnConsultar);
		inferior.add(btnVolver);

		columna.add(superior, BorderLayout.NORTH);
		columna.add(scrollDetalle, BorderLayout.CENTER);
		columna.add(inferior, BorderLayout.SOUTH);
		
		for (Component c : superior.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		
		for (Component c : inferior.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		txt.setFont(new Font("Arial", Font.BOLD, 24));
		areaDetalle.setFont(new Font("Arial", Font.PLAIN, 16));

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

	public JPanel getInferior() {
		return inferior;
	}

	public void setInferior(JPanel inferior) {
		this.inferior = inferior;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public JTextField getTxtfieldMes() {
		return txtfieldMes;
	}

	public void setTxtfieldMes(JTextField txtfieldMes) {
		this.txtfieldMes = txtfieldMes;
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

	public JButton getBtnConsultar() {
		return btnConsultar;
	}

	public void setBtnConsultar(JButton btnConsultar) {
		this.btnConsultar = btnConsultar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}
