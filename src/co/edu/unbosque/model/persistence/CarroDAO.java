package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;


public class CarroDAO implements DAO<CarroDTO,Carro>{
	
	private ArrayList<Carro> listaCarros;
	private final String NOMBRE_ARCHIVO_TEXTO = "Carro.csv";
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Carro.bin";
	
	public CarroDAO() {
		setListaCarros(new ArrayList<>());
		leerSerializado();
	}
	@Override
	public void crear(CarroDTO D) {
		// TODO Auto-generated method stub
		listaCarros.add(DataMapper.convertirCarroDTOACarro(D));
		escribirArchivo();
		escribirArchivoSerializado();
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index >= 0) {
			listaCarros.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean actualizar(int index, CarroDTO datoActualizado) {
		// TODO Auto-generated method stub
		if (index >= 0) {
			listaCarros.set(index, DataMapper.convertirCarroDTOACarro(datoActualizado));
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

		for (Carro c: listaCarros) {
			contenido  += "Posicion en la lista:"+ posicion+"\n";
			contenido += "Placa: "+c.getPlaca()+"\n";
			contenido += "Tipo: "+c.getTipo()+"\n";
			contenido += "Propietario: "+c.getPropietario()+"\n";
			contenido += "Fecha de vencimiento del soat: "+c.getVencimientoSoat();
			posicion++;

		}
		return contenido;
	}

	@Override
	public ArrayList<Carro> darLista() {
		// TODO Auto-generated method stub
		return listaCarros;
	}
	public void escribirArchivo() {
		String contenido = "";
		for (Carro c : listaCarros) {
			contenido += c.getPlaca() + ";";
			contenido += c.getTipo() + ";";
			contenido += c.getPropietario() + ";";
			contenido += c.getVencimientoSoat() + ";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}
	
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaCarros);
	}

	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			// archivo nuevo o vacio: se parte de una lista vacia
			listaCarros = new ArrayList<>();
		} else {
			listaCarros = (ArrayList<Carro>) o;
		}
	}
	
	public ArrayList<Carro> getListaCarros() {
		return listaCarros;
	}


	public void setListaCarros(ArrayList<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}


	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}


	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}
	
}
