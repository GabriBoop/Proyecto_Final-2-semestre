package co.edu.unbosque.model;

import java.io.Serializable;

public class PropietarioDTO implements Serializable {
    
	private static final long serialVersionUID = 1233888836589495674L;
	private String documento;
    private String nombre;
    private String telefono;

    public PropietarioDTO() {  	
    }
    
    public PropietarioDTO(String documento, String nombre, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
