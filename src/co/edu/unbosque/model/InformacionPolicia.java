package co.edu.unbosque.model;

import gov.police.data.controller.PoliceDataSystem;
import gov.police.data.model.Vehicle;

/**
 * Clase que consulta el sistema de información de la policía para conocer
 * el estado legal de un vehículo a partir de su placa.
 */
public class InformacionPolicia {
	private PoliceDataSystem sistemaPolicia;

	/**
	 * Constructor de la clase. Inicializa la conexión con el sistema de datos de la policía.
	 */
	public InformacionPolicia() {
		sistemaPolicia = PoliceDataSystem.init();
	}
	
	/**
	 * Consulta el estado de un vehículo en el sistema de la policía.
	 *
	 * @param placa Placa del vehículo a consultar.
	 * @return "LIMPIO", "INCAUTADO" o "ROBADO" según el estado del vehículo,
	 *         o "SIN INFORMACION" si no hay datos o el estado es desconocido.
	 */
	public String consultaPolicia(String placa){
		Vehicle v = null;
		String consulta ="";
		
		if (sistemaPolicia.getCarInfo(placa)==null) {
			return consulta="SIN INFORMACION";
		}else {
			v = sistemaPolicia.getCarInfo(placa.toUpperCase());
			
			if(v.getStatus() == null) return "SIN INFORMACION";
			
			switch(v.getStatus()) {
			        case CLEAN:
			            consulta = "LIMPIO";
			            break;
			        case SEIZED:
			            consulta = "INCAUTADO";
			            break;
			        case STOLEN:
			            consulta = "ROBADO";
			            break;
			        default:
			            consulta = "SIN INFORMACION";
			            break;
			        } 
			return consulta;	
		}
	}

}