package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;

public class RegistroDAOTest {

	static Registro registroEntidad;
	static RegistroDAO dao;
	static String rutaOriginal;

	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		Propietario propietario = new Propietario("1032941791", "Thomas", "3001234567");
		Carro carro = new Carro("ABC-123", "CARRO", propietario, LocalDate.of(2026, 11, 20));
		registroEntidad = new Registro(carro, LocalDateTime.of(2026, 11, 20, 8, 0), false, new TarifaPorHora());
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(registroEntidad.getVehiculo().getPlaca() + " - " + registroEntidad.getHoraIngreso());
	}

	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("registroDaoTest").toString());
		dao = new RegistroDAO();

		Propietario propietario = new Propietario("1000000001", "Paula", "3109876543");
		Carro carro = new Carro("XYZ-789", "CARRO", propietario, LocalDate.of(2027, 1, 15));
		registroEntidad = new Registro(carro, LocalDateTime.of(2027, 1, 15, 8, 0), false, new TarifaPorHora());
		registroEntidad.setHoraSalida(LocalDateTime.of(2027, 1, 15, 10, 30));
	}

	@Test
	public void comprobarConversionEntidadDTO() {
		System.out.println("Iniciando prueba de conversión...");
		RegistroDTO dto = DataMapper.convertirRegistroARegistroDTO(registroEntidad);
		boolean siEsIgual = true;
		if (!(registroEntidad.getVehiculo() == dto.getVehiculo())) {
			siEsIgual = false;
		}
		if (!(registroEntidad.getHoraIngreso().equals(dto.getHoraIngreso()))) {
			siEsIgual = false;
		}
		if (!(registroEntidad.getHoraSalida().equals(dto.getHoraSalida()))) {
			siEsIgual = false;
		}
		if (!(registroEntidad.isPagaMensualidad() == dto.isPagaMensualidad())) {
			siEsIgual = false;
		}
		if (!(registroEntidad.getTarifaAplicada() == dto.getTarifaAplicada())) {
			siEsIgual = false;
		}
		assertTrue(siEsIgual);
	}

	@Test
	public void crearRegistro() {
		System.out.println("Probando metodo crear...");
		RegistroDTO dto = DataMapper.convertirRegistroARegistroDTO(registroEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void crearRegistroPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertirRegistroARegistroDTO(registroEntidad));
		RegistroDAO otroDao = new RegistroDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getVehiculo().getPlaca());
		assertEquals(LocalDateTime.of(2027, 1, 15, 8, 0), otroDao.darLista().get(0).getHoraIngreso());
		assertEquals(LocalDateTime.of(2027, 1, 15, 10, 30), otroDao.darLista().get(0).getHoraSalida());
		assertTrue(otroDao.darLista().get(0).getTarifaAplicada() instanceof TarifaPorHora);
	}

	@Test
	public void eliminarRegistro() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirRegistroARegistroDTO(registroEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void eliminarRegistroIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	@Test
	public void eliminarRegistroIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirRegistroARegistroDTO(registroEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void eliminarRegistroListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void actualizarRegistro() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertirRegistroARegistroDTO(registroEntidad));
		RegistroDTO dtoNuevo = new RegistroDTO(registroEntidad.getVehiculo(), LocalDateTime.of(2028, 5, 10, 22, 0),
				true, new TarifaNocturnaFija());
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertTrue(dao.darLista().get(0).isPagaMensualidad());
		assertTrue(dao.darLista().get(0).getTarifaAplicada() instanceof TarifaNocturnaFija);
		assertEquals(LocalDateTime.of(2028, 5, 10, 22, 0), dao.darLista().get(0).getHoraIngreso());
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void actualizarRegistroIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		RegistroDTO dtoNuevo = new RegistroDTO(registroEntidad.getVehiculo(), LocalDateTime.of(2028, 5, 10, 22, 0),
				true, new TarifaNocturnaFija());
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	@Test
	public void actualizarRegistroIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertirRegistroARegistroDTO(registroEntidad));
		RegistroDTO dtoNuevo = new RegistroDTO(registroEntidad.getVehiculo(), LocalDateTime.of(2028, 5, 10, 22, 0),
				true, new TarifaNocturnaFija());
		assertFalse(dao.actualizar(5, dtoNuevo));
		assertFalse(dao.darLista().get(0).isPagaMensualidad());
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirRegistroARegistroDTO(registroEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("Hora de ingreso: 2027-01-15T08:00"));
		assertTrue(contenido.contains("Paga mensualidad: false"));
		assertTrue(contenido.contains("Activo: true"));
	}

	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin registros...");
		assertEquals("", dao.mostrarTodo());
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		registroEntidad = null;
	}

	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		registroEntidad = null;
		dao = null;
	}
}