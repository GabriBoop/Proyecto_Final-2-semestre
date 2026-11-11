package co.edu.unbosque.model;

import gov.police.data.controller.PoliceDataSystem;
import gov.police.data.model.Vehicle;

public class InformacionPolicia {
	private PoliceDataSystem sistemaPolicia;

	public InformacionPolicia() {
		sistemaPolicia = PoliceDataSystem.init();
	}
	
	public String consultaPolicia(String placa){
		Vehicle v = sistemaPolicia.getCarInfo(placa);
		String consulta ="";
		if(v.getStatus() == null) return "SIN INFORMACION";
		
		switch(v.getStatus()) {
		        case CLEAN:
		            consulta = "LIMPIO";
		            break;
		        case SEIZED:
		            consulta = "INCAUTADO";
		            break;
		        case STOLEN:
		            consulta = "INCAUTADO";
		            break;
		        default:
		            consulta = "SIN INFORMACION";
		            break;
		        } 
		return consulta;
	}

}