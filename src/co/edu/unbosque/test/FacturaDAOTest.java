package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;

public class FacturaDAOTest {

	static Factura facturaEntidad;
	static FacturaDAO dao;
	static String rutaOriginal;

	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		facturaEntidad = new Factura(1, "ABC-123", "Thomas", LocalDateTime.of(2026, 11, 20, 8, 0),
				LocalDateTime.of(2026, 11, 20, 10, 30), FormaDeCobro.HORA, 12000);
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(facturaEntidad.getNum() + " - " + facturaEntidad.getPlaca());
	}

	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("facturaDaoTest").toString());
		dao = new FacturaDAO();

		facturaEntidad = new Factura(2, "XYZ-789", "Paula", LocalDateTime.of(2027, 1, 15, 9, 0),
				LocalDateTime.of(2027, 1, 15, 11, 0), FormaDeCobro.FIJA, 8000);
	}

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

	@Test
	public void crearFactura() {
		System.out.println("Probando metodo crear...");
		FacturaDTO dto = DataMapper.convertirFacturaAFacturaDTO(facturaEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

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

	@Test
	public void eliminarFactura() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void eliminarFacturaIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

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

	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("XYZ-789"));
		assertTrue(contenido.contains("Paula"));
	}

	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin facturas...");
		assertEquals("", dao.mostrarTodo());
	}

	@Test
	public void eliminarFacturaIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirFacturaAFacturaDTO(facturaEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void eliminarFacturaListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void actualizarFacturaIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		FacturaDTO dtoNuevo = new FacturaDTO(3, "QWE-456", "Camila", LocalDateTime.of(2028, 5, 10, 7, 0),
				LocalDateTime.of(2028, 5, 10, 9, 0), FormaDeCobro.MENSUAL, 50000);
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

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

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		facturaEntidad = null;
	}

	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		facturaEntidad = null;
		dao = null;
	}
}