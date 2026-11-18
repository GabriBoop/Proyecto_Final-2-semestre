package co.edu.unbosque.model;

/**
 * Tarifa fija para vehículos que pasan la noche en el parqueadero.
 * El valor cobrado equivale al 5% del valor de una mensualidad, sin importar
 * el tiempo de permanencia.
 */
public class TarifaNocturnaFija extends Tarifa {
	
	private static final long serialVersionUID = 1814398006472262731L;
	private static final double VALOR_MENSUALIDAD = 200000.0;

	/**
	 * Calcula el costo fijo nocturno (5% del valor de la mensualidad).
	 *
	 * @param registro Registro del vehículo (no influye en el cálculo).
	 * @return Valor fijo de la tarifa nocturna en pesos.
	 */
	@Override
	public double calcularCosto(Registro registro) {
		// TODO Auto-generated method stub
		return VALOR_MENSUALIDAD * 0.05;
	}

}