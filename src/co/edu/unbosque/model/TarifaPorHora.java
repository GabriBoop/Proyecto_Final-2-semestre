package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Tarifa que cobra por cada hora de permanencia en el parqueadero.
 * Las horas con jornada nocturna tienen un recargo del 20% sobre la tarifa diurna.
 */
public class TarifaPorHora extends Tarifa {
	
	private static final long serialVersionUID = -2135317151198913947L;
	private static final double TARIFA_HORA_DIURNA = 5000.0;

	/**
	 * Calcula el costo de la estadía sumando el valor de cada hora completa.
	 * Si la permanencia es menor a una hora se cobra una hora. Cada hora que
	 * inicie en jornada nocturna se cobra con un recargo del 20%.
	 *
	 * @param registro Registro del vehículo con sus horas de ingreso y salida.
	 * @return Costo total de la estadía en pesos.
	 */
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