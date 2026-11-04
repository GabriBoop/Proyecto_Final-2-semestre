package co.edu.unbosque.model;

public class TarifaNocturnaFija extends Tarifa {
	
	private static final double VALOR_MENSUALIDAD = 200000.0;

	@Override
	public double calcularCosto(Registro registro) {
		// TODO Auto-generated method stub
		return VALOR_MENSUALIDAD * 0.05;
	}

}
