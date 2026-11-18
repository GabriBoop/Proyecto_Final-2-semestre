package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando el número de teléfono ingresado
 * no cumple con el formato requerido por el sistema (solo caracteres numéricos
 * y longitud exacta de 10 dígitos).
 */
public class TelefonoInvalidoException extends Exception {

	/**
	 * Constructor por defecto de TelefonoInvalidoException. Inicializa la
	 * excepción con un mensaje de error que especifica el formato válido y
	 * presenta ejemplos de referencia.
	 */
	public TelefonoInvalidoException() {
		super("[ERROR] El Telefono no cumple con el formato. (Solo Numeros y deben ser 10 Caracteres)"
				+ "\n\tEjemplo: 3102578892, 3114858111,  3044411689.");
	}

}
