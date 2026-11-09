package co.edu.unbosque.model;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1739452775398256614L;
	private String placa;
	private String tipo;
	private Propietario propietario;
	private LocalDate  vencimientoSoat;
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		this.placa = placa.toUpperCase();
		this.tipo = tipo;
		this.propietario = propietario;
		this.vencimientoSoat = vencimientoSoat;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public abstract String getTipo();
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public LocalDate getVencimientoSoat() {
		return vencimientoSoat;
	}
	public void setVencimientoSoat(LocalDate vencimientoSoat) {
		this.vencimientoSoat = vencimientoSoat;
	}
}
