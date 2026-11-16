package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.*;

public class CarroDAOTest {

	static Carro carroEntidad;
	static CarroDAO dao;
	static String rutaOriginal;

	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		Propietario propietario = new Propietario("1032941791", "Thomas", "3001234567");
		carroEntidad = new Carro("ABC-123", "CARRO", propietario, LocalDate.of(2026, 11, 20));
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(carroEntidad.getPlaca() + " - " + carroEntidad.getTipo());
	}

	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("carroDaoTest").toString());
		dao = new CarroDAO();

		Propietario propietario = new Propietario("1000000001", "Paula", "3109876543");
		carroEntidad = new Carro("XYZ-789", "CARRO", propietario, LocalDate.of(2027, 1, 15));
	}

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

	@Test
	public void crearCarro() {
		System.out.println("Probando metodo crear...");
		CarroDTO dto = DataMapper.convertirCarroACarroDTO(carroEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void crearCarroPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		CarroDAO otroDao = new CarroDAO(); 
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getPlaca());
	}

	@Test
	public void eliminarCarro() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void eliminarCarroIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	@Test
	public void actualizarCarro() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		CarroDTO dtoNuevo = new CarroDTO("QWE-456", "CARRO", carroEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertEquals("QWE-456", dao.darLista().get(0).getPlaca());
	}

	@Test
	public void buscarCarroPorPlaca() {
		System.out.println("Probando método buscar...");
		dao.crear(DataMapper.convertirCarroACarroDTO(carroEntidad));
		assertNotNull(dao.buscarPorPlaca("xyz-789"));
		assertNull(dao.buscarPorPlaca("ZZZ-999"));
	}

	@Test
	public void placaInvalidaLanzaExcepcion() {
		System.out.println("Probando validación de placa inválida...");
		try {
			new CarroDTO("123-ABC", "CARRO", carroEntidad.getPropietario(), LocalDate.of(2027, 1, 15));
			fail("Debio lanzar PlacaInvalidaException");
		} catch (PlacaInvalidaException e) {
			
		}
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		carroEntidad = null;
	}

	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal); 
		carroEntidad = null;
		dao = null;
	}
}