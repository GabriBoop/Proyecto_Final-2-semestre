package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un registro de
 * ingreso o permanencia asociado a la placa de un vehículo en el sistema de
 * parqueadero.
 */
public class RegistroNoEncontradoException extends Exception {

	/**
	 * Constructor de RegistroNoEncontradoException. Inicializa la excepción con un
	 * mensaje de error detallado que indica la placa del vehículo cuyo registro no
	 * pudo ser localizado.
	 *
	 * @param placa Cadena de texto correspondiente a la placa del vehículo sin registro encontrado.
	 */
	public RegistroNoEncontradoException(String placa) {
		super("[ERROR] El Registro no fue encontrado con la placa: " + placa);
	}

}
