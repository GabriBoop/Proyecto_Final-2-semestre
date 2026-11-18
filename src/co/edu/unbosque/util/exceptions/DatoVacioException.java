package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando un campo obligatorio dentro de un
 * formulario o cuestionario se encuentra vacío o sin diligenciar.
 */
public class DatoVacioException extends Exception {

	/**
	 * Constructor de DatoVacioException. Inicializa la excepción con un mensaje
	 * de error indicando el nombre del campo que falta por completar.
	 *
	 * @param dato Nombre o descripción del dato obligatorio que se dejó vacío.
	 */
	public DatoVacioException(String dato) {
		super("[ERROR] Hay un dato faltante en el cuestionario: " + dato);
	}

}
