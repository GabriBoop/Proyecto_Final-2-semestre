package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
	
	private static final long serialVersionUID = -4016179404196258637L;

	public abstract double calcularCosto(Registro registro);
    
}
