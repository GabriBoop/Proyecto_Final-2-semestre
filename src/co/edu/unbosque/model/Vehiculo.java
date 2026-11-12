package co.edu.unbosque.model;
import java.io.Serializable;
import java.time.LocalDate;

import co.edu.unbosque.util.exceptions.PlacaInvalidaException;

public abstract class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1739452775398256614L;
	private static final String PLACA_FORMATO = "[A-Z]{3}-\\d{3}";
	
	private String placa;
	private String tipo;
	private Propietario propietario;
	private LocalDate  vencimientoSoat;
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		setPlaca(placa);
		this.tipo = tipo;
		this.propietario = propietario;
		this.vencimientoSoat = vencimientoSoat;
	}
	
	public static String validarPlaca(String placa){
		if (placa == null) {
			throw new PlacaInvalidaException();
		}
		placa = placa.trim().toUpperCase();
		if (!placa.matches(PLACA_FORMATO)) {
			throw new PlacaInvalidaException();
		}
		return placa;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) throws PlacaInvalidaException {
		this.placa = validarPlaca(placa);
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
