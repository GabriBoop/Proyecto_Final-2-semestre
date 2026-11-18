package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TarifaPorHora extends Tarifa {
	
	private static final long serialVersionUID = -2135317151198913947L;
	private static final double TARIFA_HORA_DIURNA = 5000.0;

	@Override
	public double calcularCosto(Registro registro) {
    	long horas = ChronoUnit.HOURS.between(registro.getHoraIngreso(), registro.getHoraSalida());
    	if (horas <= 0) {
    	    horas = 1;
		}

    double total = 0;
   	LocalDateTime horaActual = registro.getHoraIngreso();
    	for (int i = 0; i < horas; i++) {
    	    double tarifa = TARIFA_HORA_DIURNA;
    	    if (Jornada.de(horaActual.toLocalTime()) == Jornada.NOCTURNA) tarifa *= 1.20;
   	     	total += tarifa;
    	    horaActual = horaActual.plusHours(1);
    	}
    	return total;
	}

}
