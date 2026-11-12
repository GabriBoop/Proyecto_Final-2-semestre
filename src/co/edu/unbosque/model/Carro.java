package co.edu.unbosque.model;

import java.time.LocalDate;


public class Carro extends Vehiculo {
	
	private static final long serialVersionUID = -7975916342477791276L;

	public Carro() {
		
	}

	public Carro(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat){
		super(placa, tipo, propietario, vencimientoSoat);
	}

	@Override
	public String getTipo() {
		return "CARRO";
	}

}
