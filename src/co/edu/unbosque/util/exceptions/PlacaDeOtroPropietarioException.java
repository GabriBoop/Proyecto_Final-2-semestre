package co.edu.unbosque.util.exceptions;

/**
 * Excepción personalizada que se lanza cuando se intenta registrar o asociar
 * una placa de vehículo que ya se encuentra vinculada a otro propietario dentro
 * del sistema de parqueadero.
 */
public class PlacaDeOtroPropietarioException extends Exception {

	/**
	 * Constructor por defecto de PlacaDeOtroPropietarioException. Inicializa la
	 * excepción con un mensaje predeterminado indicando que la placa ya pertenece
	 * a otro propietario.
	 */
	public PlacaDeOtroPropietarioException() {
		super("[ERROR] La Placa ya es de otro Propietario");
	}

}
