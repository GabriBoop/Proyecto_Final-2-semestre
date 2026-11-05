package co.edu.unbosque.model;

import java.time.LocalDate;

public class Moto extends Vehiculo{
	
	public Moto(){
		
	}

	public Moto(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		super(placa, tipo, propietario, vencimientoSoat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "MOTO";
	}
	

}
