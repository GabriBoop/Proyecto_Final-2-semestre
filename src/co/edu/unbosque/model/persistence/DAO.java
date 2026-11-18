package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * Interfaz genérica de objeto de acceso a datos (DAO) que define las operaciones
 * básicas de persistencia (crear, eliminar, actualizar, consultar y listar)
 * para las entidades del sistema.
 *
 * @param <E> Tipo de la entidad del modelo que se almacena.
 * @param <D> Tipo del objeto de transferencia de datos (DTO) asociado a la entidad.
 */
public interface DAO<E, D> {

	/**
	 * Crea y almacena un nuevo registro a partir de un objeto de transferencia de
	 * datos.
	 *
	 * @param D Objeto DTO con la información del registro a crear.
	 * @return true si el registro fue creado correctamente; false en caso contrario.
	 */
	public boolean crear(D D);

	/**
	 * Elimina un registro existente según su posición en la colección.
	 *
	 * @param index Índice del elemento que se desea eliminar.
	 * @return true si el elemento fue eliminado exitosamente; false si el índice no es válido.
	 */
	public boolean eliminar(int index);

	/**
	 * Actualiza la información de un registro existente en la posición indicada.
	 *
	 * @param index           Índice del elemento que se desea modificar.
	 * @param datoActualizado Objeto DTO con los nuevos datos a guardar.
	 * @return true si el elemento fue actualizado exitosamente; false si el índice no es válido.
	 */
	public boolean actualizar(int index, D datoActualizado);

	/**
	 * Genera una representación en texto con la información de todos los registros
	 * almacenados.
	 *
	 * @return Cadena de texto con el detalle de todos los elementos registrados.
	 */
	public String mostrarTodo();

	/**
	 * Obtiene la lista completa de entidades almacenadas.
	 *
	 * @return Lista de objetos de tipo E registrados.
	 */
	public ArrayList<E> darLista();

}
