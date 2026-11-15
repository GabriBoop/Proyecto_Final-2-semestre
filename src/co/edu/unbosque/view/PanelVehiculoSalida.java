package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelVehiculoSalida {
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(3, 2, 15, 15));
	private JLabel txt = new JLabel();

	private JTextField txtfieldPlaca = new JTextField();

	private JButton btnRegistrarSalida = new JButton("Registrar Salida");
	private JButton btnVolver = new JButton("Volver");
	
	public PanelVehiculoSalida() {
		txt.setText("Salida del Vehiculo");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		
		columna.add(txt);
		columna.add(new JLabel());
		columna.add(new JLabel("Placa (AAA-###): "));
		columna.add(txtfieldPlaca);
		columna.add(btnRegistrarSalida);
		columna.add(btnVolver);
		
		for (Component c : columna.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
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

	public JTextField getTxtfieldPlaca() {
		return txtfieldPlaca;
	}

	public void setTxtfieldPlaca(JTextField txtfieldPlaca) {
		this.txtfieldPlaca = txtfieldPlaca;
	}

	public JButton getBtnRegistrarSalida() {
		return btnRegistrarSalida;
	}

	public void setBtnRegistrarSalida(JButton btnRegistrarSalida) {
		this.btnRegistrarSalida = btnRegistrarSalida;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}

