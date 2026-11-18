package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando el número de documento de
 * identidad ingresado no cumple con el formato requerido por el sistema (solo
 * caracteres numéricos y longitud exacta de 10 dígitos).
 */
public class DocumentoInvalidoException extends Exception {

	/**
	 * Constructor por defecto de DocumentoInvalidoException. Inicializa la
	 * excepción con un mensaje de error que especifica el formato válido y
	 * presenta ejemplos de referencia.
	 */
	public DocumentoInvalidoException() {
		super("[ERROR] El Documento no cumple con el formato. (Solo Numeros y deben ser 10 Caracteres)"
				+ "\n\tEjemplo: 1234567890, 1122334455, 1127956827.");
	}

}
