package co.edu.unbosque.model;


import java.io.Serializable;
import java.time.LocalDateTime;

public class FacturaDTO implements Serializable {

	private static final long serialVersionUID = 4821937465012398471L;

	private int num;
	private String placa;
	private String nombrePropietario;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;
	private FormaDeCobro formaDeCobro;
	private double valor;
	
	public FacturaDTO() {
		
	}
	public FacturaDTO(int num, String placa, String nombrePropietario, LocalDateTime horaIngreso, LocalDateTime horaSalida,
			FormaDeCobro formaDeCobro, double valor) {
		super();
		this.num = num;
		this.placa = placa;
		this.nombrePropietario = nombrePropietario;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.formaDeCobro = formaDeCobro;
		this.valor = valor;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public FormaDeCobro getFormaDeCobro() {
		return formaDeCobro;
	}
	public void setFormaDeCobro(FormaDeCobro formaDeCobro) {
		this.formaDeCobro = formaDeCobro;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}