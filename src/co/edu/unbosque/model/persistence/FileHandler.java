package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	private static final String RUTA_POR_DEFECTO = "src/co/edu/unbosque/files/";
	private static String rutaBase = RUTA_POR_DEFECTO;

	private static File archivo;
	private static Scanner lector;
	private static PrintWriter escritor;
	//Escritura de serializado
	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
	//Lectura de serializado
	public static FileInputStream fis;
	public static ObjectInputStream ois;

	public static void setRutaBase(String ruta) {
		if (ruta == null || ruta.isEmpty()) {
			rutaBase = RUTA_POR_DEFECTO;
		} else {
			rutaBase = (ruta.endsWith("/") || ruta.endsWith("\\")) ? ruta : ruta + File.separator;
		}
	}

	public static String getRutaBase() {
		return rutaBase;
	}

	public static void crearYEscribirArchivo(String url, String contenido) {
		try {
			archivo = new File(rutaBase + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String abrirYLeerArchivo(String url) {
		String contenido = "";
		try {
			archivo = new File(rutaBase + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
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

	public static void crearYEscribirSerializado(String url, Object o) {
		try {
			archivo = new File(rutaBase + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(o);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo serializado.");
		}
	}

	public static Object abrirYLeerSerializado(String url) {
		try {
			archivo = new File(rutaBase + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
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