package requerimiento1;

import java.time.Duration;
import java.time.Instant;

public class HiloPrimo implements Runnable{
	
	//Atributos
	private long numero;

	//Constructor
	public HiloPrimo(long numero, String nombre) {
		this.numero = numero;
		Thread t1 = new Thread(this,nombre);
		t1.start();
	}

	@Override 
	public void run() {
		//Marcamos el inicio
		//long comienzo = date.getTime();
		//long comienzo = System.nanoTime();
		Instant comienzo = Instant.now();
		
		System.out.println("Iniciando: " + Thread.currentThread().getName());
		//Algoritmo para comprobar si es primo
		boolean esPrimo = true;
	    //Si es par, no es primo
	    if (this.numero%2==0) { esPrimo = false;}
	    //si no es par, solo dividimos por los impares
	    else{
	    	for(int i=3;i*i<=this.numero;i+=2) {
	    		if(this.numero%i==0) {esPrimo = false;}
	    	}
	    }
	    //Marcamos el final
		//long fin = date.getTime();
		//long fin = System.nanoTime();
		Instant fin = Instant.now();
		
		//Calculamos el tiempo invertido
		//long consumido = ((float)(fin-comienzo))/1000000;
		long consumido = Duration.between(comienzo, fin).toMillis();
		
		if(esPrimo) {
			System.out.println("El numero " + this.numero + " procesado por " + Thread.currentThread().getName() +
				" en " + consumido + "ms ES PRIMO.\n");
		}
		else {
			System.out.println("El numero " + this.numero + " procesado por " + Thread.currentThread().getName() +
					" en " + consumido + "ms NO ES PRIMO.\n");	
		}
	}
}
