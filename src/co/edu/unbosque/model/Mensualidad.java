package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa la mensualidad de un propietario.
 * Una mensualidad pertenece a un único propietario y puede cubrir hasta
 * dos vehículos del mismo.
 * Implementa Serializable para poder almacenarse en archivos.
 */
public class Mensualidad implements Serializable {

	private static final long serialVersionUID = 2914016275718574823L;
	/**
	 * Cantidad máxima de vehículos permitidos por mensualidad.
	 */
	public static final int VEHICULOS_MAX = 2;
	/**
	 * Valor estándar de una mensualidad en pesos.
	 */
	public static final double VALOR_MENSUALIDAD = 200000.0;
    private Propietario propietario;
    private double valor;
    private LocalDate fechaInicio;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Constructor por defecto de la clase Mensualidad.
     */
    public Mensualidad() {
    }
    
    /**
     * Constructor parametrizado para inicializar una mensualidad sin vehículos asociados.
     *
     * @param propietario Propietario titular de la mensualidad.
     * @param valor Valor de la mensualidad en pesos.
     * @param fechaInicio Fecha de inicio de la mensualidad.
     */
    public Mensualidad(Propietario propietario, double valor, LocalDate fechaInicio) {
        this.propietario = propietario;
        this.valor = valor;
        this.fechaInicio = fechaInicio;
    }
    

    /**
     * Agrega un vehículo a la mensualidad. Solo se agrega si no se ha alcanzado
     * el máximo de vehículos permitidos y si el vehículo pertenece al mismo
     * propietario de la mensualidad; de lo contrario no realiza ninguna acción.
     *
     * @param v Vehículo a agregar.
     */
    public void agregarVehiculo(Vehiculo v){
        if((vehiculos.size() < VEHICULOS_MAX) 
        && (v.getPropietario().getDocumento().equals(propietario.getDocumento()))){
            vehiculos.add(v);
        }
    } 
    
    /**
     * Verifica si alguno de los vehículos de la mensualidad tiene la placa indicada.
     * La comparación no distingue entre mayúsculas y minúsculas.
     *
     * @param placa Placa a buscar.
     * @return true si la placa pertenece a un vehículo de la mensualidad, false en caso contrario.
     */
    public boolean mismaPlaca(String placa) {
    	placa = placa.toUpperCase();
    	for(Vehiculo v: vehiculos) {
    		if(v.getPlaca().equals(placa)) {
    			return true;
    		}
    	}
    	return false;
    }

	/**
	 * Obtiene el propietario.
	 *
	 * @return Propietario asociado.
	 */
	public Propietario getPropietario() {
		return propietario;
	}

	/**
	 * Establece el propietario.
	 *
	 * @param propietario Nuevo propietario.
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	/**
	 * Obtiene el valor de la mensualidad.
	 *
	 * @return Valor de la mensualidad en pesos.
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Establece el valor de la mensualidad.
	 *
	 * @param valor Nuevo valor de la mensualidad.
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene la fecha de inicio de la mensualidad.
	 *
	 * @return Fecha de inicio de la mensualidad.
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece la fecha de inicio de la mensualidad.
	 *
	 * @param fechaInicio Nueva fecha de inicio.
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene la lista de vehículos cubiertos por la mensualidad.
	 *
	 * @return Lista de vehículos asociados a la mensualidad.
	 */
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	/**
	 * Establece la lista de vehículos cubiertos por la mensualidad.
	 *
	 * @param vehiculos Nueva lista de vehículos.
	 */
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
}