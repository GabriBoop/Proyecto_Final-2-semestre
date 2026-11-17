package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;

public class PropietarioDAOTest {

	static Propietario propietarioEntidad;
	static PropietarioDAO dao;
	static String rutaOriginal;

	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		propietarioEntidad = new Propietario("1032941791", "Thomas", "3001234567");
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(propietarioEntidad.getDocumento() + " - " + propietarioEntidad.getNombre());
	}

	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("propietarioDaoTest").toString());
		dao = new PropietarioDAO();

		propietarioEntidad = new Propietario("1000000001", "Paula", "3109876543");
	}

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

	@Test
	public void crearPropietario() {
		System.out.println("Probando metodo crear...");
		PropietarioDTO dto = DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

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

	@Test
	public void eliminarPropietario() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void eliminarPropietarioIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	@Test
	public void eliminarPropietarioIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void eliminarPropietarioListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

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

	@Test
	public void actualizarPropietarioIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		PropietarioDTO dtoNuevo = new PropietarioDTO("1000000002", "Camila", "3201112233");
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	@Test
	public void actualizarPropietarioIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		PropietarioDTO dtoNuevo = new PropietarioDTO("1000000002", "Camila", "3201112233");
		assertFalse(dao.actualizar(5, dtoNuevo));
		assertEquals("1000000001", dao.darLista().get(0).getDocumento());
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void buscarPropietarioPorDocumento() {
		System.out.println("Probando método buscar...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		Propietario encontrado = dao.buscarPorDocumento("1000000001");
		assertNotNull(encontrado);
		assertEquals("Paula", encontrado.getNombre());
		assertNull(dao.buscarPorDocumento("9999999999"));
	}

	@Test
	public void existeDocumento() {
		System.out.println("Probando método existeDocumento...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		assertTrue(dao.existeDocumento("1000000001"));
		assertFalse(dao.existeDocumento("9999999999"));
	}

	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirPropietarioAPropietarioDTO(propietarioEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("1000000001"));
		assertTrue(contenido.contains("Paula"));
		assertTrue(contenido.contains("3109876543"));
	}

	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin propietarios...");
		assertEquals("", dao.mostrarTodo());
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		propietarioEntidad = null;
	}

	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		propietarioEntidad = null;
		dao = null;
	}
}