package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Registro;
import co.edu.unbosque.model.RegistroDTO;

/**
 * Clase de acceso a datos (DAO) encargada de gestionar las operaciones CRUD y la
 * persistencia en archivos planos (CSV) y serializados (BIN) para las entidades
 * de tipo Registro.
 */
public class RegistroDAO implements DAO<Registro, RegistroDTO> {

	/**
	 * Lista en memoria que almacena los objetos Registro ingresados en el sistema.
	 */
	private ArrayList<Registro> listaRegistros;

	/**
	 * Nombre del archivo de texto plano CSV donde se respaldan los datos de los
	 * registros.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "Registro.csv";

	/**
	 * Nombre del archivo binario donde se serializa la lista de registros.
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Registro.bin";

	/**
	 * Constructor por defecto de RegistroDAO. Inicializa la lista en memoria y
	 * carga los registros previamente guardados desde el archivo serializado.
	 */
	public RegistroDAO() {
		setListaRegistros(new ArrayList<>());
		leerSerializado();
	}

	/**
	 * Crea y almacena un nuevo registro a partir de un objeto de transferencia de
	 * datos, actualizando tanto el archivo plano como el serializado.
	 *
	 * @param D Objeto RegistroDTO con la información del registro a crear.
	 * @return true si el registro fue agregado exitosamente; false si el DTO recibido es null.
	 */
	@Override
	public boolean crear(RegistroDTO D) {
		if (D != null) {
			listaRegistros.add(DataMapper.convertirRegistroDTOARegistro(D));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina un registro de la lista según su posición y actualiza los archivos
	 * de persistencia.
	 *
	 * @param index Índice del registro dentro de listaRegistros.
	 * @return true si el índice es válido y el registro fue eliminado; false en caso contrario.
	 */
	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaRegistros.size()) {
			listaRegistros.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza los datos de un registro existente en la posición indicada y
	 * guarda los cambios en persistencia.
	 *
	 * @param index           Índice del registro a modificar dentro de listaRegistros.
	 * @param datoActualizado Objeto RegistroDTO con la nueva información del registro.
	 * @return true si el índice es válido y el registro fue actualizado; false en caso contrario.
	 */
	@Override
	public boolean actualizar(int index, RegistroDTO datoActualizado) {
		if (index >= 0 && index < listaRegistros.size()) {
			listaRegistros.set(index, DataMapper.convertirRegistroDTOARegistro(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construye una representación en texto con la información detallada de todos
	 * los registros almacenados en la lista.
	 *
	 * @return Cadena con los datos de todos los registros guardados.
	 */
	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Registro r : listaRegistros) {
			contenido += "Posicion en la lista:" + posicion + "\n";
			contenido += "Vehiculo: " + r.getVehiculo() + "\n";
			contenido += "Hora de ingreso: " + r.getHoraIngreso() + "\n";
			contenido += "Hora de salida: " + r.getHoraSalida() + "\n";
			contenido += "Tarifa Aplicada: " + r.getTarifaAplicada() + "\n";
			contenido += "Paga mensualidad: " + r.isPagaMensualidad() + "\n";
			contenido += "Activo: " + r.isActivo();
			posicion++;
		}
		return contenido;
	}

	/**
	 * Obtiene la lista completa de registros almacenados en memoria.
	 *
	 * @return Lista con los objetos Registro guardados.
	 */
	@Override
	public ArrayList<Registro> darLista() {
		return listaRegistros;
	}

	/**
	 * Escribe el contenido actual de listaRegistros en el archivo de texto plano
	 * CSV configurado.
	 */
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

	/**
	 * Serializa y guarda la lista actual de registros en el archivo binario
	 * configurado.
	 */
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaRegistros);
	}

	/**
	 * Lee la lista de registros desde el archivo serializado. Si el archivo no
	 * existe o está vacío, inicializa una lista nueva vacía.
	 */
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			listaRegistros = new ArrayList<>();
		} else {
			listaRegistros = (ArrayList<Registro>) o;
		}
	}

	/**
	 * Obtiene la lista interna de registros.
	 *
	 * @return Lista de objetos Registro.
	 */
	public ArrayList<Registro> getListaRegistros() {
		return listaRegistros;
	}

	/**
	 * Establece o reemplaza la lista interna de registros.
	 *
	 * @param listaRegistros Nueva lista de objetos Registro.
	 */
	public void setListaRegistros(ArrayList<Registro> listaRegistros) {
		this.listaRegistros = listaRegistros;
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


