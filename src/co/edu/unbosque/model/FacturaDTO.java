package co.edu.unbosque.model;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase que representa la factura generada al salir un vehículo del parqueadero como objeto de transferencia de datos (DTO).
 * Guarda la placa, el propietario, las horas de ingreso y salida, la forma de cobro y el valor total.
 * Implementa Serializable para poder almacenarse en archivos.
 */
public class FacturaDTO implements Serializable {

	private static final long serialVersionUID = 4821937465012398471L;

	private int num;
	private String placa;
	private String nombrePropietario;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;
	private FormaDeCobro formaDeCobro;
	private double valor;
	
	/**
	 * Constructor por defecto de la clase FacturaDTO.
	 */
	public FacturaDTO() {
		
	}
	/**
	 * Constructor parametrizado para inicializar una factura con todos sus datos.
	 *
	 * @param num Número consecutivo de la factura.
	 * @param placa Placa del vehículo facturado.
	 * @param nombrePropietario Nombre del propietario del vehículo.
	 * @param horaIngreso Fecha y hora de ingreso al parqueadero.
	 * @param horaSalida Fecha y hora de salida del parqueadero.
	 * @param formaDeCobro Forma de cobro aplicada (MENSUAL, HORA o FIJA).
	 * @param valor Valor total cobrado en pesos.
	 */
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
	
	/**
	 * Obtiene el número de la factura.
	 *
	 * @return Número consecutivo de la factura.
	 */
	public int getNum() {
		return num;
	}
	/**
	 * Establece el número de la factura.
	 *
	 * @param num Nuevo número de factura.
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * Obtiene la placa del vehículo.
	 *
	 * @return Placa del vehículo.
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * Establece la placa del vehículo.
	 *
	 * @param placa Nueva placa del vehículo.
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * Obtiene el nombre del propietario del vehículo facturado.
	 *
	 * @return Nombre del propietario.
	 */
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	/**
	 * Establece el nombre del propietario del vehículo facturado.
	 *
	 * @param nombrePropietario Nuevo nombre del propietario.
	 */
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
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
	 * Obtiene la forma de cobro aplicada.
	 *
	 * @return Forma de cobro (MENSUAL, HORA o FIJA).
	 */
	public FormaDeCobro getFormaDeCobro() {
		return formaDeCobro;
	}
	/**
	 * Establece la forma de cobro aplicada.
	 *
	 * @param formaDeCobro Nueva forma de cobro.
	 */
	public void setFormaDeCobro(FormaDeCobro formaDeCobro) {
		this.formaDeCobro = formaDeCobro;
	}
	/**
	 * Obtiene el valor total cobrado.
	 *
	 * @return Valor total de la factura en pesos.
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * Establece el valor total cobrado.
	 *
	 * @param valor Nuevo valor total de la factura.
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}