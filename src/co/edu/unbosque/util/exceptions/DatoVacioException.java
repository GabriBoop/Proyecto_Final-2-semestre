package co.edu.unbosque.util.exceptions;

public class DatoVacioException extends Exception{
	
	public DatoVacioException(String dato) {
        super("[ERROR] Hay un dato faltante en el cuestionario: " + dato);
    }

}
