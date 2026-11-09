package co.edu.unbosque.controller;

import java.util.Scanner;
import co.edu.unbosque.model.persistence.*;

public class Controller {
	
	private FileHandler fh;
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		fh = new FileHandler();
		
		boolean start = true;
		ciclo: while(start) {
			System.out.println("       ------[ADMIN]------\n == Bievenido Al Parqueadero ==");
			System.out.println("1. Ver Vehiculos\n2. Salir");
			int r = sc.nextInt();
			switch(r) {
			case 1:
				fh.crearYEscribirArchivo("Gabriel.csv","GABRIEEEEEEEL");
				System.out.println("Todavia no hay carros en el sistema.");
				
				break;
			case 2:
				System.out.println("se ha salido del programa.");
				break ciclo;
			default:
				System.out.println("[ERROR] Opcion Invalida.");
				break ciclo;
			}
		}
	}
    
}
