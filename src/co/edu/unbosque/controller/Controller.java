package co.edu.unbosque.controller;

import java.util.Scanner;

public class Controller {
	
	public void start(){
		Scanner sc = new Scanner(System.in);
		boolean start = true;
		ciclo: while(start) {
			System.out.println("       ------[ADMIN]------\n == Bievenido Al Parqueadero ==");
			System.out.println("1. Ver Vehiculos\n2. Suicidio");
			int r = sc.nextInt();
			switch(r) {
			case 1:
				System.out.println("todavia no hay carros nwn");
				break;
			case 2:
				System.out.println("aa netanyahu");
				break ciclo;
			default:
				System.out.println("igual aa netantaya");
				break ciclo;
			}
		}
	}
    
}
