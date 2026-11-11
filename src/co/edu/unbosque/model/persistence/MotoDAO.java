package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;


public class MotoDAO implements DAO<Moto,MotoDTO>{
	
	private ArrayList<Moto> listaMotos;
	private final String NOMBRE_ARCHIVO_TEXTO = "Moto.csv";
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Moto.bin";
	
	public MotoDAO() {
		setListaMotos(new ArrayList<>());
		leerSerializado();
	}
	@Override
	public void crear(MotoDTO D) {
		// TODO Auto-generated method stub
		listaMotos.add(DataMapper.convertirMotoDTOAMoto(D));
		escribirArchivo();
		escribirArchivoSerializado();
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index >= 0) {
			listaMotos.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean actualizar(int index, MotoDTO datoActualizado) {
		// TODO Auto-generated method stub
		if (index >= 0) {
			listaMotos.set(index, DataMapper.convertirMotoDTOAMoto(datoActualizado));
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

		for (Moto m: listaMotos) {
			contenido  += "Posicion en la lista:"+ posicion+"\n";
			contenido += "Placa: "+m.getPlaca()+"\n";
			contenido += "Tipo: "+m.getTipo()+"\n";
			contenido += "Propietario: "+m.getPropietario()+"\n";
			contenido += "Fecha de vencimiento del soat: "+m.getVencimientoSoat();
			posicion++;

		}
		return contenido;
	}

	@Override
	public ArrayList<Moto> darLista() {
		// TODO Auto-generated method stub
		return listaMotos;
	}
	public void escribirArchivo() {
		String contenido = "";
		for (Moto m : listaMotos) {
			contenido += m.getPlaca() + ";";
			contenido += m.getTipo() + ";";
			contenido += m.getPropietario() + ";";
			contenido += m.getVencimientoSoat() + ";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}
	
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaMotos);
	}

	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			// archivo nuevo o vacio: se parte de una lista vacia
			listaMotos = new ArrayList<>();
		} else {
			listaMotos = (ArrayList<Moto>) o;
		}
	}
	
	public ArrayList<Moto> getListaMotos() {
		return listaMotos;
	}


	public void setListaMotos(ArrayList<Moto> listaMotos) {
		this.listaMotos = listaMotos;
	}


	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}


	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}
	
}