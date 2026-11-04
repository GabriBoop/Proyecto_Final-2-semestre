package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface DAO<D, E> {

    public boolean crear(D D);

    public boolean eliminar(D datoEliminar);

    public boolean actualizar(D anterior, D nuevoDato);

    public String mostrarTodo();

    public ArrayList<D> darLista();

    public D buscar(D paraBuscar);
    
}