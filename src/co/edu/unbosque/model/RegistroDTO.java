package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase que representa el registro de permanencia de un vehículo en el parqueadero como objeto de transferencia de datos (DTO).
 * Almacena el vehículo, sus horas de ingreso y salida, si paga mensualidad,
 * la tarifa aplicada y si el registro continúa activo.
 * Implementa Serializable para poder almacenarse en archivos.
 */
public class RegistroDTO implements Serializable{

	private static final long serialVersionUID = 1699718911461202595L;
	private Vehiculo vehiculo;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;
    private boolean pagaMensualidad;
    private Tarifa tarifaAplicada;
    private boolean activo = true;
    
    /**
     * Constructor por defecto de la clase RegistroDTO.
     */
    public RegistroDTO() {
    	
    }
	
    /**
     * Constructor parametrizado para inicializar un registro al ingresar un vehículo.
     * El registro se crea activo y sin hora de salida.
     *
     * @param vehiculo Vehículo que ingresa al parqueadero.
     * @param horaIngreso Fecha y hora de ingreso.
     * @param pagaMensualidad true si el vehículo tiene mensualidad vigente.
     * @param tarifaAplicada Tarifa que se aplicará al cobrar (null si paga mensualidad).
     */
    public RegistroDTO(Vehiculo vehiculo, LocalDateTime horaIngreso, boolean pagaMensualidad,
			Tarifa tarifaAplicada) {
		super();
		this.vehiculo = vehiculo;
		this.horaIngreso = horaIngreso;
		this.pagaMensualidad = pagaMensualidad;
		this.tarifaAplicada = tarifaAplicada;
	}

	/**
	 * Obtiene el vehículo del registro.
	 *
	 * @return Vehículo asociado al registro.
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	/**
	 * Establece el vehículo del registro.
	 *
	 * @param vehiculo Nuevo vehículo del registro.
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * Obtiene la fecha y hora de ingreso al parqueadero.
	 *
	 * @return Fecha y hora de ingreso.
	 */
	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	/**
	 * Establece la fecha y hora de ingreso al parqueadero.
	 *
	 * @param horaIngreso Nueva fecha y hora de ingreso.
	 */
	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	/**
	 * Obtiene la fecha y hora de salida del parqueadero.
	 *
	 * @return Fecha y hora de salida (puede ser null si el vehículo sigue dentro).
	 */
	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	/**
	 * Establece la fecha y hora de salida del parqueadero.
	 *
	 * @param horaSalida Nueva fecha y hora de salida.
	 */
	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	/**
	 * Indica si el vehículo paga mensualidad.
	 *
	 * @return true si el vehículo tiene mensualidad vigente, false en caso contrario.
	 */
	public boolean isPagaMensualidad() {
		return pagaMensualidad;
	}

	/**
	 * Establece si el vehículo paga mensualidad.
	 *
	 * @param pagaMensualidad true si el vehículo paga mensualidad.
	 */
	public void setPagaMensualidad(boolean pagaMensualidad) {
		this.pagaMensualidad = pagaMensualidad;
	}

	/**
	 * Obtiene la tarifa aplicada al registro.
	 *
	 * @return Tarifa aplicada (null si paga mensualidad).
	 */
	public Tarifa getTarifaAplicada() {
		return tarifaAplicada;
	}

	/**
	 * Establece la tarifa aplicada al registro.
	 *
	 * @param tarifaAplicada Nueva tarifa a aplicar.
	 */
	public void setTarifaAplicada(Tarifa tarifaAplicada) {
		this.tarifaAplicada = tarifaAplicada;
	}

	/**
	 * Indica el estado de actividad del registro.
	 *
	 * @return true si el vehículo sigue dentro del parqueadero.
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Establece el estado de actividad del registro.
	 *
	 * @param activo true si el registro está activo.
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
