package co.edu.unbosque.util.exceptions;

public class DocumentoInvalidoException extends Exception{
	
	public DocumentoInvalidoException() {
        super("[ERROR] El Documento no cumple con el formato. (Solo Numeros y deben ser 10 Caracteres)"
        		+ "\n\tEjemplo: 1234567890, 1122334455, 1127956827.");
    }

}
