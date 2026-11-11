package co.edu.unbosque.model.persistence;


import java.util.ArrayList;

import co.edu.unbosque.model.*;


public class FacturaDAO implements DAO<Factura,FacturaDTO>{
	
	private ArrayList<Factura> listaFacturas;
	private final String NOMBRE_ARCHIVO_TEXTO = "Factura.csv";
	private final String NOMBRE_ARCHIVO_SERIALIZADO = "Factura.bin";
	
	public FacturaDAO() {
		setListaFacturas(new ArrayList<>());
		leerSerializado();
	}
	@Override
	public void crear(FacturaDTO D) {
		// TODO Auto-generated method stub
		listaFacturas.add(DataMapper.convertirFacturaDTOAFactura(D));
		escribirArchivo();
		escribirArchivoSerializado();
		
	}

	@Override
	public boolean eliminar(int index) {
		if (index >= 0) {
			listaFacturas.remove(index);
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean actualizar(int index, FacturaDTO datoActualizado) {
		// TODO Auto-generated method stub
		if (index >= 0) {
			listaFacturas.set(index, DataMapper.convertirFacturaDTOAFactura(datoActualizado));
			escribirArchivo();
			escribirArchivoSerializado();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String mostrarTodo() {
		String contenido = "";
		int posicion = 0;

		for (Factura f: listaFacturas) {
			contenido  += "Posicion en la lista:"+ posicion+"\n";
			contenido += "Nombre: "+f.getNombrePropietario()+"\n";
			contenido += "Numero de factura: "+f.getNum()+"\n";
			contenido += "Placa: "+f.getPlaca()+"\n";
			contenido += "Forma de Cobro: "+f.getFormaDeCobro()+"\n";
			contenido += "Hora de ingreso: "+f.getHoraIngreso()+"\n";
			contenido += "Hora de salida: "+f.getHoraSalida()+"\n";
			contenido += "Valor Total: "+f.getValor();

			posicion++;

		}
		return contenido;
	}

	@Override
	public ArrayList<Factura> darLista() {
		// TODO Auto-generated method stub
		return listaFacturas;
	}
	public void escribirArchivo() {
		String contenido = "";
		for (Factura f : listaFacturas) {
			contenido += f.getNombrePropietario()+";";
			contenido += f.getNum()+";";
			contenido += f.getPlaca() +";";
			contenido += f.getFormaDeCobro()+";";
			contenido += f.getHoraIngreso()+";";
			contenido += f.getHoraSalida()+";";
			contenido += f.getValor()+";";
		}
		FileHandler.crearYEscribirArchivo(NOMBRE_ARCHIVO_TEXTO, contenido);
	}
	
	public void escribirArchivoSerializado() {
		FileHandler.crearYEscribirSerializado(NOMBRE_ARCHIVO_SERIALIZADO, listaFacturas);
	}

	@SuppressWarnings("unchecked")
	public void leerSerializado() {
		Object o = FileHandler.abrirYLeerSerializado(NOMBRE_ARCHIVO_SERIALIZADO);
		if (o == null) {
			// archivo nuevo o vacio: se parte de una lista vacia
			listaFacturas = new ArrayList<>();
		} else {
			listaFacturas = (ArrayList<Factura>) o;
		}
	}
	
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}


	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}


	public String getNOMBRE_ARCHIVO_TEXTO() {
		return NOMBRE_ARCHIVO_TEXTO;
	}


	public String getNOMBRE_ARCHIVO_SERIALIZADO() {
		return NOMBRE_ARCHIVO_SERIALIZADO;
	}
	
}