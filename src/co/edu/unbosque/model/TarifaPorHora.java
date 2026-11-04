package co.edu.unbosque.model;

import java.time.temporal.ChronoUnit;

public class TarifaPorHora extends Tarifa {
	
	private static final long serialVersionUID = -2135317151198913947L;
	private static final double TARIFA_HORA_DIURNA = 5000.0;

	@Override
	public double calcularCosto(Registro registro) {
		long horas = ChronoUnit.HOURS.between(registro.getHoraIngreso(), registro.getHoraSalida());
		
		if(horas == 0) {
			horas = 1;
		}
		
		Jornada jornadaSalida = Jornada.de(registro.getHoraSalida().toLocalTime());
		
		double tarifa = TARIFA_HORA_DIURNA;
		
		if(jornadaSalida == Jornada.NOCTURNA) {
			tarifa = tarifa * 1.20;
		}
		return horas * tarifa;
	}

}
