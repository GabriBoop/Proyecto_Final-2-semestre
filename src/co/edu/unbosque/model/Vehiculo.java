package co.edu.unbosque.model;
import java.io.Serializable;
import java.time.LocalDate;

import co.edu.unbosque.util.exceptions.PlacaInvalidaException;

/**
 * Clase abstracta que representa un vehículo que utiliza el parqueadero.
 * Define los atributos comunes (placa, tipo, propietario y vencimiento del SOAT)
 * y la validación del formato de placa para todos los tipos de vehículo (Carro, Moto).
 * Implementa Serializable para poder almacenarse en archivos.
 */
public abstract class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1739452775398256614L;
	private static final String PLACA_FORMATO = "[A-Z]{3}-\\d{3}";
	
	private String placa;
	private String tipo;
	private Propietario propietario;
	private LocalDate  vencimientoSoat;
	
	/**
	 * Constructor por defecto de la clase Vehiculo.
	 */
	public Vehiculo() {
		
	}
	
	/**
	 * Constructor parametrizado para inicializar un vehículo con todos sus datos.
	 * La placa se valida y normaliza antes de ser asignada.
	 *
	 * @param placa Placa del vehículo (formato AAA-123).
	 * @param tipo Tipo de vehículo (CARRO o MOTO).
	 * @param propietario Propietario del vehículo.
	 * @param vencimientoSoat Fecha de vencimiento del SOAT.
	 * @throws PlacaInvalidaException si la placa no cumple el formato requerido.
	 */
	public Vehiculo(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		setPlaca(placa);
		this.tipo = tipo;
		this.propietario = propietario;
		this.vencimientoSoat = vencimientoSoat;
	}
	
	/**
	 * Valida y normaliza una placa. Elimina espacios, la convierte a mayúsculas
	 * y verifica que cumpla el formato de tres letras, guion y tres dígitos (AAA-123).
	 *
	 * @param placa Placa a validar.
	 * @return Placa normalizada en mayúsculas y sin espacios.
	 * @throws PlacaInvalidaException si la placa es nula o no cumple el formato.
	 */
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
	
	/**
	 * Obtiene la placa del vehículo.
	 *
	 * @return Placa del vehículo.
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * Establece la placa del vehículo, validándola previamente.
	 *
	 * @param placa Nueva placa del vehículo (formato AAA-123).
	 * @throws PlacaInvalidaException si la placa no cumple el formato requerido.
	 */
	public void setPlaca(String placa) throws PlacaInvalidaException {
		this.placa = validarPlaca(placa);
	}
	/**
	 * Método abstracto que deben implementar las clases hijas para retornar
	 * el tipo específico de vehículo.
	 *
	 * @return Cadena de texto con el tipo de vehículo (CARRO o MOTO).
	 */
	public abstract String getTipo();
	
	/**
	 * Establece el tipo de vehículo.
	 *
	 * @param tipo Nuevo tipo de vehículo.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Obtiene el propietario.
	 *
	 * @return Propietario asociado.
	 */
	public Propietario getPropietario() {
		return propietario;
	}
	/**
	 * Establece el propietario.
	 *
	 * @param propietario Nuevo propietario.
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	/**
	 * Obtiene la fecha de vencimiento del SOAT.
	 *
	 * @return Fecha de vencimiento del SOAT.
	 */
	public LocalDate getVencimientoSoat() {
		return vencimientoSoat;
	}
	/**
	 * Establece la fecha de vencimiento del SOAT.
	 *
	 * @param vencimientoSoat Nueva fecha de vencimiento del SOAT.
	 */
	public void setVencimientoSoat(LocalDate vencimientoSoat) {
		this.vencimientoSoat = vencimientoSoat;
	}
}