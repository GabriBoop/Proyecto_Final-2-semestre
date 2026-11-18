package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.*;
import co.edu.unbosque.util.exceptions.PlacaInvalidaException;

/**
 * Clase utilitaria encargada de realizar la conversión (mapeo) bidireccional
 * entre las entidades del modelo y sus respectivos objetos de transferencia de
 * datos (DTO).
 */
public class DataMapper {

	/**
	 * Convierte un objeto CarroDTO en una entidad Carro.
	 *
	 * @param dto Objeto de transferencia de datos con la información del carro.
	 * @return Entidad Carro construida con los datos del DTO.
	 * @throws PlacaInvalidaException Si la placa contenida en el DTO no cumple con el formato válido.
	 */
	public static Carro convertirCarroDTOACarro(CarroDTO dto) throws PlacaInvalidaException {
		Carro entity = new Carro();
		entity.setPlaca(dto.getPlaca());
		entity.setPropietario(dto.getPropietario());
		entity.setTipo(dto.getTipo());
		entity.setVencimientoSoat(dto.getVencimientoSoat());

		return entity;
	}

	/**
	 * Convierte una entidad Carro en un objeto de transferencia CarroDTO.
	 *
	 * @param e Entidad Carro que se desea transformar.
	 * @return Objeto CarroDTO con los datos copiados de la entidad.
	 * @throws PlacaInvalidaException Si la placa de la entidad no cumple con el formato válido.
	 */
	public static CarroDTO convertirCarroACarroDTO(Carro e) throws PlacaInvalidaException {
		CarroDTO dto = new CarroDTO();
		dto.setPlaca(e.getPlaca());
		dto.setPropietario(e.getPropietario());
		dto.setTipo(e.getTipo());
		dto.setVencimientoSoat(e.getVencimientoSoat());

		return dto;
	}

	/**
	 * Convierte un objeto FacturaDTO en una entidad Factura.
	 *
	 * @param dto Objeto de transferencia de datos con la información de la factura.
	 * @return Entidad Factura construida con los datos del DTO.
	 */
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

	/**
	 * Convierte una entidad Factura en un objeto de transferencia FacturaDTO.
	 *
	 * @param e Entidad Factura que se desea transformar.
	 * @return Objeto FacturaDTO con los datos copiados de la entidad.
	 */
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

	/**
	 * Convierte un objeto MensualidadDTO en una entidad Mensualidad.
	 *
	 * @param dto Objeto de transferencia de datos con la información de la mensualidad.
	 * @return Entidad Mensualidad construida con los datos del DTO.
	 */
	public static Mensualidad convertirMensualidadDTOAMensualidad(MensualidadDTO dto) {
		Mensualidad entity = new Mensualidad();
		entity.setFechaInicio(dto.getFechaInicio());
		entity.setPropietario(dto.getPropietario());
		entity.setValor(dto.getValor());
		entity.setVehiculos(dto.getVehiculos());

		return entity;
	}

	/**
	 * Convierte una entidad Mensualidad en un objeto de transferencia MensualidadDTO.
	 *
	 * @param e Entidad Mensualidad que se desea transformar.
	 * @return Objeto MensualidadDTO con los datos copiados de la entidad.
	 */
	public static MensualidadDTO convertirMensualidadAMensualidadDTO(Mensualidad e) {
		MensualidadDTO dto = new MensualidadDTO();
		dto.setFechaInicio(e.getFechaInicio());
		dto.setPropietario(e.getPropietario());
		dto.setValor(e.getValor());
		dto.setVehiculos(e.getVehiculos());

		return dto;
	}

	/**
	 * Convierte un objeto MotoDTO en una entidad Moto.
	 *
	 * @param dto Objeto de transferencia de datos con la información de la moto.
	 * @return Entidad Moto construida con los datos del DTO.
	 * @throws PlacaInvalidaException Si la placa contenida en el DTO no cumple con el formato válido.
	 */
	public static Moto convertirMotoDTOAMoto(MotoDTO dto) throws PlacaInvalidaException {
		Moto entity = new Moto();
		entity.setPlaca(dto.getPlaca());
		entity.setPropietario(dto.getPropietario());
		entity.setTipo(dto.getTipo());
		entity.setVencimientoSoat(dto.getVencimientoSoat());

		return entity;
	}

	/**
	 * Convierte una entidad Moto en un objeto de transferencia MotoDTO.
	 *
	 * @param e Entidad Moto que se desea transformar.
	 * @return Objeto MotoDTO con los datos copiados de la entidad.
	 * @throws PlacaInvalidaException Si la placa de la entidad no cumple con el formato válido.
	 */
	public static MotoDTO convertiMotoAMotoDTO(Moto e) throws PlacaInvalidaException {
		MotoDTO dto = new MotoDTO();
		dto.setPlaca(e.getPlaca());
		dto.setPropietario(e.getPropietario());
		dto.setTipo(e.getTipo());
		dto.setVencimientoSoat(e.getVencimientoSoat());

		return dto;
	}

	/**
	 * Convierte un objeto PropietarioDTO en una entidad Propietario.
	 *
	 * @param dto Objeto de transferencia de datos con la información del propietario.
	 * @return Entidad Propietario construida con los datos del DTO.
	 */
	public static Propietario convertirPropietarioDTOAPropietario(PropietarioDTO dto) {
		Propietario entity = new Propietario();
		entity.setNombre(dto.getNombre());
		entity.setTelefono(dto.getTelefono());
		entity.setDocumento(dto.getDocumento());

		return entity;
	}

	/**
	 * Convierte una entidad Propietario en un objeto de transferencia PropietarioDTO.
	 *
	 * @param e Entidad Propietario que se desea transformar.
	 * @return Objeto PropietarioDTO con los datos copiados de la entidad.
	 */
	public static PropietarioDTO convertirPropietarioAPropietarioDTO(Propietario e) {
		PropietarioDTO dto = new PropietarioDTO();
		dto.setNombre(e.getNombre());
		dto.setTelefono(e.getTelefono());
		dto.setDocumento(e.getDocumento());

		return dto;
	}

	/**
	 * Convierte un objeto RegistroDTO en una entidad Registro.
	 *
	 * @param dto Objeto de transferencia de datos con la información del registro de ingreso/salida.
	 * @return Entidad Registro construida con los datos del DTO.
	 */
	public static Registro convertirRegistroDTOARegistro(RegistroDTO dto) {
		Registro entity = new Registro();
		entity.setHoraIngreso(dto.getHoraIngreso());
		entity.setHoraSalida(dto.getHoraSalida());
		entity.setActivo(dto.isActivo());
		entity.setPagaMensualidad(dto.isPagaMensualidad());
		entity.setTarifaAplicada(dto.getTarifaAplicada());
		entity.setVehiculo(dto.getVehiculo());

		return entity;
	}

	/**
	 * Convierte una entidad Registro en un objeto de transferencia RegistroDTO.
	 *
	 * @param e Entidad Registro que se desea transformar.
	 * @return Objeto RegistroDTO con los datos copiados de la entidad.
	 */
	public static RegistroDTO convertirRegistroARegistroDTO(Registro e) {
		RegistroDTO dto = new RegistroDTO();
		dto.setHoraIngreso(e.getHoraIngreso());
		dto.setHoraSalida(e.getHoraSalida());
		dto.setActivo(e.isActivo());
		dto.setPagaMensualidad(e.isPagaMensualidad());
		dto.setTarifaAplicada(e.getTarifaAplicada());
		dto.setVehiculo(e.getVehiculo());

		return dto;
	}

}


