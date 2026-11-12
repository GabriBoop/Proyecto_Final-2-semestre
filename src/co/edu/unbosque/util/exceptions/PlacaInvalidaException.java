package co.edu.unbosque.util.exceptions;


public class PlacaInvalidaException extends RuntimeException{
	
	public PlacaInvalidaException() {
        super("[ERROR] La Placa puesta no cuenta con el formato correcto. (AAA-###)");
    }

}
