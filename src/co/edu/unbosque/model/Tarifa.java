package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa una tarifa de cobro del parqueadero.
 * Cada tipo de tarifa define su propia forma de calcular el costo de una estadía.
 * Implementa Serializable para poder almacenarse en archivos.
 */
public abstract class Tarifa implements Serializable {
	
	private static final long serialVersionUID = -4016179404196258637L;

	/**
	 * Método abstracto para calcular el costo de una estadía.
	 *
	 * @param registro Registro del vehículo con sus horas de ingreso y salida.
	 * @return Costo total calculado en pesos.
	 */
	public abstract double calcularCosto(Registro registro);
    
}