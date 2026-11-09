package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.*;

public class DataMapper {

	public static Carro convertirCarroDTOACarro(CarroDTO dto) {
		Carro entity = new Carro();
		entity.setPlaca(dto.getPlaca());
		entity.setPropietario(dto.getPropietario());
		entity.setTipo(dto.getTipo());
		entity.setVencimientoSoat(dto.getVencimientoSoat());
		

		return entity;
	}
	
	public static CarroDTO convertirCarroACarroDTO(Carro e) {
		CarroDTO entity = new CarroDTO();
		entity.setPlaca(e.getPlaca());
		entity.setPropietario(e.getPropietario());
		entity.setTipo(e.getTipo());
		entity.setVencimientoSoat(e.getVencimientoSoat());
		

		return entity;
	}
	public static Moto convertirMotoDTOAMoto(MotoDTO dto) {
		Moto entity = new Moto();
		entity.setPlaca(dto.getPlaca());
		entity.setPropietario(dto.getPropietario());
		entity.setTipo(dto.getTipo());
		entity.setVencimientoSoat(dto.getVencimientoSoat());
		

		return entity;
	}
	
	public static MotoDTO convertirCarroACarroDTO(Moto e) {
		MotoDTO entity = new MotoDTO();
		entity.setPlaca(e.getPlaca());
		entity.setPropietario(e.getPropietario());
		entity.setTipo(e.getTipo());
		entity.setVencimientoSoat(e.getVencimientoSoat());
		

		return entity;
	}
	
	public static Propietario convertirPropietarioDTOAPropietario(PropietarioDTO dto) {
		Propietario entity = new Propietario();
		entity.setNombre(dto.getNombre());
		entity.setTelefono(dto.getTelefono());
		entity.setDocumento(dto.getDocumento());		

		return entity;
	}
	
	public static PropietarioDTO convertirPropietarioAPropietarioDTO(Propietario e) {
		PropietarioDTO entity = new PropietarioDTO();
		entity.setNombre(e.getNombre());
		entity.setTelefono(e.getTelefono());
		entity.setDocumento(e.getDocumento());		

		return entity;
	}
}
