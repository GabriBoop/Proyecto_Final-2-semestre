package co.edu.unbosque.util.exceptions;

public class FacturaNoEncontradaException extends Exception{
	
	public FacturaNoEncontradaException() {
        super("[ERROR] La Factura no fue encontrada");
    }

}
