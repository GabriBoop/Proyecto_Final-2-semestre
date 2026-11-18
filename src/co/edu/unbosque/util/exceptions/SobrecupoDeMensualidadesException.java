package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando el parqueadero ha alcanzado su
 * capacidad máxima permitida de mensualidades y no admite el registro de una
 * nueva.
 */
public class SobrecupoDeMensualidadesException extends Exception {

	/**
	 * Constructor por defecto de SobrecupoDeMensualidadesException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que el parqueadero no
	 * admite más mensualidades.
	 */
	public SobrecupoDeMensualidadesException() {
		super("[ERROR] El Parqueadero no Admite mas Mensualidades.");
	}

}
