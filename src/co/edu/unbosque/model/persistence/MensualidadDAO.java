package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;


public class MensualidadDAO implements DAO<Mensualidad,MensualidadDTO>{
	
	private ArrayList<Mensualidad> listaMensualidades;
	private final String NOMBRE_ARCHIVO_TEXTO = "Mensualidad.csv";
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Mensualidad.bin";
	
	public MensualidadDAO() {
		setListaMensualidades(new ArrayList<>());
		leerSerializado();
	}
	@Override
	public void crear(MensualidadDTO D) {
		// TODO Auto-generated method stub
		listaMensualidades.add(DataMapper.convertirMensualidadDTOAMensualidad(D));
		escribirArchivo();
		escribirArchivoSerializado();
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index >= 0) {
			listaMensualidades.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean actualizar(int index, MensualidadDTO datoActualizado) {
		// TODO Auto-generated method stub
		if (index >= 0) {
			listaMensualidades.set(index, DataMapper.convertirMensualidadDTOAMensualidad(datoActualizado));
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

		for (Mensualidad m: listaMensualidades) {
			contenido  += "Posicion en la lista:"+ posicion;
			contenido += "Valor: "+m.getValor();
			contenido += "Fecha de Inicio: "+m.getFechaInicio();
			contenido += "Propietario: "+m.getPropietario();
			
			posicion++;

		}
		return contenido;
	}

	@Override
	public ArrayList<Mensualidad> darLista() {
		// TODO Auto-generated method stub
		return listaMensualidades;
	}
	public void escribirArchivo() {
		String contenido = "";
		for (Mensualidad m : listaMensualidades) {
			contenido += m.getValor()+":";
			contenido += m.getFechaInicio()+";";
			contenido += m.getPropietario()+";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}
	
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaMensualidades);
	}

	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			// archivo nuevo o vacio: se parte de una lista vacia
			listaMensualidades = new ArrayList<>();
		} else {
			listaMensualidades = (ArrayList<Mensualidad>) o;
		}
	}
	
	public ArrayList<Mensualidad> getListaMensualidad() {
		return listaMensualidades;
	}


	public void setListaMensualidades(ArrayList<Mensualidad> listaMensualidades) {
		this.listaMensualidades = listaMensualidades;
	}


	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}


	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}
	
}