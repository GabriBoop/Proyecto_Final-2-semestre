package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar un
 * propietario cuyo documento de identidad ya se encuentra almacenado en el
 * sistema de parqueadero.
 */
public class PropietarioYaExisteException extends Exception {

	/**
	 * Constructor por defecto de PropietarioYaExisteException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que el propietario
	 * ingresado ya existe.
	 */
	public PropietarioYaExisteException() {
		super("[ERROR] El Propietario ingresado Ya Existe");
	}

}
