package co.edu.unbosque.util.exceptions;

public class TelefonoInvalidoException extends Exception{
	
	public TelefonoInvalidoException() {
        super("[ERROR] El Telefono no cumple con el formato. (Solo Numeros y deben ser 10 Caracteres)"
        		+ "\n\tEjemplo: 3102578892, 3114858111,  3044411689.");
    }

}
