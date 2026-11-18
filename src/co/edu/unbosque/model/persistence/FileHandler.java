package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase utilitaria encargada de gestionar las operaciones de lectura y
 * escritura de archivos de texto plano y archivos binarios serializados en el
 * sistema.
 */
public class FileHandler {

	/**
	 * Ruta relativa por defecto del directorio donde se almacenan los archivos
	 * del sistema.
	 */
	private static final String RUTA_POR_DEFECTO = "files/";

	/**
	 * Ruta base actual utilizada para ubicar, leer y guardar los archivos.
	 */
	private static String rutaBase = RUTA_POR_DEFECTO;

	/**
	 * Referencia al archivo que se está manipulando en las operaciones de lectura o
	 * escritura.
	 */
	private static File archivo;

	/**
	 * Lector utilizado para extraer el contenido línea por línea de los archivos
	 * de texto plano.
	 */
	private static Scanner lector;

	/**
	 * Escritor utilizado para guardar contenido en los archivos de texto plano.
	 */
	private static PrintWriter escritor;

	/**
	 * Flujo de salida de bytes utilizado para escribir archivos binarios
	 * serializados.
	 */
	public static FileOutputStream fos;

	/**
	 * Flujo de salida de objetos utilizado para serializar instancias en archivos
	 * binarios.
	 */
	public static ObjectOutputStream oos;

	/**
	 * Flujo de entrada de bytes utilizado para leer archivos binarios
	 * serializados.
	 */
	public static FileInputStream fis;

	/**
	 * Flujo de entrada de objetos utilizado para deserializar instancias desde
	 * archivos binarios.
	 */
	public static ObjectInputStream ois;

	/**
	 * Establece la ruta base donde se gestionarán los archivos. Si la ruta
	 * recibida es nula o vacía, se restablece la ruta por defecto; de lo
	 * contrario, asegura que finalice con un separador de directorios.
	 *
	 * @param ruta Ruta del directorio base que se desea configurar.
	 */
	public static void setRutaBase(String ruta) {
		if (ruta == null || ruta.isEmpty()) {
			rutaBase = RUTA_POR_DEFECTO;
		} else {
			rutaBase = (ruta.endsWith("/") || ruta.endsWith("\\")) ? ruta : ruta + File.separator;
		}
	}

	/**
	 * Obtiene la ruta base configurada actualmente para la lectura y escritura de
	 * archivos.
	 *
	 * @return Cadena de texto con la ruta base actual.
	 */
	public static String getRutaBase() {
		return rutaBase;
	}

	/**
	 * Obtiene el archivo ubicado en la ruta base con el nombre indicado. Si las
	 * carpetas intermedias o el archivo no existen, los crea.
	 *
	 * @param url Nombre o ruta relativa del archivo dentro de la ruta base.
	 * @return Archivo listo para ser leído o escrito.
	 * @throws IOException Si ocurre un error al crear las carpetas o el archivo.
	 */
	private static File abrir(String url) throws IOException {
		File f = new File(rutaBase + url);
		if (f.getParentFile() != null) {
			f.getParentFile().mkdirs();
		}
		if (!f.exists()) {
			f.createNewFile();
		}
		return f;
	}

	/**
	 * Crea un archivo de texto plano en la ruta indicada si aún no existe y
	 * escribe en él el contenido proporcionado.
	 *
	 * @param url       Nombre o ruta relativa del archivo dentro de la ruta base.
	 * @param contenido Texto que se escribirá dentro del archivo.
	 */
	public static void crearYEscribirArchivo(String url, String contenido) {
		try {
			archivo = abrir(url);
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abre un archivo de texto plano en la ruta indicada (creándolo si no existe)
	 * y lee todo su contenido línea por línea.
	 *
	 * @param url Nombre o ruta relativa del archivo dentro de la ruta base.
	 * @return Cadena de texto con el contenido completo del archivo, o una cadena
	 *         vacía si ocurre un error de lectura.
	 */
	public String abrirYLeerArchivo(String url) {
		String contenido = "";
		try {
			archivo = abrir(url);
			lector = new Scanner(archivo);
			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}
			lector.close();
			return contenido;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Crea un archivo binario en la ruta indicada si aún no existe y almacena en
	 * él un objeto serializado.
	 *
	 * @param url Nombre o ruta relativa del archivo serializado dentro de la ruta base.
	 * @param o   Objeto serializable que se desea guardar en el archivo.
	 */
	public static void crearYEscribirSerializado(String url, Object o) {
		try {
			archivo = abrir(url);
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo serializado.");
		}
	}

	/**
	 * Abre un archivo binario en la ruta indicada (creándolo si no existe) y
	 * deserializa el objeto almacenado en su interior.
	 *
	 * @param url Nombre o ruta relativa del archivo serializado dentro de la ruta base.
	 * @return Objeto deserializado leído desde el archivo, o null si el archivo
	 *         está vacío o ocurre un error durante la lectura.
	 */
	public static Object abrirYLeerSerializado(String url) {
		try {
			archivo = abrir(url);
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			ois.close();
			fis.close();
			return o;
		} catch (IOException e) {
			System.out.println("Error al abrir y leer el archivo serializado.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error al comprender el contenido del archivo serializado.");
		}
		return null;
	}

}