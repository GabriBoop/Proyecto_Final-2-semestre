package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar o validar un
 * vehículo cuyo Seguro Obligatorio de Accidentes de Tránsito (SOAT) tiene una
 * fecha de vencimiento anterior o igual a la fecha actual.
 */
public class SoatVencidoException extends Exception {

	/**
	 * Constructor por defecto de SoatVencidoException. Inicializa la excepción con
	 * un mensaje predeterminado indicando que el SOAT está vencido y que su fecha
	 * de vencimiento debe ser posterior a la actual.
	 */
	public SoatVencidoException() {
		super("El SOAT está vencido. La fecha de vencimiento debe ser posterior a hoy.");
	}

}