package co.edu.unbosque.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

import org.junit.*;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;

/**
 * Pruebas unitarias (JUnit) de la clase CarroDAO.
 * Verifica la conversión entre Carro y CarroDTO y las operaciones de persistencia
 * (crear, eliminar, actualizar, buscar y mostrar) usando un directorio temporal
 * para no modificar los archivos reales del sistema.
 */
public class CarroDAOTest {

	/**
	 * Entidad de Carro utilizada como dato de prueba.
	 */
	static Carro carroEntidad;
	/**
	 * DAO de carros sometido a prueba.
	 */
	static CarroDAO dao;
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
		Propietario propietario = new Propietario("1032941791", "Thomas", "3001234567");
		carroEntidad = new Carro("ABC-123", "CARRO", propietario, LocalDate.of(2026, 11, 20));
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(carroEntidad.getPlaca() + " - " + carroEntidad.getTipo());
	}

	/**
	 * Se ejecuta antes de cada prueba. Redirige la ruta base a un directorio temporal nuevo
	 * para aislar los archivos, crea un CarroDAO limpio y reinicia la entidad con datos de prueba.
	 *
	 * @throws IOException si no se puede crear el directorio temporal.
	 */
	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");

		FileHandler.setRutaBase(Files.createTempDirectory("carroDaoTest").toString());
		dao = new CarroDAO();

		Propietario propietario = new Propietario("1000000001", "Paula", "3109876543");
		carroEntidad = new Carro("XYZ-789", "CARRO", propietario, LocalDate.of(2027, 1, 15));
	}

	/**
	 * Verifica que la conversión de Carro a CarroDTO con DataMapper conserve todos los atributos.
	 */
	@Test
	public void comprobarConversionEntidadDTO() {
		System.out.println("Iniciando prueba de conversión...");
		CarroDTO dto = DataMapper.convertirCarroACarroDTO(carroEntidad);
		boolean siEsIgual = true;
		if (!(carroEntidad.getPlaca().equals(dto.getPlaca()))) {
			siEsIgual = false;
		}
		if (!(carroEntidad.getTipo().equals(dto.getTipo()))) {
			siEsIgual = false;
		}
		if (!(carroEntidad.getPropietario() == dto.getPropietario())) {
			siEsIgual = false;
		}
		if (!(carroEntidad.getVencimientoSoat().equals(dto.getVencimientoSoat()))) {
			siEsIgual = false;
		}
		assertTrue(siEsIgual);
	}

	/**
	 * Verifica que crear almacene un carro en el DAO y que la lista quede con un elemento.
	 */
	@Test
	public void crearCarro() {
		System.out.println("Probando metodo crear...");
		CarroDTO dto = DataMapper.convertirCarroACarroDTO(carroEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que el carro creado se guarde en el archivo,
	 * comprobándolo al leerlo desde una nueva instancia de CarroDAO.
	 */
	@Test
	public void crearCarroPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		CarroDAO otroDao = new CarroDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getPlaca());
	}

	/**
	 * Verifica que eliminar con un índice válido borre el carro y deje la lista vacía.
	 */
	@Test
	public void eliminarCarro() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con un índice negativo retorne false.
	 */
	@Test
	public void eliminarCarroIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	/**
	 * Verifica que actualizar reemplace los datos de el carro en el índice indicado
	 * sin cambiar el tamaño de la lista.
	 */
	@Test
	public void actualizarCarro() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		CarroDTO dtoNuevo = new CarroDTO("QWE-456", "CARRO", carroEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertEquals("QWE-456", dao.darLista().get(0).getPlaca());
	}

	/**
	 * Verifica que buscarPorPlaca encuentre el carro sin distinguir mayúsculas
	 * y retorne null cuando la placa no existe.
	 */
	@Test
	public void buscarCarroPorPlaca() {
		System.out.println("Probando método buscar...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		assertNotNull(dao.buscarPorPlaca("xyz-789"));
		assertNull(dao.buscarPorPlaca("ZZZ-999"));
	}

	/**
	 * Verifica que crear CarroDTO con una placa de formato inválido
	 * lance PlacaInvalidaException.
	 */
	@Test
	public void placaInvalidaLanzaExcepcion() {
		System.out.println("Probando validación de placa inválida...");
		try {
			new CarroDTO("123-ABC", "CARRO", carroEntidad.getPropietario(), LocalDate.of(2027, 1, 15));
			fail("Debio lanzar PlacaInvalidaException");
		} catch (PlacaInvalidaException e) {

		}
	}

	/**
	 * Verifica que eliminar con un índice fuera de rango retorne false
	 * y no modifique la lista.
	 */
	@Test
	public void eliminarCarroIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con la lista vacía retorne false.
	 */
	@Test
	public void eliminarCarroListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que actualizar con un índice negativo retorne false.
	 */
	@Test
	public void actualizarCarroIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		CarroDTO dtoNuevo = new CarroDTO("QWE-456", "CARRO", carroEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	/**
	 * Verifica que actualizar con un índice fuera de rango retorne false
	 * y deje los datos originales intactos.
	 */
	@Test
	public void actualizarCarroIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		CarroDTO dtoNuevo = new CarroDTO("QWE-456", "CARRO", carroEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
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
		carroEntidad = null;
	}

	/**
	 * Se ejecuta una vez al finalizar todas las pruebas.
	 * Restaura la ruta base original y libera las referencias estáticas.
	 */
	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		carroEntidad = null;
		dao = null;
	}
}