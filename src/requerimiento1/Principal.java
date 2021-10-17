package requerimiento1;

import java.util.Scanner;

/**
 * Clase de testeo para la clase EsPrimo
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 *
 */
public class Principal {

	/**
	 * Metodo principal desde el cual se ejecuta el programa
	 * 
	 * @param args argumrntos de entrada por linea de comando
	 */
	public static void main(String[] args) {
		int num1, num2, num3, num4;
		EsPrimo esPrimo1, esPrimo2, esPrimo3, esPrimo4;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca 4 enteros por pantalla: ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		num4 = sc.nextInt();
		sc.close();
		esPrimo1 = new EsPrimo("hilo esPrimo1", Thread.NORM_PRIORITY, num1);
		esPrimo2 = new EsPrimo("hilo esPrimo2", Thread.NORM_PRIORITY, num2);
		esPrimo3 = new EsPrimo("hilo esPrimo3", Thread.NORM_PRIORITY, num3);
		esPrimo4 = new EsPrimo("hilo esPrimo4", Thread.NORM_PRIORITY, num4);
	}

}
