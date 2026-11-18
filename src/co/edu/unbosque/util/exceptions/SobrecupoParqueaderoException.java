package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando el parqueadero ha alcanzado su
 * capacidad máxima de vehículos estacionados y no permite el ingreso de uno
 * nuevo.
 */
public class SobrecupoParqueaderoException extends Exception {

	/**
	 * Constructor por defecto de SobrecupoParqueaderoException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que el parqueadero está
	 * lleno.
	 */
	public SobrecupoParqueaderoException() {
		super("[ERROR] El Parqueadero esta lleno");
	}

}
