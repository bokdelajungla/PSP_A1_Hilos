package requerimiento1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que se encarga de solicitar la entrada de 4 numeros por teclaso al usuario
 * para despues lanzar 4 hilos para que lleven a cabo la comprobacion de si son o no primos.
 *  
 * @author Jorge Sánchez-Alor
 *
 */

public class MainHiloPrimo {

	public static void main(String[] args) {
		
		//Declaramos las variables para almacenar los numeros introducidos por el usuario
		Scanner sc = new Scanner(System.in); 
		long[] numero= new long[4];
		
		//Solicitamos los numeros al usuario
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
		
		//Creamos y lanzamos los 4 Hilos
		new HiloPrimo(numero[0],"Alfa");
		new HiloPrimo(numero[1],"Beta");
		new HiloPrimo(numero[2],"Gamma");
		new HiloPrimo(numero[3],"Delta");
		
	}

/* Algunos numeros primos grandes 
 * 524287
 * 2147483647
 * 1111111111111111111
 * 2305843009213693951 	
 */
	
}
