package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.time.LocalTime;

import co.edu.unbosque.model.Vehiculo;

/**
 * Clase encargada de generar y almacenar en archivo de texto plano las alertas
 * dirigidas a la Policía cuando un vehículo con reporte legal ingresa al
 * parqueadero.
 */
public class AlertaPolicia{
	
	/**
	 * Prefijo base del nombre del archivo de texto donde se almacena la alerta
	 * enviada.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "email-sent";
	
	/**
	 * Constructor por defecto de la clase AlertaPolicia
	 */
	public AlertaPolicia() {
		
	}
	
	/**
	 * Construye el cuerpo de la notificación con la placa del vehículo, su estado
	 * reportado y la fecha y hora actuales de ingreso, guardando el resultado en
	 * un archivo .txt mediante FileHandle.
	 *
	 * @param v Vehículo reportado que ingresó a las instalaciones.
	 * @param estado Estado legal o motivo por el cual el vehículo tiene reporte.
	 */
	public void mandarAlerta(Vehiculo v, String estado) {
		String contenido = "";
		contenido = "Para: denuncias@policia.gov.co\n"
				+ "Asunto: Alerta: vehiculo reportado ingreso al parqueadero\n\n"
				+ "Buen dia.\n\n"
				+ "Se informa que el vehiculo con placa " + v.getPlaca()
				+ ", reportado en su sistema como " + estado
				+ ", ingreso a las instalaciones del Centro Comercial.\n\n"
				+ "Fecha de ingreso: " +LocalDate.now()+ "\n"
				+ "Hora de ingreso: " + LocalTime.now() + "\n\n"
				+ "Cordialmente,\n"
				+ "Administracion del Parqueadero\n"
				+ "Centro Comercial: UEB.";
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO+v.getPlaca()+".txt", contenido);
	}
	
	/**
	 * Obtiene el prefijo base configurado para el nombre del archivo de alerta.
	 *
	 * @return Cadena de texto con el prefijo del archivo.
	 */
	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}
	
}
