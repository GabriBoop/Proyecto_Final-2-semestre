package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;
/**
 * Clase de acceso a datos (DAO) encargada de gestionar las operaciones CRUD y la
 * persistencia en archivos planos (.csv) y serializados (.bin)
 * para los vehículos de tipo Carro.
 *
 * @version 1.0
 */
public class CarroDAO implements DAO<Carro, CarroDTO> {

	/**
	 * Lista en memoria que almacena los objetos Carro registrados.
	 */
	private ArrayList<Carro> listaCarros;

	/**
	 * Nombre del archivo de texto plano CSV donde se respaldan los datos de los
	 * carros.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "Carro.csv";

	/**
	 * Nombre del archivo binario donde se serializa la lista de carros.
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Carro.bin";

	/**
	 * Constructor por defecto de CarroDAO. Inicializa la lista en memoria
	 * y carga los registros previamente guardados desde el archivo serializado.
	 */
	public CarroDAO() {
		setListaCarros(new ArrayList<>());
		leerSerializado();
	}

	/**
	 * Crea y almacena un nuevo carro a partir de un objeto de transferencia de
	 * datos, actualizando tanto el archivo plano como el serializado.
	 *
	 * @param D Objeto CarroDTO con la información del carro a registrar.
	 * @return true si el carro fue agregado exitosamente; false si el DTO recibido es null.
	 */
	@Override
	public boolean crear(CarroDTO D) {
		if (D != null) {
			listaCarros.add(DataMapper.convertirCarroDTOACarro(D));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un carro de la lista según su posición y actualiza los archivos de
	 * persistencia.
	 *
	 * @param index Índice del carro dentro de listaCarros.
	 * @return {@code true} si el índice es válido y el registro fue eliminado; false en caso contrario.
	 */
	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaCarros.size()) {
			listaCarros.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza los datos de un carro existente en la posición indicada y guarda
	 * los cambios en persistencia.
	 *
	 * @param index Índice del carro a modificar dentro de listaCarros.
	 * @param datoActualizado Objeto {@link CarroDTO} con la nueva información del carro
	 * @return true si el índice es válido y el registro fue actualizado; false en caso contrario.
	 */
	@Override
	public boolean actualizar(int index, CarroDTO datoActualizado) {
		if (index >= 0 && index < listaCarros.size()) {
			listaCarros.set(index, DataMapper.convertirCarroDTOACarro(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construye una representación en texto con la información detallada de todos
	 * los carros almacenados en la lista.
	 *
	 * @return Cadena con los datos de todos los carros registrados.
	 */
	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Carro c : listaCarros) {
			contenido += "Posicion en la lista:" + posicion + "\n";
			contenido += "Placa: " + c.getPlaca() + "\n";
			contenido += "Tipo: " + c.getTipo() + "\n";
			contenido += "Propietario: " + c.getPropietario() + "\n";
			contenido += "Fecha de vencimiento del soat: " + c.getVencimientoSoat();
			posicion++;
		}
		return contenido;
	}

	/**
	 * Obtiene la lista completa de carros almacenados en memoria.
	 *
	 * @return ArrayList con los objetos Carro registrados.
	 */
	@Override
	public ArrayList<Carro> darLista() {
		return listaCarros;
	}

	/**
	 * Escribe el contenido actual de listaCarros en el archivo de texto
	 * plano CSV configurado.
	 */
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

	/**
	 * Serializa y guarda la lista actual de carros en el archivo binario
	 * configurado.
	 */
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaCarros);
	}

	/**
	 * Lee la lista de carros desde el archivo serializado. Si el archivo no existe
	 * o está vacío, inicializa una lista nueva vacía.
	 */
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			listaCarros = new ArrayList<>();
		} else {
			listaCarros = (ArrayList<Carro>) o;
		}
	}

	/**
	 * Busca un carro registrado comparando su placa sin distinguir entre
	 * mayúsculas y minúsculas.
	 *
	 * @param placa Placa del carro a consultar.
	 * @return El objeto Carro coincidente, o null si no se
	 *         encuentra registrado.
	 */
	public Carro buscarPorPlaca(String placa) {
		for (Carro c : listaCarros) {
			if (c.getPlaca().equalsIgnoreCase(placa)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Obtiene la lista interna de carros.
	 *
	 * @return ArrayList de objetos Carro.
	 */
	public ArrayList<Carro> getListaCarros() {
		return listaCarros;
	}

	/**
	 * Establece o reemplaza la lista interna de carros.
	 *
	 * @param listaCarros Nueva lista de objetos Carro.
	 */
	public void setListaCarros(ArrayList<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}

	/**
	 * Obtiene el nombre del archivo de texto CSV asociado a este DAO.
	 *
	 * @return Nombre del archivo CSV.
	 */
	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}

}
