package co.edu.unbosque.model;

import gov.police.data.controller.InternalSystemException;
import gov.police.data.controller.PoliceDataSystem;
import gov.police.data.model.Status;
import gov.police.data.model.Vehicle;

public class InformacionPolicia {
	private PoliceDataSystem sistemaPolicia;

	public InformacionPolicia() {
		sistemaPolicia = PoliceDataSystem.init();
	}
	
	public String consultaPolicia(String placa){
		Vehicle v = sistemaPolicia.getCarInfo(placa);
		String consulta ="";
		if(v.getStatus()==Status.CLEAN) {
			consulta = "LIMPIO";
		}else if (v.getStatus()==Status.SEIZED) {
			consulta = "INCAUTADO";
		}else if(v.getStatus()==Status.STOLEN) {
			consulta = "ROBADO";
		}else {
			consulta = "LIMPIO";
		}
		return consulta;
	}

}