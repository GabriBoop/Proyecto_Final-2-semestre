package co.edu.unbosque.model;

public class TarifaNocturnaFijaDTO extends Tarifa {
	
	private static final long serialVersionUID = 1814398006472262731L;
	private static final double VALOR_MENSUALIDAD = 200000.0;

	@Override
	public double calcularCosto(Registro registro) {
		// TODO Auto-generated method stub
		return VALOR_MENSUALIDAD * 0.05;
	}

}
