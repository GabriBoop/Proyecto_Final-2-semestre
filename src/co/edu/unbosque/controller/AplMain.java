package co.edu.unbosque.controller;

/**
 * Clase principal de la aplicación. Contiene el punto de entrada del programa.
 */
public class AplMain {

	/**
	 * Punto de entrada de la aplicacion. Crea el controlador y lo inicia.
	 */
	public static void main(String[] args) {
		Controller c = new Controller();
		c.start();
	}
}