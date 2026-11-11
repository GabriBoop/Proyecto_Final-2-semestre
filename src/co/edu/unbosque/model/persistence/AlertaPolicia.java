package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.time.LocalTime;

import co.edu.unbosque.model.Vehiculo;


public class AlertaPolicia{
	
	private final String NOMBRE_ARCHIVO_TEXTO = "email-sent";
	
	public AlertaPolicia() {
		
	}

	public void mandarAlerta(Vehiculo v, String estado) {
		String contenido = "";
		contenido = "Para: denuncias@policia.gov.co\n"
				+ "Asunto: Alerta: vehiculo reportado ingreso al parqueadero\n\n"
				+ "Buen dia,\n\n"
				+ "Se informa que el vehiculo con placa " + v.getPlaca()
				+ ", reportado en su sistema como " + estado.toLowerCase()
				+ ", ingreso a las instalaciones del Centro Comercial.\n\n"
				+ "Fecha de ingreso: " +LocalDate.now()+ "\n"
				+ "Hora de ingreso: " + LocalTime.now() + "\n\n"
				+ "Cordialmente,\n"
				+ "Administracion del Parqueadero\n"
				+ "Centro Comercial";
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO+v.getPlaca()+".txt", contenido);
	}

	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}
	
}