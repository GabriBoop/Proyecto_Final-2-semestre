package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;

/**
 * Pruebas unitarias (JUnit) de la clase PropietarioDAO.
 * Verifica la conversión entre Propietario y PropietarioDTO y las operaciones de persistencia
 * (crear, eliminar, actualizar, buscar y mostrar) usando un directorio temporal
 * para no modificar los archivos reales del sistema.
 */
public class PropietarioDAOTest {

	/**
	 * Entidad de Propietario utilizada como dato de prueba.
	 */
	static Propietario propietarioEntidad;
	/**
	 * DAO de propietarios sometido a prueba.
	 */
	static PropietarioDAO dao;
	/**
	 * Ruta base original de los archivos, restaurada al terminar las pruebas.
	 */
	static String rutaOriginal;

	/**
	 * Se ejecuta una sola vez antes de todas las pruebas.
	 * Guarda la ruta base original de los archivos y crea una entidad inicial de ejemplo,
	 * mostrando sus datos en consola.
	 */
	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		propietarioEntidad = new Propietario("1032941791", "Thomas", "3001234567");
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(propietarioEntidad.getDocumento() + " - " + propietarioEntidad.getNombre());
	}

	/**
	 * Se ejecuta antes de cada prueba. Redirige la ruta base a un directorio temporal nuevo
	 * para aislar los archivos, crea un PropietarioDAO limpio y reinicia la entidad con datos de prueba.
	 *
	 * @throws IOException si no se puede crear el directorio temporal.
	 */
	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("propietarioDaoTest").toString());
		dao = new PropietarioDAO();

		propietarioEntidad = new Propietario("1000000001", "Paula", "3109876543");
	}

	/**
	 * Verifica que la conversión de Propietario a PropietarioDTO con DataMapper conserve todos los atributos.
	 */
	@Test
	public void comprobarConversionEntidadDTO() {
		System.out.println("Iniciando prueba de conversión...");
		PropietarioDTO dto = DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad);
		boolean siEsIgual = true;
		if (!(propietarioEntidad.getDocumento().equals(dto.getDocumento()))) {
			siEsIgual = false;
		}
		if (!(propietarioEntidad.getNombre().equals(dto.getNombre()))) {
			siEsIgual = false;
		}
		if (!(propietarioEntidad.getTelefono().equals(dto.getTelefono()))) {
			siEsIgual = false;
		}
		assertTrue(siEsIgual);
	}

	/**
	 * Verifica que crear almacene un propietario en el DAO y que la lista quede con un elemento.
	 */
	@Test
	public void crearPropietario() {
		System.out.println("Probando metodo crear...");
		PropietarioDTO dto = DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que el propietario creado se guarde en el archivo,
	 * comprobándolo al leerlo desde una nueva instancia de PropietarioDAO.
	 */
	@Test
	public void crearPropietarioPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		PropietarioDAO otroDao = new PropietarioDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("1000000001", otroDao.darLista().get(0).getDocumento());
		assertEquals("Paula", otroDao.darLista().get(0).getNombre());
		assertEquals("3109876543", otroDao.darLista().get(0).getTelefono());
	}

	/**
	 * Verifica que eliminar con un índice válido borre el propietario y deje la lista vacía.
	 */
	@Test
	public void eliminarPropietario() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con un índice negativo retorne false.
	 */
	@Test
	public void eliminarPropietarioIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	/**
	 * Verifica que eliminar con un índice fuera de rango retorne false
	 * y no modifique la lista.
	 */
	@Test
	public void eliminarPropietarioIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con la lista vacía retorne false.
	 */
	@Test
	public void eliminarPropietarioListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que actualizar reemplace los datos de el propietario en el índice indicado
	 * sin cambiar el tamaño de la lista.
	 */
	@Test
	public void actualizarPropietario() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		PropietarioDTO dtoNuevo = new PropietarioDTO("1000000002", "Camila", "3201112233");
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertEquals("1000000002", dao.darLista().get(0).getDocumento());
		assertEquals("Camila", dao.darLista().get(0).getNombre());
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que actualizar con un índice negativo retorne false.
	 */
	@Test
	public void actualizarPropietarioIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		PropietarioDTO dtoNuevo = new PropietarioDTO("1000000002", "Camila", "3201112233");
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	/**
	 * Verifica que actualizar con un índice fuera de rango retorne false
	 * y deje los datos originales intactos.
	 */
	@Test
	public void actualizarPropietarioIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		PropietarioDTO dtoNuevo = new PropietarioDTO("1000000002", "Camila", "3201112233");
		assertFalse(dao.actualizar(5, dtoNuevo));
		assertEquals("1000000001", dao.darLista().get(0).getDocumento());
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que buscarPorDocumento encuentre al propietario existente
	 * y retorne null cuando el documento no existe.
	 */
	@Test
	public void buscarPropietarioPorDocumento() {
		System.out.println("Probando método buscar...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		Propietario encontrado = dao.buscarPorDocumento("1000000001");
		assertNotNull(encontrado);
		assertEquals("Paula", encontrado.getNombre());
		assertNull(dao.buscarPorDocumento("9999999999"));
	}

	/**
	 * Verifica que existeDocumento retorne true para un documento registrado
	 * y false para uno inexistente.
	 */
	@Test
	public void existeDocumento() {
		System.out.println("Probando método existeDocumento...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		assertTrue(dao.existeDocumento("1000000001"));
		assertFalse(dao.existeDocumento("9999999999"));
	}

	/**
	 * Verifica que mostrarTodo incluya los datos de el propietario almacenado.
	 */
	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("1000000001"));
		assertTrue(contenido.contains("Paula"));
		assertTrue(contenido.contains("3109876543"));
	}

	/**
	 * Verifica que mostrarTodo retorne una cadena vacía cuando no hay propietarios.
	 */
	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin propietarios...");
		assertEquals("", dao.mostrarTodo());
	}

	/**
	 * Se ejecuta después de cada prueba. Libera la referencia a la entidad de prueba.
	 */
	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		propietarioEntidad = null;
	}

	/**
	 * Se ejecuta una vez al finalizar todas las pruebas.
	 * Restaura la ruta base original y libera las referencias estáticas.
	 */
	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		propietarioEntidad = null;
		dao = null;
	}
}