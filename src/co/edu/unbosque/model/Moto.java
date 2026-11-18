package co.edu.unbosque.model;

import java.time.LocalDate;
/**
 * Clase que representa una moto.
 * Hereda los atributos y comportamientos comunes de Vehiculo.
 */
public class Moto extends Vehiculo{
	
	private static final long serialVersionUID = 9083767406550040881L;

	/**
	 * Constructor por defecto de la clase Moto.
	 */
	public Moto(){
		
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
	public Moto(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		super(placa, tipo, propietario, vencimientoSoat);
	}

	/**
	 * Retorna el tipo específico de este vehículo.
	 *
	 * @return La cadena "MOTO".
	 */
	@Override
	public String getTipo() {
		return "MOTO";
	}
	

}