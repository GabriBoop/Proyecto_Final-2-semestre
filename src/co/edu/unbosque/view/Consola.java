package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner lector;

	public Consola() {
		lector = new Scanner(System.in);
	}

	public int leerEntero() {
		return lector.nextInt();
	}

	public long leerLargo() {
		return lector.nextLong();
	}

	public float leerFlotante() {
		return lector.nextFloat();
	}

	public double leerDoble() {
		return lector.nextDouble();
	}

	public String leerPalabra() {
		return lector.next();
	}

	public String leerLinea() {
		return lector.nextLine();
	}

	public boolean leerBooleano() {
		String valor = leerPalabra();
		if (valor.toLowerCase().contains("si")) {
			return true;
		} else {
			return false;
		}
	}

	public void imprimirConSalto(String texto) {
		System.out.println(texto);
	}

	public void imprimirSinSalto(String texto) {
		System.out.print(texto);
	}

	public void quemarLinea() {
		lector.nextLine();
	}
}
