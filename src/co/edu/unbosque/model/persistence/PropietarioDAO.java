package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Propietario;
import co.edu.unbosque.model.PropietarioDTO;

public class PropietarioDAO implements DAO<Propietario,PropietarioDTO> {
	
	private ArrayList<Propietario> listaPropietarios;
	private final String NOMBRE_ARCHIVO_TEXTO = "Propietario.csv";
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Propietario.bin";
	
	public PropietarioDAO() {
		setListaPropietarios(new ArrayList<>());
		leerSerializado();
	}

	@Override
	public void crear(PropietarioDTO D) {
		listaPropietarios.add(DataMapper.convertirPropietarioDTOAPropietario(D));
		escribirArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public boolean eliminar(int index) {
		if(index >= 0) {
			listaPropietarios.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean actualizar(int index, PropietarioDTO datoActualizado) {
		if (index >= 0) {
			listaPropietarios.set(index, DataMapper.convertirPropietarioDTOAPropietario(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Propietario p: listaPropietarios) {
			contenido  += "Posicion en la lista:"+ posicion;
			contenido += "Placa: "+ p.getDocumento();
			contenido += "Tipo: "+ p.getNombre();
			contenido += "Propietario: "+ p.getTelefono();
			posicion++;

		}
		return contenido;
	}

	@Override
	public ArrayList<Propietario> darLista() {
		// TODO Auto-generated method stub
		return listaPropietarios;
	}
	
	public void escribirArchivo() {
		String contenido = "";
		for (Propietario p : listaPropietarios) {
			contenido += p.getDocumento() + ";";
			contenido += p.getNombre() + ";";
			contenido += p.getTelefono() + ";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}
	
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaPropietarios);
	}
	
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			// archivo nuevo o vacio: se parte de una lista vacia
			listaPropietarios = new ArrayList<>();
		} else {
			listaPropietarios = (ArrayList<Propietario>) o;
		}
	}

	public ArrayList<Propietario> getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(ArrayList<Propietario> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}

	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}
	

}
