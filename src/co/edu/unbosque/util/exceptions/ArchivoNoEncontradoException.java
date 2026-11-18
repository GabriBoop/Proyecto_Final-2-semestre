package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un archivo o
 * registro solicitado dentro del sistema de parqueadero.
 */
public class ArchivoNoEncontradoException extends Exception {

	/**
	 * Constructor por defecto de ArchivoNoEncontradoException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que el registro no fue
	 * encontrado.
	 */
	public ArchivoNoEncontradoException() {
		super("[ERROR] El Registro no fue encontrado");
	}

}
