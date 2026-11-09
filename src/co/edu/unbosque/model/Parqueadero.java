package co.edu.unbosque.model;

import java.util.ArrayList;

public class Parqueadero {
	
    private static final double PORCENTAJE = 0.30;
    private static final double CANITIDAD_MAX = 100;
    
    private int cantidad = 0;
    private ArrayList<Registro> registros = new ArrayList<>();
	private ArrayList<Mensualidad> mensualidades = new ArrayList<>();
	private ArrayList<Factura> facturas = new ArrayList<>();
	
    public Parqueadero() {
    }
    
    public Registro ingresarVehiculo(Vehiculo v) {
    	cantidad++;
    	return null;
    }
    
    public Factura salidaVehiculo(Vehiculo v) {
    	cantidad--;
    	return null;
    }
    
}
