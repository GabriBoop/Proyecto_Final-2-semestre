package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Propietario;
import co.edu.unbosque.model.PropietarioDTO;

/**
 * Clase de acceso a datos (DAO) encargada de gestionar las operaciones CRUD y la
 * persistencia en archivos planos (CSV) y serializados (BIN) para las entidades
 * de tipo Propietario.
 */
public class PropietarioDAO implements DAO<Propietario, PropietarioDTO> {

	/**
	 * Lista en memoria que almacena los objetos Propietario registrados.
	 */
	private ArrayList<Propietario> listaPropietarios;

	/**
	 * Nombre del archivo de texto plano CSV donde se respaldan los datos de los
	 * propietarios.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "Propietario.csv";

	/**
	 * Nombre del archivo binario donde se serializa la lista de propietarios.
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Propietario.bin";

	/**
	 * Constructor por defecto de PropietarioDAO. Inicializa la lista en memoria y
	 * carga los registros previamente guardados desde el archivo serializado.
	 */
	public PropietarioDAO() {
		setListaPropietarios(new ArrayList<>());
		leerSerializado();
	}

	/**
	 * Crea y almacena un nuevo propietario a partir de un objeto de transferencia de
	 * datos, actualizando tanto el archivo plano como el serializado.
	 *
	 * @param D Objeto PropietarioDTO con la información del propietario a registrar.
	 * @return true si el propietario fue agregado exitosamente; false si el DTO recibido es null.
	 */
	@Override
	public boolean crear(PropietarioDTO D) {
		if (D != null) {
			listaPropietarios.add(DataMapper.convertirPropietarioDTOAPropietario(D));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un propietario de la lista según su posición y actualiza los archivos
	 * de persistencia.
	 *
	 * @param index Índice del propietario dentro de listaPropietarios.
	 * @return true si el índice es válido y el registro fue eliminado; false en caso contrario.
	 */
	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaPropietarios.size()) {
			listaPropietarios.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza los datos de un propietario existente en la posición indicada y
	 * guarda los cambios en persistencia.
	 *
	 * @param index           Índice del propietario a modificar dentro de listaPropietarios.
	 * @param datoActualizado Objeto PropietarioDTO con la nueva información del propietario.
	 * @return true si el índice es válido y el registro fue actualizado; false en caso contrario.
	 */
	@Override
	public boolean actualizar(int index, PropietarioDTO datoActualizado) {
		if (index >= 0 && index < listaPropietarios.size()) {
			listaPropietarios.set(index, DataMapper.convertirPropietarioDTOAPropietario(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construye una representación en texto con la información detallada de todos
	 * los propietarios almacenados en la lista.
	 *
	 * @return Cadena con los datos de todos los propietarios registrados.
	 */
	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Propietario p : listaPropietarios) {
			contenido += "Posicion en la lista:" + posicion + "\n";
			contenido += "Documento: " + p.getDocumento() + "\n";
			contenido += "Nombre: " + p.getNombre() + "\n";
			contenido += "Telefono: " + p.getTelefono();
			posicion++;
		}
		return contenido;
	}

	/**
	 * Obtiene la lista completa de propietarios almacenados en memoria.
	 *
	 * @return Lista con los objetos Propietario registrados.
	 */
	@Override
	public ArrayList<Propietario> darLista() {
		return listaPropietarios;
	}

	/**
	 * Escribe el contenido actual de listaPropietarios en el archivo de texto plano
	 * CSV configurado.
	 */
	public void escribirArchivo() {
		String contenido = "";
		for (Propietario p : listaPropietarios) {
			contenido += p.getDocumento() + ";";
			contenido += p.getNombre() + ";";
			contenido += p.getTelefono() + ";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}

	/**
	 * Serializa y guarda la lista actual de propietarios en el archivo binario
	 * configurado.
	 */
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaPropietarios);
	}

	/**
	 * Lee la lista de propietarios desde el archivo serializado. Si el archivo no
	 * existe o está vacío, inicializa una lista nueva vacía.
	 */
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			listaPropietarios = new ArrayList<>();
		} else {
			listaPropietarios = (ArrayList<Propietario>) o;
		}
	}

	/**
	 * Busca un propietario registrado a partir de su número de documento de
	 * identidad.
	 *
	 * @param documento Número de documento del propietario a consultar.
	 * @return El objeto Propietario coincidente, o null si no se encuentra registrado.
	 */
	public Propietario buscarPorDocumento(String documento) {
		for (Propietario p : listaPropietarios) {
			if (p.getDocumento().equals(documento)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Verifica si ya existe un propietario registrado con el número de documento
	 * indicado.
	 *
	 * @param documento Número de documento a validar.
	 * @return true si existe un propietario con ese documento; false en caso contrario.
	 */
	public boolean existeDocumento(String documento) {
		return buscarPorDocumento(documento) != null;
	}

	/**
	 * Obtiene la lista interna de propietarios.
	 *
	 * @return Lista de objetos Propietario.
	 */
	public ArrayList<Propietario> getListaPropietarios() {
		return listaPropietarios;
	}

	/**
	 * Establece o reemplaza la lista interna de propietarios.
	 *
	 * @param listaPropietarios Nueva lista de objetos Propietario.
	 */
	public void setListaPropietarios(ArrayList<Propietario> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
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

