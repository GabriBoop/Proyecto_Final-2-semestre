package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;

/**
 * Clase de acceso a datos (DAO) encargada de gestionar las operaciones CRUD y la
 * persistencia en archivos planos (CSV) y serializados (BIN) para los vehículos
 * de tipo Moto.
 */
public class MotoDAO implements DAO<Moto, MotoDTO> {

	/**
	 * Lista en memoria que almacena los objetos Moto registrados.
	 */
	private ArrayList<Moto> listaMotos;

	/**
	 * Nombre del archivo de texto plano CSV donde se respaldan los datos de las
	 * motos.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "Moto.csv";

	/**
	 * Nombre del archivo binario donde se serializa la lista de motos.
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Moto.bin";

	/**
	 * Constructor por defecto de MotoDAO. Inicializa la lista en memoria y carga
	 * los registros previamente guardados desde el archivo serializado.
	 */
	public MotoDAO() {
		setListaMotos(new ArrayList<>());
		leerSerializado();
	}

	/**
	 * Crea y almacena una nueva moto a partir de un objeto de transferencia de
	 * datos, actualizando tanto el archivo plano como el serializado.
	 *
	 * @param D Objeto MotoDTO con la información de la moto a registrar.
	 * @return true si la moto fue agregada exitosamente; false si el DTO recibido es null.
	 */
	@Override
	public boolean crear(MotoDTO D) {
		if (D != null) {
			listaMotos.add(DataMapper.convertirMotoDTOAMoto(D));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina una moto de la lista según su posición y actualiza los archivos de
	 * persistencia.
	 *
	 * @param index Índice de la moto dentro de listaMotos.
	 * @return true si el índice es válido y el registro fue eliminado; false en caso contrario.
	 */
	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaMotos.size()) {
			listaMotos.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza los datos de una moto existente en la posición indicada y guarda
	 * los cambios en persistencia.
	 *
	 * @param index           Índice de la moto a modificar dentro de listaMotos.
	 * @param datoActualizado Objeto MotoDTO con la nueva información de la moto.
	 * @return true si el índice es válido y el registro fue actualizado; false en caso contrario.
	 */
	@Override
	public boolean actualizar(int index, MotoDTO datoActualizado) {
		if (index >= 0 && index < listaMotos.size()) {
			listaMotos.set(index, DataMapper.convertirMotoDTOAMoto(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construye una representación en texto con la información detallada de todas
	 * las motos almacenadas en la lista.
	 *
	 * @return Cadena con los datos de todas las motos registradas.
	 */
	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Moto m : listaMotos) {
			contenido += "Posicion en la lista:" + posicion + "\n";
			contenido += "Placa: " + m.getPlaca() + "\n";
			contenido += "Tipo: " + m.getTipo() + "\n";
			contenido += "Propietario: " + m.getPropietario() + "\n";
			contenido += "Fecha de vencimiento del soat: " + m.getVencimientoSoat();
			posicion++;
		}
		return contenido;
	}

	/**
	 * Obtiene la lista completa de motos almacenadas en memoria.
	 *
	 * @return Lista con los objetos Moto registrados.
	 */
	@Override
	public ArrayList<Moto> darLista() {
		return listaMotos;
	}

	/**
	 * Escribe el contenido actual de listaMotos en el archivo de texto plano CSV
	 * configurado.
	 */
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

	/**
	 * Serializa y guarda la lista actual de motos en el archivo binario
	 * configurado.
	 */
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaMotos);
	}

	/**
	 * Lee la lista de motos desde el archivo serializado. Si el archivo no existe
	 * o está vacío, inicializa una lista nueva vacía.
	 */
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			listaMotos = new ArrayList<>();
		} else {
			listaMotos = (ArrayList<Moto>) o;
		}
	}

	/**
	 * Busca una moto registrada comparando su placa sin distinguir entre
	 * mayúsculas y minúsculas.
	 *
	 * @param placa Placa de la moto a consultar.
	 * @return El objeto Moto coincidente, o null si no se encuentra registrado.
	 */
	public Moto buscarPorPlaca(String placa) {
		for (Moto c : listaMotos) {
			if (c.getPlaca().equalsIgnoreCase(placa)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Obtiene la lista interna de motos.
	 *
	 * @return Lista de objetos Moto.
	 */
	public ArrayList<Moto> getListaMotos() {
		return listaMotos;
	}

	/**
	 * Establece o reemplaza la lista interna de motos.
	 *
	 * @param listaMotos Nueva lista de objetos Moto.
	 */
	public void setListaMotos(ArrayList<Moto> listaMotos) {
		this.listaMotos = listaMotos;
	}

	/**
	 * Obtiene el nombre del archivo de texto CSV asociado a este DAO.
	 *
	 * @return Nombre del archivo CSV.
	 */
	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}

	/**
	 * Obtiene el nombre del archivo binario serializado asociado a este DAO.
	 *
	 * @return Nombre del archivo BIN.
	 */
	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}

}
