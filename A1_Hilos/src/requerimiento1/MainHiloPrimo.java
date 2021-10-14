package requerimiento1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainHiloPrimo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		long[] numero= new long[4];
		
		System.out.println("Introduzca 4 numeros para calcular si son primos:");
		try {
			for(int i=0; i<4; i++) {
				numero[i] = sc.nextLong();
			}
		}
		catch( InputMismatchException e ){
			System.out.println("No se reconoce el número o "
					+ "el número introducido en demasiado grande: el máximo es 9223372036854775807");
		}
		sc.close();
		
		new HiloPrimo(numero[0],"Alfa");
		new HiloPrimo(numero[1],"Beta");
		new HiloPrimo(numero[2],"Gamma");
		new HiloPrimo(numero[3],"Delta");
		
	}

}
