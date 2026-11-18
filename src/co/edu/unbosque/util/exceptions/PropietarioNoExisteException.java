package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando el propietario consultado o
 * asociado a una operación no se encuentra registrado en el sistema de
 * parqueadero.
 */
public class PropietarioNoExisteException extends Exception {

	/**
	 * Constructor por defecto de PropietarioNoExisteException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que el propietario
	 * ingresado no existe.
	 */
	public PropietarioNoExisteException() {
		super("[ERROR] El Propietario ingresado no Existe");
	}

}
