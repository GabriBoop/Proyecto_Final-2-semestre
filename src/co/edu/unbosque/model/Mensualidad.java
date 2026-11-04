package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Mensualidad {

    public static final int VEHICULOS_MAX = 2;
    private Propietario propietario;
    private double valor;
    private LocalDate fechaInicio;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public Mensualidad() {
    }
    
    public Mensualidad(Propietario propietario, double valor, LocalDate fechaInicio) {
        this.propietario = propietario;
        this.valor = valor;
        this.fechaInicio = fechaInicio;
    }
    

    public void agregarVehiculo(Vehiculo v){
        if((vehiculos.size() < VEHICULOS_MAX) 
        && (v.getPropietario().getDocumento().equals(propietario.getDocumento()))){
            vehiculos.add(v);
        }
    } 
    
    public boolean mismaPlaca(String placa) {
    	placa = placa.toUpperCase();
    	for(Vehiculo v: vehiculos) {
    		if(v.getPlaca().equals(placa)) {
    			return true;
    		}
    	}
    	return false;
    }

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
}
