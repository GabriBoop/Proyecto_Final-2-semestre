package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando una placa de vehículo consultada
 * o buscada no se encuentra registrada en el sistema de parqueadero.
 */
public class PlacaNoEncontradaException extends Exception {

	/**
	 * Constructor de PlacaNoEncontradaException. Inicializa la excepción con un
	 * mensaje de error detallado que incluye la placa que no pudo ser localizada.
	 *
	 * @param placa Cadena de texto correspondiente a la placa del vehículo no encontrado.
	 */
	public PlacaNoEncontradaException(String placa) {
		super("[ERROR] La Placa no fue encontrada: " + placa);
	}

}
