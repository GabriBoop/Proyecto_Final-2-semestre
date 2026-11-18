package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando una factura consultada o
 * solicitada no se encuentra registrada en el sistema de parqueadero.
 */
public class FacturaNoEncontradaException extends Exception {

	/**
	 * Constructor por defecto de FacturaNoEncontradaException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que la factura no fue
	 * encontrada.
	 */
	public FacturaNoEncontradaException() {
		super("[ERROR] La Factura no fue encontrada");
	}

}
