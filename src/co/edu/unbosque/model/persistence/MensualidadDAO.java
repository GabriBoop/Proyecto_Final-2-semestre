package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;

/**
 * Clase de acceso a datos (DAO) encargada de gestionar las operaciones CRUD y
 * la persistencia en archivos planos (CSV) y serializados (BIN) para las
 * entidades de tipo Mensualidad.
 */
public class MensualidadDAO implements DAO<Mensualidad, MensualidadDTO> {

	/**
	 * Lista en memoria que almacena los objetos Mensualidad registrados.
	 */
	private ArrayList<Mensualidad> listaMensualidades;

	/**
	 * Nombre del archivo de texto plano CSV donde se respaldan los datos de las
	 * mensualidades.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "Mensualidad.csv";

	/**
	 * Nombre del archivo binario donde se serializa la lista de mensualidades.
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Mensualidad.bin";

	/**
	 * Constructor por defecto de MensualidadDAO. Inicializa la lista en memoria y
	 * carga los registros previamente guardados desde el archivo serializado.
	 */
	public MensualidadDAO() {
		setListaMensualidades(new ArrayList<>());
		leerSerializado();
	}

	/**
	 * Crea y almacena una nueva mensualidad a partir de un objeto de transferencia
	 * de datos, actualizando tanto el archivo plano como el serializado.
	 *
	 * @param D Objeto MensualidadDTO con la información de la mensualidad a
	 *          registrar.
	 * @return true si la mensualidad fue agregada exitosamente; false si el DTO
	 *         recibido es null.
	 */
	@Override
	public boolean crear(MensualidadDTO D) {
		if (D != null) {
			listaMensualidades.add(DataMapper.convertirMensualidadDTOAMensualidad(D));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina una mensualidad de la lista según su posición y actualiza los
	 * archivos de persistencia.
	 *
	 * @param index Índice de la mensualidad dentro de listaMensualidades.
	 * @return true si el índice es válido y el registro fue eliminado; false en
	 *         caso contrario.
	 */
	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaMensualidades.size()) {
			listaMensualidades.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza los datos de una mensualidad existente en la posición indicada y
	 * guarda los cambios en persistencia.
	 *
	 * @param index           Índice de la mensualidad a modificar dentro de
	 *                        listaMensualidades.
	 * @param datoActualizado Objeto MensualidadDTO con la nueva información de la
	 *                        mensualidad.
	 * @return true si el índice es válido y el registro fue actualizado; false en
	 *         caso contrario.
	 */
	@Override
	public boolean actualizar(int index, MensualidadDTO datoActualizado) {
		if (index >= 0 && index < listaMensualidades.size()) {
			listaMensualidades.set(index, DataMapper.convertirMensualidadDTOAMensualidad(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construye una representación en texto con la información detallada de todas
	 * las mensualidades almacenadas en la lista.
	 *
	 * @return Cadena con los datos de todas las mensualidades registradas.
	 */
	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Mensualidad m : listaMensualidades) {
			contenido += "Posicion en la lista:" + posicion + "\n";
			contenido += "Valor: " + m.getValor() + "\n";
			contenido += "Fecha de Inicio: " + m.getFechaInicio() + "\n";
			contenido += "Propietario: " + m.getPropietario();

			posicion++;
		}
		return contenido;
	}

	/**
	 * Obtiene la lista completa de mensualidades almacenadas en memoria.
	 *
	 * @return Lista con los objetos Mensualidad registrados.
	 */
	@Override
	public ArrayList<Mensualidad> darLista() {
		return listaMensualidades;
	}

	/**
	 * Escribe el contenido actual de listaMensualidades en el archivo de texto
	 * plano CSV configurado.
	 */
	public void escribirArchivo() {
		String contenido = "";
		for (Mensualidad m : listaMensualidades) {
			contenido += m.getValor() + ":";
			contenido += m.getFechaInicio() + ";";
			contenido += m.getPropietario() + ";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}

	/**
	 * Serializa y guarda la lista actual de mensualidades en el archivo binario
	 * configurado.
	 */
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaMensualidades);
	}

	/**
	 * Lee la lista de mensualidades desde el archivo serializado. Si el archivo no
	 * existe o está vacío, inicializa una lista nueva vacía.
	 */
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			listaMensualidades = new ArrayList<>();
		} else {
			listaMensualidades = (ArrayList<Mensualidad>) o;
		}
	}

	/**
	 * Busca el índice de una mensualidad registrada a partir del número de
	 * documento de su propietario.
	 *
	 * @param documento Número de documento del propietario a consultar.
	 * @return Índice de la mensualidad en la lista si existe; -1 en caso contrario.
	 */
	public int buscarIndicePorDocumento(String documento) {
		for (int i = 0; i < listaMensualidades.size(); i++) {
			if (listaMensualidades.get(i).getPropietario().getDocumento().equals(documento)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Obtiene la lista interna de mensualidades.
	 *
	 * @return Lista de objetos Mensualidad.
	 */
	public ArrayList<Mensualidad> getListaMensualidad() {
		return listaMensualidades;
	}

	/**
	 * Establece o reemplaza la lista interna de mensualidades.
	 *
	 * @param listaMensualidades Nueva lista de objetos Mensualidad.
	 */
	public void setListaMensualidades(ArrayList<Mensualidad> listaMensualidades) {
		this.listaMensualidades = listaMensualidades;
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
