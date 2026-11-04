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
		
		int horaSalida = registro.getHoraSalida().getHour();
		boolean estanciaNoche = (horaSalida >= 21 || horaSalida < 7);
		
		double tarifa = TARIFA_HORA_DIURNA;
		
		if(estanciaNoche) {
			tarifa = tarifa * 1.20;
		}
		return horas * tarifa;
	}

}
