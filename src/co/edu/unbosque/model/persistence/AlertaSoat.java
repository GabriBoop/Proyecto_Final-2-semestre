package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Vehiculo;

/**
 * Clase encargada de generar y almacenar en archivo de texto plano las
 * notificaciones tipo SMS dirigidas a los propietarios cuyos vehículos tienen
 * el SOAT próximo a vencer.
 */
public class AlertaSoat{
	
	/**
	 * Prefijo base del nombre del archivo de texto donde se almacena la
	 * notificación SMS generada.
	 */
	private final String NOMBRE_ARCHIVO_TEXTO = "sms";
	
	/**
	 * Constructor por defecto de la clase AlertaSoat.
	 */
	public AlertaSoat() {
		
	}
	
	/**
	 * Construye el mensaje de recordatorio con el nombre del propietario, la placa
	 * del vehículo y la fecha de vencimiento del SOAT, guardando el resultado en
	 * un archivo .txt mediante FileHandler.
	 *
	 * @param v Vehículo cuyo SOAT se encuentra próximo a vencer.
	 */
	public void mandarAlerta(Vehiculo v) {
		String contenido = "";
		contenido = "Hola "+v.getPropietario().getNombre()+", el SOAT de su vehiculo "+v.getPlaca()+" vence el: "+v.getVencimientoSoat()
				+ "\nRenuevelo pronto en cualquiera de los locales de aseguradoras "
				+ "del Centro Comercial: UEB y reciba un 5% de descuento.\n"
				+ "Muchas Gracias.";
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO+v.getPlaca()+".txt", contenido);
	}
	
	/**
	 * Obtiene el prefijo base configurado para el nombre del archivo de alerta SMS.
	 *
	 * @return Cadena de texto con el prefijo del archivo.
	 */
	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}
	
}

