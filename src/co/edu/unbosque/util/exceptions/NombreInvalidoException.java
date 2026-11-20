package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando el nombre de un propietario no es
 * válido, es decir, cuando contiene números.
 */
public class NombreInvalidoException extends RuntimeException {

	/**
	 * Constructor por defecto de NombreInvalidoException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que el nombre del
	 * propietario no debe tener números.
	 */
	public NombreInvalidoException() {
		super("[ERROR] El Nombre de Propietario es invalido. (No debe tener numeros)");
	}

}