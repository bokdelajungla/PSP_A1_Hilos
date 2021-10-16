package Req1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); 
		long[] numero= new long[4];
		
		System.out.println("A continuación escriba 4 números para ver si son primos");
		try {
			for(int i=0; i<4; i++) {
				numero[i] = scanner.nextLong();
			}
		} catch(InputMismatchException e){}
		
		scanner.close();
		
		new HiloSecundario(numero[0],"Elon Musk");
		new HiloSecundario(numero[1],"Steve Jobs");
		new HiloSecundario(numero[2],"Jeff Bezos");
		new HiloSecundario(numero[3],"Bill Gates");
	}
}