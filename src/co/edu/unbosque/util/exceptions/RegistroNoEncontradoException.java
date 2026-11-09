package co.edu.unbosque.util.exceptions;

public class RegistroNoEncontradoException extends Exception{
	
	public RegistroNoEncontradoException() {
        super("[ERROR] El Archivo no fue encontrado");
    }

}
