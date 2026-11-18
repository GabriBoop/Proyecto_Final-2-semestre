package co.edu.unbosque.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import org.junit.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.exceptions.*;

/**
 * Pruebas unitarias (JUnit) de la clase MensualidadDAO.
 * Verifica la conversión entre Mensualidad y MensualidadDTO y las operaciones de persistencia
 * (crear, eliminar, actualizar, buscar y mostrar) usando un directorio temporal
 * para no modificar los archivos reales del sistema.
 * También prueba el registro de mensualidades a través de la clase Parqueadero
 * y las excepciones que este lanza ante datos inválidos.
 */
public class MensualidadDAOTest {

	/**
	 * Entidad de Mensualidad utilizada como dato de prueba.
	 */
	static Mensualidad mensualidadEntidad;
	/**
	 * DAO de mensualidades sometido a prueba.
	 */
	static MensualidadDAO dao;
	/**
	 * Ruta base original de los archivos, restaurada al terminar las pruebas.
	 */
	static String rutaOriginal;

	/**
	 * DAO de propietarios usado para armar el escenario del parqueadero.
	 */
	static PropietarioDAO propietarioDAO;
	/**
	 * DAO de carros usado para armar el escenario del parqueadero.
	 */
	static CarroDAO carroDAO;
	/**
	 * DAO de motos usado para armar el escenario del parqueadero.
	 */
	static MotoDAO motoDAO;
	/**
	 * DAO de registros usado para armar el escenario del parqueadero.
	 */
	static RegistroDAO registroDAO;
	/**
	 * DAO de facturas usado para armar el escenario del parqueadero.
	 */
	static FacturaDAO facturaDAO;
	/**
	 * Parqueadero utilizado para probar el registro de mensualidades.
	 */
	static Parqueadero parqueadero;

	/**
	 * Se ejecuta una sola vez antes de todas las pruebas.
	 * Guarda la ruta base original de los archivos y crea una entidad inicial de ejemplo,
	 * mostrando sus datos en consola.
	 */
	@BeforeClass
	public static void antesDeTodasLasPruebas() {
		rutaOriginal = FileHandler.getRutaBase();
		Propietario propietario = new Propietario("1032941791", "Thomas", "3001234567");
		mensualidadEntidad = new Mensualidad(propietario, 200000.0, LocalDate.of(2026, 11, 20));
		System.out.println("Iniciando pruebas unitarias...");
		System.out.println("Los datos iniciales son: ");
		System.out.println(mensualidadEntidad.getPropietario().getNombre() + " - " + mensualidadEntidad.getValor());
	}

	/**
	 * Se ejecuta antes de cada prueba. Redirige la ruta base a un directorio temporal nuevo
	 * para aislar los archivos, crea un MensualidadDAO limpio y reinicia la entidad con datos de prueba.
	 *
	 * @throws IOException si no se puede crear el directorio temporal.
	 */
	@Before
	public void antesDeCadaPrueba() throws IOException {
		System.out.println("Reseteando la información de la entidad...");
		FileHandler.setRutaBase(Files.createTempDirectory("mensualidadDaoTest").toString());
		dao = new MensualidadDAO();

		Propietario propietario = new Propietario("1000000001", "Paula", "3109876543");
		mensualidadEntidad = new Mensualidad(propietario, 200000.0, LocalDate.of(2027, 1, 15));
	}

	/**
	 * Arma el escenario necesario para probar el registro de mensualidades:
	 * crea los DAO, registra dos propietarios (Paula y Camila), cinco vehículos
	 * (tres carros y una moto de Paula, y un carro de Camila) e instancia el Parqueadero.
	 */
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

	/**
	 * Método auxiliar que registra una mensualidad a través del Parqueadero.
	 *
	 * @param documento Documento del propietario.
	 * @param placa Placa del vehículo a registrar.
	 * @param tipo Tipo de vehículo ("Carro" o "Moto").
	 * @throws Exception si el registro de la mensualidad falla.
	 */
	private void registrar(String documento, String placa, String tipo) throws Exception {
		parqueadero.registrarMensualidad(documento, "Paula", placa, tipo, propietarioDAO, carroDAO, motoDAO);
	}

	/**
	 * Verifica que la conversión de Mensualidad a MensualidadDTO con DataMapper conserve todos los atributos.
	 */
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

	/**
	 * Verifica que crear almacene una mensualidad en el DAO y que la lista quede con un elemento.
	 */
	@Test
	public void crearMensualidad() {
		System.out.println("Probando metodo crear...");
		MensualidadDTO dto = DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad);
		assertTrue(dao.crear(dto));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que crear con un dato nulo retorne false y no agregue elementos.
	 */
	@Test
	public void crearMensualidadNulaDevuelveFalse() {
		System.out.println("Probando crear con dato nulo...");
		assertFalse(dao.crear(null));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que la mensualidad creado se guarde en el archivo,
	 * comprobándolo al leerlo desde una nueva instancia de MensualidadDAO.
	 */
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

	/**
	 * Verifica que los vehículos asociados a la mensualidad también se guarden en el archivo.
	 */
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

	/**
	 * Verifica que eliminar con un índice válido borre la mensualidad y deje la lista vacía.
	 */
	@Test
	public void eliminarMensualidad() {
		System.out.println("Probando método eliminar...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		assertTrue(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con un índice negativo retorne false.
	 */
	@Test
	public void eliminarMensualidadIndiceNegativo() {
		System.out.println("Probando eliminar con índice inválido...");
		assertFalse(dao.eliminar(-1));
	}

	/**
	 * Verifica que eliminar con un índice fuera de rango retorne false
	 * y no modifique la lista.
	 */
	@Test
	public void eliminarMensualidadIndiceFueraDeRango() {
		System.out.println("Probando eliminar con índice fuera de rango...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		assertFalse(dao.eliminar(5));
		assertEquals(1, dao.darLista().size());
	}

	/**
	 * Verifica que eliminar con la lista vacía retorne false.
	 */
	@Test
	public void eliminarMensualidadListaVacia() {
		System.out.println("Probando eliminar con la lista vacía...");
		assertFalse(dao.eliminar(0));
		assertEquals(0, dao.darLista().size());
	}

	/**
	 * Verifica que actualizar reemplace los datos de la mensualidad en el índice indicado
	 * sin cambiar el tamaño de la lista.
	 */
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

	/**
	 * Verifica que actualizar con un índice negativo retorne false.
	 */
	@Test
	public void actualizarMensualidadIndiceNegativo() {
		System.out.println("Probando actualizar con índice negativo...");
		MensualidadDTO dtoNuevo = new MensualidadDTO(mensualidadEntidad.getPropietario(), 250000.0,
				LocalDate.of(2028, 5, 10));
		assertFalse(dao.actualizar(-1, dtoNuevo));
	}

	/**
	 * Verifica que actualizar con un índice fuera de rango retorne false
	 * y deje los datos originales intactos.
	 */
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

	/**
	 * Verifica que buscarIndicePorDocumento retorne la posición de la mensualidad
	 * del propietario, o -1 si el documento no tiene mensualidad.
	 */
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

	/**
	 * Verifica que se agregue a la mensualidad un vehículo del mismo propietario
	 * y que mismaPlaca lo reconozca sin distinguir mayúsculas.
	 */
	@Test
	public void agregarVehiculoDelMismoPropietario() {
		System.out.println("Probando agregar vehículo del propietario...");
		Carro carro = new Carro("XYZ-789", "CARRO", mensualidadEntidad.getPropietario(), LocalDate.of(2027, 6, 1));
		mensualidadEntidad.agregarVehiculo(carro);
		assertEquals(1, mensualidadEntidad.getVehiculos().size());
		assertTrue(mensualidadEntidad.mismaPlaca("xyz-789"));
	}

	/**
	 * Verifica que un vehículo de otro propietario no se agregue a la mensualidad.
	 */
	@Test
	public void agregarVehiculoDeOtroPropietarioNoSeAgrega() {
		System.out.println("Probando agregar vehículo de otro propietario...");
		Propietario otro = new Propietario("1000000002", "Camila", "3201112233");
		Carro carro = new Carro("QWE-456", "CARRO", otro, LocalDate.of(2027, 6, 1));
		mensualidadEntidad.agregarVehiculo(carro);
		assertEquals(0, mensualidadEntidad.getVehiculos().size());
	}

	/**
	 * Verifica que la mensualidad no supere el máximo de vehículos permitido (VEHICULOS_MAX).
	 */
	@Test
	public void agregarVehiculoRespetaElMaximo() {
		System.out.println("Probando el máximo de vehículos...");
		Propietario p = mensualidadEntidad.getPropietario();
		mensualidadEntidad.agregarVehiculo(new Carro("AAA-111", "CARRO", p, LocalDate.of(2027, 6, 1)));
		mensualidadEntidad.agregarVehiculo(new Carro("BBB-222", "CARRO", p, LocalDate.of(2027, 6, 1)));
		mensualidadEntidad.agregarVehiculo(new Carro("CCC-333", "CARRO", p, LocalDate.of(2027, 6, 1)));
		assertEquals(Mensualidad.VEHICULOS_MAX, mensualidadEntidad.getVehiculos().size());
	}

	/**
	 * Verifica que mostrarTodo incluya los datos de la mensualidad almacenado.
	 */
	@Test
	public void mostrarTodoIncluyeLosDatos() {
		System.out.println("Probando método mostrarTodo...");
		dao.crear(DataMapper.convertirMensualidadAMensualidadDTO(mensualidadEntidad));
		String contenido = dao.mostrarTodo();
		assertTrue(contenido.contains("Valor: 200000.0"));
		assertTrue(contenido.contains("Fecha de Inicio: 2027-01-15"));
	}

	/**
	 * Verifica que mostrarTodo retorne una cadena vacía cuando no hay mensualidades.
	 */
	@Test
	public void mostrarTodoListaVacia() {
		System.out.println("Probando mostrarTodo sin mensualidades...");
		assertEquals("", dao.mostrarTodo());
	}

	/**
	 * Verifica que registrar una mensualidad nueva la cree con el valor estándar y el vehículo
	 * indicado, reduzca en uno los cupos disponibles y que tieneMensualidad la reconozca.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que la mensualidad registrada a través del Parqueadero se guarde en el archivo.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
	@Test
	public void registrarMensualidadPersisteEnDisco() throws Exception {
		System.out.println("Probando que registrar mensualidad guarde en el archivo...");
		armarParqueadero();
		registrar("1000000001", "XYZ-789", "Carro");
		MensualidadDAO otroDao = new MensualidadDAO();
		assertEquals(1, otroDao.darLista().size());
		assertEquals("XYZ-789", otroDao.darLista().get(0).getVehiculos().get(0).getPlaca());
	}

	/**
	 * Verifica que se pueda registrar una mensualidad con una moto.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
	@Test
	public void registrarMensualidadConMoto() throws Exception {
		System.out.println("Probando registrar mensualidad con una moto...");
		armarParqueadero();
		registrar("1000000001", "QWE-456", "Moto");
		assertEquals(1, dao.darLista().size());
		assertEquals("QWE-456", dao.darLista().get(0).getVehiculos().get(0).getPlaca());
	}

	/**
	 * Verifica que un segundo vehículo del mismo propietario se agregue
	 * a su mensualidad existente en lugar de crear otra.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
	@Test
	public void registrarSegundoVehiculoDelMismoPropietario() throws Exception {
		System.out.println("Probando registrar un segundo vehículo del mismo propietario...");
		armarParqueadero();
		registrar("1000000001", "XYZ-789", "Carro");
		registrar("1000000001", "QWE-456", "Moto");
		assertEquals(1, dao.darLista().size());
		assertEquals(2, dao.darLista().get(0).getVehiculos().size());
	}

	/**
	 * Verifica que registrar un tercer vehículo del mismo propietario
	 * lance SobrecupoDeMensualidadesException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar un carro que pertenece a otro propietario
	 * lance PlacaDeOtroPropietarioException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar una moto que pertenece a otro propietario
	 * lance PlacaDeOtroPropietarioException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar con un propietario inexistente
	 * lance PropietarioNoExisteException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar una placa no registrada como vehículo
	 * lance PlacaNoEncontradaException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar una moto indicando el tipo "Carro"
	 * lance PlacaNoEncontradaException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar una placa con formato inválido
	 * lance PlacaInvalidaException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Verifica que registrar dos veces la misma placa
	 * lance PlacaYaRegistradaException.
	 *
	 * @throws Exception si ocurre un error durante la prueba.
	 */
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

	/**
	 * Se ejecuta después de cada prueba. Libera la referencia a la entidad de prueba.
	 */
	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizó una prueba. Limpiando entidad...");
		mensualidadEntidad = null;
		parqueadero = null;
	}

	/**
	 * Se ejecuta una vez al finalizar todas las pruebas.
	 * Restaura la ruta base original y libera las referencias estáticas.
	 */
	@AfterClass
	public static void despuesDeTodasLasPruebas() {
		System.out.println("Finalizaron todas las pruebas unitarias.");
		FileHandler.setRutaBase(rutaOriginal);
		mensualidadEntidad = null;
		dao = null;
	}
}