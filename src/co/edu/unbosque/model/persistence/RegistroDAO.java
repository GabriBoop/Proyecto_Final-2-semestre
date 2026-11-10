package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Registro;
import co.edu.unbosque.model.RegistroDTO;

public class RegistroDAO implements DAO<Registro, RegistroDTO> {
	
	private ArrayList<Registro> listaRegistros;
	private final String NOMBRE_ARCHIVO_TEXTO = "Registro.csv";
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Registro.bin";
	
	public RegistroDAO() {
		setListaRegistros(new ArrayList<>());
		escribirArchivo();
		escribirArchivoSerializado();
	}

	@Override
	public void crear(RegistroDTO D) {
		listaRegistros.add(DataMapper.convertirRegistroDTOARegistro(D));
		escribirArchivo();
		escribirArchivoSerializado();
		
	}

	@Override
	public boolean eliminar(int index) {
		if(index >= 0) {
			listaRegistros.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean actualizar(int index, RegistroDTO datoActualizado) {
		if (index >= 0) {
			listaRegistros.set(index, DataMapper.convertirRegistroDTOARegistro(datoActualizado));
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

		for (Registro r: listaRegistros) {
			contenido  += "Posicion en la lista:"+ posicion;
			contenido += "Vehiculo: "+ r.getVehiculo();
			contenido += "Hora de ingreso: "+ r.getHoraIngreso();
			contenido += "Hora de salida: "+ r.getHoraSalida();
			contenido += "Tarifa Aplicada: "+ r.getTarifaAplicada();
			contenido += "Paga mensualidad: "+ r.isPagaMensualidad();
			contenido += "Activo: "+ r.isActivo();
			posicion++;

		}
		return contenido;
	}

	@Override
	public ArrayList<Registro> darLista() {
		// TODO Auto-generated method stub
		return listaRegistros;
	}
	
	public void escribirArchivo() {
		String contenido = "";
		for (Registro r : listaRegistros) {
			contenido += r.getVehiculo() + ";";
			contenido += r.getHoraIngreso() + ";";
			contenido += r.getHoraSalida() + ";";
			contenido += r.getTarifaAplicada() + ";";
			contenido += r.isPagaMensualidad() + ";";
			contenido += r.isActivo() + ";";
			
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}
	
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaRegistros);
	}
	
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			// archivo nuevo o vacio: se parte de una lista vacia
			listaRegistros = new ArrayList<>();
		} else {
			listaRegistros = (ArrayList<Registro>) o;
		}
	}


	public ArrayList<Registro> getListaRegistros() {
		return listaRegistros;
	}

	public void setListaRegistros(ArrayList<Registro> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}

	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}
	

}
