package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Tarifa que cobra el tiempo de permanencia de un vehículo hora por hora. Cada
 * hora se cobra al valor diurno, con un recargo del 20% cuando la hora
 * corresponde a la jornada nocturna.
 */
public class TarifaPorHora extends Tarifa {

	/**
	 * Identificador de versión utilizado en la serialización de la clase.
	 */
	private static final long serialVersionUID = -2135317151198913947L;

	/**
	 * Valor cobrado por cada hora de la jornada diurna.
	 */
	protected static final double TARIFA_HORA_DIURNA = 5000.0;

	/**
	 * Calcula el costo total de la permanencia de un registro. Recorre cada hora
	 * completa entre el ingreso y la salida, cobrando la tarifa diurna y
	 * aplicándole un recargo del 20% a las horas de jornada nocturna. Si el tiempo
	 * transcurrido es menor a una hora, se cobra una hora mínima.
	 *
	 * @param registro Registro del vehículo, con sus horas de ingreso y salida.
	 * @return Valor total a pagar por el tiempo de permanencia.
	 */
	@Override
	public double calcularCosto(Registro registro) {
		long horas = ChronoUnit.HOURS.between(registro.getHoraIngreso(), registro.getHoraSalida());

		if (horas <= 0)
			horas = 1;

		double total = 0;
		LocalDateTime horaActual = registro.getHoraIngreso();
		for (int i = 0; i < horas; i++) {
			double tarifa = TARIFA_HORA_DIURNA;
			if (Jornada.de(horaActual.toLocalTime()) == Jornada.NOCTURNA)
				tarifa *= 1.20;
			total += tarifa;
			horaActual = horaActual.plusHours(1);
		}
		return total;
	}

}