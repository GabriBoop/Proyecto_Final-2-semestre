package co.edu.unbosque.model;

import java.time.LocalDate;

public class Carro extends Vehiculo {
	
	public Carro() {
		
	}

	public Carro(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		super(placa, tipo, propietario, vencimientoSoat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "CARRO";
	}

}
