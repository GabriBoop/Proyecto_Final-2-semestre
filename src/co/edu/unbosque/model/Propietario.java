package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase que representa a un propietario de vehículo.
 * Almacena su documento de identidad, nombre y teléfono de contacto.
 * Implementa Serializable para poder almacenarse en archivos.
 */
public class Propietario implements Serializable {
    
	private static final long serialVersionUID = 1233888836589495674L;
	private String documento;
    private String nombre;
    private String telefono;

    /**
     * Constructor por defecto de la clase Propietario.
     */
    public Propietario() {  	
    }
    
    /**
     * Constructor parametrizado para inicializar un propietario con todos sus datos.
     *
     * @param documento Número de documento de identidad.
     * @param nombre Nombre completo del propietario.
     * @param telefono Número de teléfono de contacto.
     */
    public Propietario(String documento, String nombre, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Obtiene el documento de identidad del propietario.
     *
     * @return Número de documento del propietario.
     */
    public String getDocumento() {
        return documento;
    }
    /**
     * Establece el documento de identidad del propietario.
     *
     * @param documento Nuevo número de documento.
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el nombre del propietario.
     *
     * @return Nombre del propietario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del propietario.
     *
     * @param nombre Nuevo nombre del propietario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono del propietario.
     *
     * @return Número de teléfono del propietario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del propietario.
     *
     * @param telefono Nuevo número de teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}