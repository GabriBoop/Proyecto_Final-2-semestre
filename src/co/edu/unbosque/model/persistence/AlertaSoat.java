package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Vehiculo;


public class AlertaSoat{
	
	private final String NOMBRE_ARCHIVO_TEXTO = "sms";
	
	public AlertaSoat() {
		
	}

	public void mandarAlerta(Vehiculo v) {
		String contenido = "";
		contenido = "Hola"+v.getPropietario().getNombre()+", el SOAT de su vehiculo "+v.getPlaca()+" vence el: "+v.getVencimientoSoat()
				+ " Renuevelo pronto en cualquiera de los locales de aseguradoras "
				+ "del Centro Comercial y reciba un 5% de descuento.";
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO+v.getPlaca()+".txt", contenido);
	}

	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}
	
}

