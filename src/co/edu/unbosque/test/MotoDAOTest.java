package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.*;

public class MotoDAOTest {

	static Moto motoEntidad;
	static MotoDAO dao;
	static String rutaOriginal;

	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		Propietario propietario = new Propietario("1032941791", "Thomas", "3001234567");
		motoEntidad = new Moto("ABC-123", "MOTO", propietario, LocalDate.of(2026, 11, 20));
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(motoEntidad.getPlaca() + " - " + motoEntidad.getTipo());
	}

	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("motoDaoTest").toString());
		dao = new MotoDAO();

		Propietario propietario = new Propietario("1000000001", "Paula", "3109876543");
		motoEntidad = new Moto("XYZ-789", "MOTO", propietario, LocalDate.of(2027, 1, 15));
	}

	@Test
	public void comprobarConversionEntidadDTO() {
		System.out.println("Iniciando prueba de conversión...");
		MotoDTO dto = DataMapper.convertiMotoAMotoDTO(motoEntidad);
		boolean siEsIgual = true;
		if (!(motoEntidad.getPlaca().equals(dto.getPlaca()))) {
			siEsIgual = false;
		}
		if (!(motoEntidad.getTipo().equals(dto.getTipo()))) {
			siEsIgual = false;
		}
		if (!(motoEntidad.getPropietario() == dto.getPropietario())) {
			siEsIgual = false;
		}
		if (!(motoEntidad.getVencimientoSoat().equals(dto.getVencimientoSoat()))) {
			siEsIgual = false;
		}
		assertTrue(siEsIgual);
	}

	@Test
	public void crearMoto() {
		System.out.println("Probando metodo crear...");
		MotoDTO dto = DataMapper.convertiMotoAMotoDTO(motoEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void crearMotoPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		MotoDAO otroDao = new MotoDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getPlaca());
		assertEquals("1000000001", otroDao.darLista().get(0).getPropietario().getDocumento());
	}

	@Test
	public void eliminarMoto() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void eliminarMotoIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	@Test
	public void actualizarMoto() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		MotoDTO dtoNuevo = new MotoDTO("QWE-456", "MOTO", motoEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertEquals("QWE-456", dao.darLista().get(0).getPlaca());
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void buscarMotoPorPlaca() {
		System.out.println("Probando método buscar...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		assertNotNull(dao.buscarPorPlaca("xyz-789"));
		assertNull(dao.buscarPorPlaca("ZZZ-999"));
	}

	@Test
	public void mostrarTodoIncluyeLaPlaca() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		assertTrue(dao.mostrarTodo().contains("XYZ-789"));
	}

	@Test
	public void placaInvalidaLanzaExcepcion() {
		System.out.println("Probando validación de placa inválida...");
		try {
			new MotoDTO("123-ABC", "MOTO", motoEntidad.getPropietario(), LocalDate.of(2027, 1, 15));
			fail("Debio lanzar PlacaInvalidaException");
		} catch (PlacaInvalidaException e) {

		}
	}

	@Test
	public void eliminarMotoIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void eliminarMotoListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void actualizarMotoIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		MotoDTO dtoNuevo = new MotoDTO("QWE-456", "MOTO", motoEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	@Test
	public void actualizarMotoIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertiMotoAMotoDTO(motoEntidad));
		MotoDTO dtoNuevo = new MotoDTO("QWE-456", "MOTO", motoEntidad.getPropietario(), LocalDate.of(2028, 5, 10));
		assertFalse(dao.actualizar(5, dtoNuevo));
		assertEquals("XYZ-789", dao.darLista().get(0).getPlaca());
		assertEquals(1, dao.darLista().size());
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		motoEntidad = null;
	}

	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		motoEntidad = null;
		dao = null;
	}
}