package co.edu.unbosque.util.exceptions;

/**
 * Excepción no comprobada (RuntimeException) que se lanza cuando la placa de
 * un vehículo ingresada en el sistema no cumple con el formato válido
 * establecido (AAA-###).
 */
public class PlacaInvalidaException extends RuntimeException {

	/**
	 * Constructor por defecto de PlacaInvalidaException. Inicializa la excepción
	 * con un mensaje de error predeterminado indicando el formato correcto
	 * esperado para la placa.
	 */
	public PlacaInvalidaException() {
		super("[ERROR] La Placa puesta no cuenta con el formato correcto. (AAA-###)");
	}

}
