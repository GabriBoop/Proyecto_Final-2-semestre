package co.edu.unbosque.util.exceptions;

public class RegistroNoEncontradoException extends Exception{
	
	public RegistroNoEncontradoException(String placa) {
        super("[ERROR] El Registro no fue encontrado con la placa: " + placa);
    }

}
