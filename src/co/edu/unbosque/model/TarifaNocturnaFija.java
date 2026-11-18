package co.edu.unbosque.model;

import java.time.LocalDateTime;

/**
 * Tarifa para vehículos que optan por pagar la noche con un valor fijo. Las
 * horas de la jornada diurna se cobran a la tarifa por hora, y cada noche
 * transcurrida cuesta el 5% del valor de la mensualidad.
 */
public class TarifaNocturnaFija extends Tarifa {

	/**
	 * Identificador de versión utilizado en la serialización de la clase.
	 */
	private static final long serialVersionUID = 1814398006472262731L;

	/**
	 * Valor de la mensualidad, base para calcular el costo fijo de cada noche.
	 */
	private static final double VALOR_MENSUALIDAD = 200000.0;

	/**
	 * Calcula el costo total de la permanencia de un registro. Recorre hora por
	 * hora entre el ingreso y la salida: cada hora diurna (de 7:00 a 20:59) se
	 * cobra a la tarifa diurna por hora, y cada noche (desde las 21:00) se cobra
	 * una vez al 5% de la mensualidad. Si el vehículo ingresa durante la noche,
	 * esa primera noche también se cobra.
	 *
	 * @param registro Registro del vehículo, con sus horas de ingreso y salida.
	 * @return Valor total a pagar: horas diurnas más noches con tarifa fija.
	 */
	@Override
	public double calcularCosto(Registro registro) {
		LocalDateTime h = registro.getHoraIngreso();
		LocalDateTime salida = registro.getHoraSalida();

		int horasDia = 0;
		int noches = 0;

		if (h.getHour() >= 21 || h.getHour() < 7)
			noches = 1;

		while (h.isBefore(salida)) {

			int hora = h.getHour();

			if (hora >= 7 && hora < 21) {
				horasDia = horasDia + 1;
			}
			if (hora == 21 && !h.equals(registro.getHoraIngreso())) {
				noches = noches + 1;
			}
			h = h.plusHours(1);

		}

		return horasDia * TarifaPorHora.TARIFA_HORA_DIURNA + noches * VALOR_MENSUALIDAD * 0.05;
	}
}