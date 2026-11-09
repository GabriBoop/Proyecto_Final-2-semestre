package co.edu.unbosque.util.exceptions;

public class PlacaNoEncontradaException extends Exception{
	
	public PlacaNoEncontradaException(String placa) {
        super("[ERROR] La Placa no fue encontrada: " + placa);
    }

}
