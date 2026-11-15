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

public class PanelMensualidadesVacantes {
	
	private JPanel panel = new JPanel(new GridBagLayout());
	private JPanel columna = new JPanel(new GridLayout(5, 1, 15, 15));
	private JLabel txt = new JLabel();

	private JLabel lblVacantesDisponibles = new JLabel("Vacantes disponibles: 0 / 0");
	private JLabel lblCuposOcupados = new JLabel("Cupos ocupados: 0");
	private JTextArea areaVacantes = new JTextArea(8, 35);
	private JScrollPane scrollVacantes = new JScrollPane(areaVacantes);

	private JButton btnVolver = new JButton("Volver");
	
	public PanelMensualidadesVacantes() {
		txt.setText("Vacantes de Mensualidades");
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		lblVacantesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuposOcupados.setHorizontalAlignment(SwingConstants.CENTER);

		areaVacantes.setEditable(false);

		columna.add(txt);
		columna.add(lblVacantesDisponibles);
		columna.add(lblCuposOcupados);
		columna.add(scrollVacantes);
		columna.add(btnVolver);

		for (Component c : columna.getComponents()) {
			c.setFont(new Font("Arial", Font.PLAIN, 18));
		}
		areaVacantes.setFont(new Font("Arial", Font.PLAIN, 16));
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

	public JLabel getLblVacantesDisponibles() {
		return lblVacantesDisponibles;
	}

	public void setLblVacantesDisponibles(JLabel lblVacantesDisponibles) {
		this.lblVacantesDisponibles = lblVacantesDisponibles;
	}

	public JLabel getLblCuposOcupados() {
		return lblCuposOcupados;
	}

	public void setLblCuposOcupados(JLabel lblCuposOcupados) {
		this.lblCuposOcupados = lblCuposOcupados;
	}

	public JTextArea getAreaVacantes() {
		return areaVacantes;
	}

	public void setAreaVacantes(JTextArea areaVacantes) {
		this.areaVacantes = areaVacantes;
	}

	public JScrollPane getScrollVacantes() {
		return scrollVacantes;
	}

	public void setScrollVacantes(JScrollPane scrollVacantes) {
		this.scrollVacantes = scrollVacantes;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	
}
