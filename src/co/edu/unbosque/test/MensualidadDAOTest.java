package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.*;

public class MensualidadDAOTest {

	static Mensualidad mensualidadEntidad;
	static MensualidadDAO dao;
	static String rutaOriginal;

	static PropietarioDAO propietarioDAO;
	static CarroDAO carroDAO;
	static MotoDAO motoDAO;
	static RegistroDAO registroDAO;
	static FacturaDAO facturaDAO;
	static Parqueadero parqueadero;

	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		Propietario propietario = new Propietario("1032941791", "Thomas", "3001234567");
		mensualidadEntidad = new Mensualidad(propietario, 200000.0, LocalDate.of(2026, 11, 20));
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(mensualidadEntidad.getPropietario().getNombre() + " - " + mensualidadEntidad.getValor());
	}

	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("mensualidadDaoTest").toString());
		dao = new MensualidadDAO();

		Propietario propietario = new Propietario("1000000001", "Paula", "3109876543");
		mensualidadEntidad = new Mensualidad(propietario, 200000.0, LocalDate.of(2027, 1, 15));
	}

	private void armarParqueadero() {
		propietarioDAO = new PropietarioDAO();
		carroDAO = new CarroDAO();
		motoDAO = new MotoDAO();
		registroDAO = new RegistroDAO();
		facturaDAO = new FacturaDAO();

		propietarioDAO.crear(new PropietarioDTO("1000000001", "Paula", "3109876543"));
		propietarioDAO.crear(new PropietarioDTO("1000000002", "Camila", "3201112233"));
		Propietario paula = propietarioDAO.buscarPorDocumento("1000000001");
		Propietario camila = propietarioDAO.buscarPorDocumento("1000000002");

		LocalDate soat = LocalDate.of(2030, 6, 1);
		carroDAO.crear(new CarroDTO("XYZ-789", "CARRO", paula, soat));
		carroDAO.crear(new CarroDTO("AAA-111", "CARRO", paula, soat));
		carroDAO.crear(new CarroDTO("CCC-333", "CARRO", paula, soat));
		carroDAO.crear(new CarroDTO("CAM-001", "CARRO", camila, soat));
		motoDAO.crear(new MotoDTO("QWE-456", "MOTO", paula, soat));

		parqueadero = new Parqueadero(facturaDAO, dao, registroDAO);
	}

	private void registrar(String documento, String placa, String tipo) throws Exception {
		parqueadero.registrarMensualidad(documento, "Paula", placa, tipo, propietarioDAO, carroDAO, motoDAO);
	}

	@Test
	public void comprobarConversionEntidadDTO() {
		System.out.println("Iniciando prueba de conversión...");
		MensualidadDTO dto = DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad);
		boolean siEsIgual = true;
		if (!(mensualidadEntidad.getPropietario() == dto.getPropietario())) {
			siEsIgual = false;
		}
		if (!(mensualidadEntidad.getValor() == dto.getValor())) {
			siEsIgual = false;
		}
		if (!(mensualidadEntidad.getFechaInicio().equals(dto.getFechaInicio()))) {
			siEsIgual = false;
		}
		if (!(mensualidadEntidad.getVehiculos().size() == dto.getVehiculos().size())) {
			siEsIgual = false;
		}
		assertTrue(siEsIgual);
	}

	@Test
	public void crearMensualidad() {
		System.out.println("Probando metodo crear...");
		MensualidadDTO dto = DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void crearMensualidadNulaDevuelveFalse() {
		System.out.println("Probando crear con dato nulo...");
		assertFalse(dao.crear(null));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void crearMensualidadPersisteEnDisco() {
		System.out.println("Probando que crear guarde en el archivo...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		MensualidadDAO otroDao = new MensualidadDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("1000000001", otroDao.darLista().get(0).getPropietario().getDocumento());
		assertEquals(200000.0, otroDao.darLista().get(0).getValor(), 0.001);
		assertEquals(LocalDate.of(2027, 1, 15), otroDao.darLista().get(0).getFechaInicio());
	}

	@Test
	public void crearMensualidadConVehiculoPersisteEnDisco() {
		System.out.println("Probando que los vehículos de la mensualidad se guarden...");
		Carro carro = new Carro("XYZ-789", "CARRO", mensualidadEntidad.getPropietario(), LocalDate.of(2027, 6, 1));
		mensualidadEntidad.agregarVehiculo(carro);
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		MensualidadDAO otroDao = new MensualidadDAO();
		assertEquals(1, otroDao.darLista().get(0).getVehiculos().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getVehiculos().get(0).getPlaca());
	}

	@Test
	public void eliminarMensualidad() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void eliminarMensualidadIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	@Test
	public void eliminarMensualidadIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void eliminarMensualidadListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	@Test
	public void actualizarMensualidad() {
		System.out.println("Probando método actualizar...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		Propietario otro = new Propietario("1000000002", "Camila", "3201112233");
		MensualidadDTO dtoNuevo = new MensualidadDTO(otro, 250000.0, LocalDate.of(2028, 5, 10));
		assertTrue(dao.actualizar(0, dtoNuevo));
		assertEquals("1000000002", dao.darLista().get(0).getPropietario().getDocumento());
		assertEquals(250000.0, dao.darLista().get(0).getValor(), 0.001);
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void actualizarMensualidadIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		MensualidadDTO dtoNuevo = new MensualidadDTO(mensualidadEntidad.getPropietario(), 250000.0,
				LocalDate.of(2028, 5, 10));
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	@Test
	public void actualizarMensualidadIndiceFueraDeRango() {
		System.out.println("Probando actualizar con índice fuera de rango...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		MensualidadDTO dtoNuevo = new MensualidadDTO(mensualidadEntidad.getPropietario(), 250000.0,
				LocalDate.of(2028, 5, 10));
		assertFalse(dao.actualizar(5, dtoNuevo));
		assertEquals(200000.0, dao.darLista().get(0).getValor(), 0.001);
		assertEquals(1, dao.darLista().size());
	}

	@Test
	public void buscarIndicePorDocumento() {
		System.out.println("Probando método buscar...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		Propietario otro = new Propietario("1000000002", "Camila", "3201112233");
		dao.crear(new MensualidadDTO(otro, 200000.0, LocalDate.of(2027, 2, 1)));
		assertEquals(0, dao.buscarIndicePorDocumento("1000000001"));
		assertEquals(1, dao.buscarIndicePorDocumento("1000000002"));
		assertEquals(-1, dao.buscarIndicePorDocumento("9999999999"));
	}

	@Test
	public void agregarVehiculoDelMismoPropietario() {
		System.out.println("Probando agregar vehículo del propietario...");
		Carro carro = new Carro("XYZ-789", "CARRO", mensualidadEntidad.getPropietario(), LocalDate.of(2027, 6, 1));
		mensualidadEntidad.agregarVehiculo(carro);
		assertEquals(1, mensualidadEntidad.getVehiculos().size());
		assertTrue(mensualidadEntidad.mismaPlaca("xyz-789"));
	}

	@Test
	public void agregarVehiculoDeOtroPropietarioNoSeAgrega() {
		System.out.println("Probando agregar vehículo de otro propietario...");
		Propietario otro = new Propietario("1000000002", "Camila", "3201112233");
		Carro carro = new Carro("QWE-456", "CARRO", otro, LocalDate.of(2027, 6, 1));
		mensualidadEntidad.agregarVehiculo(carro);
		assertEquals(0, mensualidadEntidad.getVehiculos().size());
	}

	@Test
	public void agregarVehiculoRespetaElMaximo() {
		System.out.println("Probando el máximo de vehículos...");
		Propietario p = mensualidadEntidad.getPropietario();
		mensualidadEntidad.agregarVehiculo(new Carro("AAA-111", "CARRO", p, LocalDate.of(2027, 6, 1)));
		mensualidadEntidad.agregarVehiculo(new Carro("BBB-222", "CARRO", p, LocalDate.of(2027, 6, 1)));
		mensualidadEntidad.agregarVehiculo(new Carro("CCC-333", "CARRO", p, LocalDate.of(2027, 6, 1)));
		assertEquals(Mensualidad.VEHICULOS_MAX, mensualidadEntidad.getVehiculos().size());
	}

	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("Valor: 200000.0"));
		assertTrue(contenido.contains("Fecha de Inicio: 2027-01-15"));
	}

	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin mensualidades...");
		assertEquals("", dao.mostrarTodo());
	}

	@Test
	public void registrarMensualidadNueva() throws Exception {
		System.out.println("Probando registrar una mensualidad nueva...");
		armarParqueadero();
		int espaciosAntes = parqueadero.espaciosDisponiblesMensualidad();
		registrar("1000000001", "XYZ-789", "Carro");
		assertEquals(1, dao.darLista().size());
		assertEquals("1000000001", dao.darLista().get(0).getPropietario().getDocumento());
		assertEquals(Mensualidad.VALOR_MENSUALIDAD, dao.darLista().get(0).getValor(), 0.001);
		assertEquals(1, dao.darLista().get(0).getVehiculos().size());
		assertEquals("XYZ-789", dao.darLista().get(0).getVehiculos().get(0).getPlaca());
		assertEquals(espaciosAntes - 1, parqueadero.espaciosDisponiblesMensualidad());
		assertTrue(parqueadero.tieneMensualidad("xyz-789"));
		assertFalse(parqueadero.tieneMensualidad("AAA-111"));
	}

	@Test
	public void registrarMensualidadPersisteEnDisco() throws Exception {
		System.out.println("Probando que registrar mensualidad guarde en el archivo...");
		armarParqueadero();
		registrar("1000000001", "XYZ-789", "Carro");
		MensualidadDAO otroDao = new MensualidadDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getVehiculos().get(0).getPlaca());
	}

	@Test
	public void registrarMensualidadConMoto() throws Exception {
		System.out.println("Probando registrar mensualidad con una moto...");
		armarParqueadero();
		registrar("1000000001", "QWE-456", "Moto");
		assertEquals(1, dao.darLista().size());
		assertEquals("QWE-456", dao.darLista().get(0).getVehiculos().get(0).getPlaca());
	}

	@Test
	public void registrarSegundoVehiculoDelMismoPropietario() throws Exception {
		System.out.println("Probando registrar un segundo vehículo del mismo propietario...");
		armarParqueadero();
		registrar("1000000001", "XYZ-789", "Carro");
		registrar("1000000001", "QWE-456", "Moto");
		assertEquals(1, dao.darLista().size());
		assertEquals(2, dao.darLista().get(0).getVehiculos().size());
	}

	@Test
	public void registrarTercerVehiculoLanzaSobrecupo() throws Exception {
		System.out.println("Probando registrar un tercer vehículo...");
		armarParqueadero();
		registrar("1000000001", "XYZ-789", "Carro");
		registrar("1000000001", "AAA-111", "Carro");
		try {
			registrar("1000000001", "CCC-333", "Carro");
			fail("Debio lanzar SobrecupoDeMensualidadesException");
		} catch (SobrecupoDeMensualidadesException e) {
			assertEquals(2, dao.darLista().get(0).getVehiculos().size());
		}
	}

	@Test
	public void registrarPlacaDeOtroPropietarioLanzaExcepcion() throws Exception {
		System.out.println("Probando registrar una placa que es de otro propietario...");
		armarParqueadero();
		try {
			registrar("1000000002", "XYZ-789", "Carro");
			fail("Debio lanzar PlacaDeOtroPropietarioException");
		} catch (PlacaDeOtroPropietarioException e) {
			assertTrue(e.getMessage().contains("otro Propietario"));
			assertEquals(0, dao.darLista().size());
			assertFalse(parqueadero.tieneMensualidad("XYZ-789"));
		}
	}

	@Test
	public void registrarPlacaDeOtroPropietarioConMoto() throws Exception {
		System.out.println("Probando registrar una moto que es de otro propietario...");
		armarParqueadero();
		try {
			registrar("1000000002", "QWE-456", "Moto");
			fail("Debio lanzar PlacaDeOtroPropietarioException");
		} catch (PlacaDeOtroPropietarioException e) {
			assertEquals(0, dao.darLista().size());
		}
	}

	@Test
	public void registrarPropietarioInexistenteLanzaExcepcion() throws Exception {
		System.out.println("Probando registrar con un propietario que no existe...");
		armarParqueadero();
		try {
			registrar("9999999999", "XYZ-789", "Carro");
			fail("Debio lanzar PropietarioNoExisteException");
		} catch (PropietarioNoExisteException e) {
			assertEquals(0, dao.darLista().size());
		}
	}

	@Test
	public void registrarPlacaNoEncontradaLanzaExcepcion() throws Exception {
		System.out.println("Probando registrar una placa que no existe...");
		armarParqueadero();
		try {
			registrar("1000000001", "ZZZ-999", "Carro");
			fail("Debio lanzar PlacaNoEncontradaException");
		} catch (PlacaNoEncontradaException e) {
			assertEquals(0, dao.darLista().size());
		}
	}

	@Test
	public void registrarPlacaConTipoEquivocadoLanzaExcepcion() throws Exception {
		System.out.println("Probando registrar una moto indicando tipo carro...");
		armarParqueadero();
		try {
			registrar("1000000001", "QWE-456", "Carro");
			fail("Debio lanzar PlacaNoEncontradaException");
		} catch (PlacaNoEncontradaException e) {
			assertEquals(0, dao.darLista().size());
		}
	}

	@Test
	public void registrarPlacaInvalidaLanzaExcepcion() throws Exception {
		System.out.println("Probando registrar una placa con formato inválido...");
		armarParqueadero();
		try {
			registrar("1000000001", "123-ABC", "Carro");
			fail("Debio lanzar PlacaInvalidaException");
		} catch (PlacaInvalidaException e) {
			assertEquals(0, dao.darLista().size());
		}
	}

	@Test
	public void registrarPlacaYaRegistradaLanzaExcepcion() throws Exception {
		System.out.println("Probando registrar dos veces la misma placa...");
		armarParqueadero();
		registrar("1000000001", "XYZ-789", "Carro");
		try {
			registrar("1000000001", "XYZ-789", "Carro");
			fail("Debio lanzar PlacaYaRegistradaException");
		} catch (PlacaYaRegistradaException e) {
			assertEquals(1, dao.darLista().get(0).getVehiculos().size());
		}
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		mensualidadEntidad = null;
		parqueadero = null;
	}

	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		mensualidadEntidad = null;
		dao = null;
	}
}