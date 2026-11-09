package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RegistroDTO implements Serializable{

	private static final long serialVersionUID = 1699718911461202595L;
	private Vehiculo vehiculo;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;
    private boolean pagaMensualidad;
    private Tarifa tarifaAplicada;
    private boolean activo = true;
    
    public RegistroDTO() {
    	
    }
	
    public RegistroDTO(Vehiculo vehiculo, LocalDateTime horaIngreso, boolean pagaMensualidad,
			Tarifa tarifaAplicada) {
		super();
		this.vehiculo = vehiculo;
		this.horaIngreso = horaIngreso;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}