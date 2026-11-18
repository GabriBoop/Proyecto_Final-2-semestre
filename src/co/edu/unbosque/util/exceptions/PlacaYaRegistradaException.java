package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar una placa de
 * vehículo que ya se encuentra almacenada previamente en el sistema de
 * parqueadero.
 */
public class PlacaYaRegistradaException extends Exception {

	/**
	 * Constructor por defecto de PlacaYaRegistradaException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que la placa ya está
	 * registrada.
	 */
	public PlacaYaRegistradaException() {
		super("[ERROR] La Placa ya esta Registrada");
	}

}