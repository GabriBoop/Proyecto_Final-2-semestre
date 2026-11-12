package co.edu.unbosque.model;

import java.time.LocalDate;
public class Moto extends Vehiculo{
	
	private static final long serialVersionUID = 9083767406550040881L;

	public Moto(){
		
	}

	public Moto(String placa, String tipo, Propietario propietario, LocalDate vencimientoSoat) {
		super(placa, tipo, propietario, vencimientoSoat);
	}

	@Override
	public String getTipo() {
		return "MOTO";
	}
	

}
