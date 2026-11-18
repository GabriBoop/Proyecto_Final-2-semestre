package co.edu.unbosque.model;

import java.time.LocalDate;


/**
 * Clase que representa un carro.
 * Hereda los atributos y comportamientos comunes de Vehiculo.
 */
public class Carro extends Vehiculo {
	
	private static final long serialVersionUID = -7975916342477791276L;

	/**
	 * Constructor por defecto de la clase Carro.
	 */
	public Carro() {
		
	}

	/**
	 * Constructor parametrizado para inicializar el vehículo con todos sus datos.
	 *
	 * @param placa Placa del vehículo (formato AAA-123).
	 * @param tipo Tipo de vehículo.
	 * @param propietario Propietario del vehículo.
	 * @param vencimientoSoat Fecha de vencimiento del SOAT.
	 * @throws PlacaInvalidaException si la placa no cumple el formato requerido.
	 */
	public Carro(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat){
		super(placa, tipo, propietario, vencimientoSoat);
	}

	/**
	 * Retorna el tipo específico de este vehículo.
	 *
	 * @return La cadena "CARRO".
	 */
	@Override
	public String getTipo() {
		return "CARRO";
	}

}