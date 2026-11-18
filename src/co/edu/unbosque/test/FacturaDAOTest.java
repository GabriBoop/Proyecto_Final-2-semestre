package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;

/**
 * Pruebas unitarias (JUnit) de la clase FacturaDAO.
 * Verifica la conversión entre Factura y FacturaDTO y las operaciones de persistencia
 * (crear, eliminar, actualizar, buscar y mostrar) usando un directorio temporal
 * para no modificar los archivos reales del sistema.
 */
public class FacturaDAOTest {

	/**
	 * Entidad de Factura utilizada como dato de prueba.
	 */
	static Factura facturaEntidad;
	/**
	 * DAO de facturas sometido a prueba.
	 */
	static FacturaDAO dao;
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
		facturaEntidad = new Factura(1, "ABC-123", "Thomas", LocalDateTime.of(2026, 11, 20, 8, 0),
				LocalDateTime.of(2026, 11, 20, 10, 30), FormaDeCobro.HORA, 12000);
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(facturaEntidad.getNum() + " - " + facturaEntidad.getPlaca());
	}

	/**
	 * Se ejecuta antes de cada prueba. Redirige la ruta base a un directorio temporal nuevo
	 * para aislar los archivos, crea un FacturaDAO limpio y reinicia la entidad con datos de prueba.
	 *
	 * @throws IOException si no se puede crear el directorio temporal.
	 */
	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("facturaDaoTest").toString());
		dao = new FacturaDAO();

		facturaEntidad = new Factura(2, "XYZ-789", "Paula", LocalDateTime.of(2027, 1, 15, 9, 0),
				LocalDateTime.of(2027, 1, 15, 11, 0), FormaDeCobro.FIJA, 8000);
	}

	/**
	 * Verifica que la conversión de Factura a FacturaDTO con DataMapper conserve todos los atributos.
	 */
	@Test
	public void comprobarConversionEntidadDTO() {
		System.out.println("Iniciando prueba de conversión...");
		FacturaDTO dto = DataMapper.convertirFacturaAFacturaDTO(facturaEntidad);
		boolean siEsIgual = true;
		if (!(facturaEntidad.getNum() == dto.getNum())) {
			siEsIgual = false;
		}
		if (!(facturaEntidad.getPlaca().equals(dto.getPlaca()))) {
			siEsIgual = false;
		}
		if (!(facturaEntidad.getNombrePropietario().equals(dto.getNombrePropietario()))) {
			siEsIgual = false;
		}
		if (!(facturaEntidad.getHoraIngreso().equals(dto.getHoraIngreso()))) {
			siEsIgual = false;
		}
		if (!(facturaEntidad.getHoraSalida().equals(dto.getHoraSalida()))) {
			siEsIgual = false;
		}
		if (!(facturaEntidad.getFormaDeCobro() == dto.getFormaDeCobro())) {
			siEsIgual = false;
		}
		if (!(facturaEntidad.getValor() == dto.getValor())) {
			siEsIgual = false;
		}
		assertTrue(siEsIgual);
	}

	/**
	 * Verifica que crear almacene una factura en el DAO y que la lista quede con un elemento.
	 */
	@Test
	public void crearFactura() {
		System.out.println("Probando metodo crear...");
		FacturaDTO dto = DataMapper.convertirFacturaAFacturaDTO(facturaEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que la factura creado se guarde en el archivo,
	 * comprobándolo al leerlo desde una nueva instancia de FacturaDAO.
	 */
	@Test
	public void crearFacturaPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		FacturaDAO otroDao = new FacturaDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getPlaca());
		assertEquals(2, otroDao.darLista().get(0).getNum());
		assertEquals(8000, otroDao.darLista().get(0).getValor(), 0.001);
	}

	/**
	 * Verifica que eliminar con un índice válido borre la factura y deje la lista vacía.
	 */
	@Test
	public void eliminarFactura() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con un índice negativo retorne false.
	 */
	@Test
	public void eliminarFacturaIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	/**
	 * Verifica que actualizar reemplace los datos de la factura en el índice indicado
	 * sin cambiar el tamaño de la lista.
	 */
	@Test
	public void actualizarFactura() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		FacturaDTO dtoNuevo = new FacturaDTO(3, "QWE-456", "Camila", LocalDateTime.of(2028, 5, 10, 7, 0),
				LocalDateTime.of(2028, 5, 10, 9, 0), FormaDeCobro.MENSUAL, 50000);
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertEquals("QWE-456", dao.darLista().get(0).getPlaca());
		assertEquals(FormaDeCobro.MENSUAL, dao.darLista().get(0).getFormaDeCobro());
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que mostrarTodo incluya los datos de la factura almacenado.
	 */
	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("XYZ-789"));
		assertTrue(contenido.contains("Paula"));
	}

	/**
	 * Verifica que mostrarTodo retorne una cadena vacía cuando no hay facturas.
	 */
	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin facturas...");
		assertEquals("", dao.mostrarTodo());
	}

	/**
	 * Verifica que eliminar con un índice fuera de rango retorne false
	 * y no modifique la lista.
	 */
	@Test
	public void eliminarFacturaIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con la lista vacía retorne false.
	 */
	@Test
	public void eliminarFacturaListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que actualizar con un índice negativo retorne false.
	 */
	@Test
	public void actualizarFacturaIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		FacturaDTO dtoNuevo = new FacturaDTO(3, "QWE-456", "Camila", LocalDateTime.of(2028, 5, 10, 7, 0),
				LocalDateTime.of(2028, 5, 10, 9, 0), FormaDeCobro.MENSUAL, 50000);
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	/**
	 * Verifica que actualizar con un índice fuera de rango retorne false
	 * y deje los datos originales intactos.
	 */
	@Test
	public void actualizarFacturaIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		FacturaDTO dtoNuevo = new FacturaDTO(3, "QWE-456", "Camila", LocalDateTime.of(2028, 5, 10, 7, 0),
				LocalDateTime.of(2028, 5, 10, 9, 0), FormaDeCobro.MENSUAL, 50000);
		assertFalse(dao.actualizar(5, dtoNuevo));
		assertEquals("XYZ-789", dao.darLista().get(0).getPlaca());
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Se ejecuta después de cada prueba. Libera la referencia a la entidad de prueba.
	 */
	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		facturaEntidad = null;
	}

	/**
	 * Se ejecuta una vez al finalizar todas las pruebas.
	 * Restaura la ruta base original y libera las referencias estáticas.
	 */
	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		facturaEntidad = null;
		dao = null;
	}
}