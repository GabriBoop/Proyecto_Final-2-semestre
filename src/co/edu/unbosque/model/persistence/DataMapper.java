package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.*;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;

public class DataMapper {

	public static Carro convertirCarroDTOACarro(CarroDTO dto) throws PlacaInvalidaException {
		Carro entity = new Carro();
		entity.setPlaca(dto.getPlaca());
		entity.setPropietario(dto.getPropietario());
		entity.setTipo(dto.getTipo());
		entity.setVencimientoSoat(dto.getVencimientoSoat());
		

		return entity;
	}
	
	public static CarroDTO convertirCarroACarroDTO(Carro e) throws PlacaInvalidaException {
		CarroDTO dto = new CarroDTO();
		dto.setPlaca(e.getPlaca());
		dto.setPropietario(e.getPropietario());
		dto.setTipo(e.getTipo());
		dto.setVencimientoSoat(e.getVencimientoSoat());
		

		return dto;
	}
	
	public static Factura convertirFacturaDTOAFactura(FacturaDTO dto) {
		Factura entity = new Factura();
		entity.setFormaDeCobro(dto.getFormaDeCobro());
		entity.setHoraIngreso(dto.getHoraIngreso());
		entity.setHoraSalida(dto.getHoraSalida());
		entity.setNombrePropietario(dto.getNombrePropietario());
		entity.setNum(dto.getNum());
		entity.setPlaca(dto.getPlaca());
		entity.setValor(dto.getValor());
		

		return entity;
	}
	
	public static FacturaDTO convertirFacturaAFacturaDTO(Factura e) {
		FacturaDTO dto = new FacturaDTO();
		dto.setFormaDeCobro(e.getFormaDeCobro());
		dto.setHoraIngreso(e.getHoraIngreso());
		dto.setHoraSalida(e.getHoraSalida());
		dto.setNombrePropietario(e.getNombrePropietario());
		dto.setNum(e.getNum());
		dto.setPlaca(e.getPlaca());
		dto.setValor(e.getValor());
		
		return dto;
	}
	
	public static Mensualidad convertirMensualidadDTOAMensualidad(MensualidadDTO dto) {
		Mensualidad entity = new Mensualidad();
		entity.setFechaInicio(dto.getFechaInicio());
		entity.setPropietario(dto.getPropietario());
		entity.setValor(dto.getValor());
		entity.setVehiculos(dto.getVehiculos());

		return entity;
	}
	
	public static MensualidadDTO convertirMensualidadAMensualidadDTO(Mensualidad e) {
		MensualidadDTO dto = new MensualidadDTO();
		dto.setFechaInicio(e.getFechaInicio());
		dto.setPropietario(e.getPropietario());
		dto.setValor(e.getValor());
		dto.setVehiculos(e.getVehiculos());

		return dto;
	}
	
	public static Moto convertirMotoDTOAMoto(MotoDTO dto) throws PlacaInvalidaException {
		Moto entity = new Moto();
		entity.setPlaca(dto.getPlaca());
		entity.setPropietario(dto.getPropietario());
		entity.setTipo(dto.getTipo());
		entity.setVencimientoSoat(dto.getVencimientoSoat());
		

		return entity;
	}
	
	public static MotoDTO convertirCarroACarroDTO(Moto e) throws PlacaInvalidaException {
		MotoDTO dto = new MotoDTO();
		dto.setPlaca(e.getPlaca());
		dto.setPropietario(e.getPropietario());
		dto.setTipo(e.getTipo());
		dto.setVencimientoSoat(e.getVencimientoSoat());
		

		return dto;
	}
	
	public static Propietario convertirPropietarioDTOAPropietario(PropietarioDTO dto) {
		Propietario entity = new Propietario();
		entity.setNombre(dto.getNombre());
		entity.setTelefono(dto.getTelefono());
		entity.setDocumento(dto.getDocumento());		

		return entity;
	}
	
	public static PropietarioDTO convertirPropietarioAPropietarioDTO(Propietario e) {
		PropietarioDTO dto = new PropietarioDTO();
		dto.setNombre(e.getNombre());
		dto.setTelefono(e.getTelefono());
		dto.setDocumento(e.getDocumento());		

		return dto;
	}
	
	public static Registro convertirRegistroDTOARegistro(RegistroDTO dto) {
		Registro entity = new Registro();
		entity.setHoraIngreso(dto.getHoraIngreso());
		entity.setHoraSalida(dto.getHoraSalida());
		entity.setPagaMensualidad(dto.isPagaMensualidad());
		entity.setTarifaAplicada(dto.getTarifaAplicada());
		entity.setVehiculo(dto.getVehiculo());

		return entity;
	}
	
	public static RegistroDTO convertirRegistroARegistroDTO(Registro e) {
		RegistroDTO dto = new RegistroDTO();
		dto.setHoraIngreso(e.getHoraIngreso());
		dto.setHoraSalida(e.getHoraSalida());
		dto.setPagaMensualidad(e.isPagaMensualidad());
		dto.setTarifaAplicada(e.getTarifaAplicada());
		dto.setVehiculo(e.getVehiculo());

		return dto;
	}
	
	
	
}
