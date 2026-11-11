package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface DAO<D,E> {

    public void crear(D D);

    public boolean eliminar(int index);

    public boolean actualizar(int index, D datoActualizado);

    public String mostrarTodo();

    public ArrayList<E> darLista();

    
}