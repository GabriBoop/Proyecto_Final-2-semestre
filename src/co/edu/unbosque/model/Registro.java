package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Registro implements Serializable{
	
	private static final long serialVersionUID = 5539847879740762618L;
	private Vehiculo vehiculo;
	private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;
    private boolean pagaMensualidad;
    private Tarifa tarifaAplicada;
	
    public Registro(Vehiculo vehiculo, LocalDateTime horaIngreso, LocalDateTime horaSalida, boolean pagaMensualidad,
			Tarifa tarifaAplicada) {
		super();
		this.vehiculo = vehiculo;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
		this.pagaMensualidad = pagaMensualidad;
		this.tarifaAplicada = tarifaAplicada;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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

	public boolean isPagaMensualidad() {
		return pagaMensualidad;
	}

	public void setPagaMensualidad(boolean pagaMensualidad) {
		this.pagaMensualidad = pagaMensualidad;
	}

	public Tarifa getTarifaAplicada() {
		return tarifaAplicada;
	}

	public void setTarifaAplicada(Tarifa tarifaAplicada) {
		this.tarifaAplicada = tarifaAplicada;
	}
    
}
