package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.*;

/**
 * Clase de acceso a datos (DAO) encargada de gestionar las operaciones CRUD y la
 * persistencia en archivos planos (CSV) y serializados (BIN) para las entidades
 * de tipo Factura.
 */
public class FacturaDAO implements DAO<Factura, FacturaDTO> {

	/**
	 * Lista en memoria que almacena los objetos Factura registrados.
	 */
	private ArrayList<Factura> listaFacturas;

	/**
	 * Nombre del archivo de texto plano CSV donde se respaldan los datos de las
	 * facturas.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "Factura.csv";

	/**
	 * Nombre del archivo binario donde se serializa la lista de facturas.
	 */
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Factura.bin";

	/**
	 * Constructor por defecto de FacturaDAO. Inicializa la lista en memoria y
	 * carga los registros previamente guardados desde el archivo serializado.
	 */
	public FacturaDAO() {
		setListaFacturas(new ArrayList<>());
		leerSerializado();
	}

	/**
	 * Crea y almacena una nueva factura a partir de un objeto de transferencia de
	 * datos, actualizando tanto el archivo plano como el serializado.
	 *
	 * @param D Objeto FacturaDTO con la información de la factura a registrar.
	 * @return true si la factura fue agregada exitosamente; false si el DTO recibido es null.
	 */
	@Override
	public boolean crear(FacturaDTO D) {
		if (D != null) {
			listaFacturas.add(DataMapper.convertirFacturaDTOAFactura(D));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Elimina una factura de la lista según su posición y actualiza los archivos
	 * de persistencia.
	 *
	 * @param index Índice de la factura dentro de listaFacturas.
	 * @return true si el índice es válido y el registro fue eliminado; false en caso contrario.
	 */
	@Override
	public boolean eliminar(int index) {
		if (index >= 0 && index < listaFacturas.size()) {
			listaFacturas.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Actualiza los datos de una factura existente en la posición indicada y
	 * guarda los cambios en persistencia.
	 *
	 * @param index           Índice de la factura a modificar dentro de listaFacturas.
	 * @param datoActualizado Objeto FacturaDTO con la nueva información de la factura.
	 * @return true si el índice es válido y el registro fue actualizado; false en caso contrario.
	 */
	@Override
	public boolean actualizar(int index, FacturaDTO datoActualizado) {
		if (index >= 0 && index < listaFacturas.size()) {
			listaFacturas.set(index, DataMapper.convertirFacturaDTOAFactura(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Construye una representación en texto con la información detallada de todas
	 * las facturas almacenadas en la lista.
	 *
	 * @return Cadena con los datos de todas las facturas registradas.
	 */
	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Factura f : listaFacturas) {
			contenido += "Posicion en la lista:" + posicion + "\n";
			contenido += "Nombre: " + f.getNombrePropietario() + "\n";
			contenido += "Numero de factura: " + f.getNum() + "\n";
			contenido += "Placa: " + f.getPlaca() + "\n";
			contenido += "Forma de Cobro: " + f.getFormaDeCobro() + "\n";
			contenido += "Hora de ingreso: " + f.getHoraIngreso() + "\n";
			contenido += "Hora de salida: " + f.getHoraSalida() + "\n";
			contenido += "Valor Total: " + f.getValor();

			posicion++;
		}
		return contenido;
	}

	/**
	 * Obtiene la lista completa de facturas almacenadas en memoria.
	 *
	 * @return Lista con los objetos Factura registrados.
	 */
	@Override
	public ArrayList<Factura> darLista() {
		return listaFacturas;
	}

	/**
	 * Escribe el contenido actual de listaFacturas en el archivo de texto plano
	 * CSV configurado.
	 */
	public void escribirArchivo() {
		String contenido = "";
		for (Factura f : listaFacturas) {
			contenido += f.getNombrePropietario() + ";";
			contenido += f.getNum() + ";";
			contenido += f.getPlaca() + ";";
			contenido += f.getFormaDeCobro() + ";";
			contenido += f.getHoraIngreso() + ";";
			contenido += f.getHoraSalida() + ";";
			contenido += f.getValor() + ";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}

	/**
	 * Serializa y guarda la lista actual de facturas en el archivo binario
	 * configurado.
	 */
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaFacturas);
	}

	/**
	 * Lee la lista de facturas desde el archivo serializado. Si el archivo no
	 * existe o está vacío, inicializa una lista nueva vacía.
	 */
	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			listaFacturas = new ArrayList<>();
		} else {
			listaFacturas = (ArrayList<Factura>) o;
		}
	}

	/**
	 * Obtiene la lista interna de facturas.
	 *
	 * @return Lista de objetos Factura.
	 */
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}

	/**
	 * Establece o reemplaza la lista interna de facturas.
	 *
	 * @param listaFacturas Nueva lista de objetos Factura.
	 */
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
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


