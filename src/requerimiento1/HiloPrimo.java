package requerimiento1;

//import java.util.Date;
//import java.time.Duration;
//import java.time.Instant;

/**
 * Clase que implementa un algoritmo para comprobar si un número es primo.
 * Cuando se lanza el hilo este comprueba si el numero que se le pasa como argumento
 * en el siguiente orden:
 *  - si es 0, que no es primo.
 *  - si es 1 o 2 que sí son primos.
 *  - si es par, en cuyo caso no es primo.
 *  - si es divisible entre los impares hasta que el cuadrado del divisor
 *    sea mayor que el numero. Si no encuentra divisores, entonces es primo.
 *    
 * Una vez realizada la comprobación se muestra un mensaje con los resultados, indicando el
 * el numero, el nombre del hilo que lo ha procesado, el tiempo que ha tardado en procesarlo
 * y si es primo o no, y en caso de que no sea primo muestra el menor divisor del numero.
 * 
 * @author Jorge Sánchez-Alor Expósito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 *
 */
public class HiloPrimo implements Runnable{
	
	//Atributos
	private long numero;

	//Constructor
	//El hilo se lanza al crear el objeto
	public HiloPrimo(long numero, String nombre) {
		this.numero = numero;
		Thread t1 = new Thread(this,nombre);
		t1.start();
	}

	@Override 
	public void run() {
		//Marcamos el inicio
		/* Con Date */
//		Date date = new Date();
//		long comienzo = date.getTime();

		/* Con System.nanoTime() */
		long comienzo = System.nanoTime();
		/* Con Instant.now() */
//		Instant comienzo = Instant.now();
		
		System.out.println("Iniciando: " + Thread.currentThread().getName());
		/* Algoritmo para comprobar si es primo */
		//Asumimons que es primo
		boolean esPrimo = true;
		//El 0 no es primo
		if (this.numero == 0) {esPrimo=false;}
		//El 1 y 2 son primos
		else if ((this.numero == 1)||(this.numero == 2)){
			//No hacemos nada y vamos directamente al final
		}
	    //Si es par, no es primo
		else if (this.numero%2==0) { 
	    	esPrimo = false;
	    	System.out.println(Thread.currentThread().getName() + 
	    			" ha encontrado el divisor 2 para " + this.numero);
	    }
	    //si no es par, dividimos por los impares hasta que el cuadrado del indice
	    //sea mayor que el número 
	    else{
	    	for(long i=3;i*i<this.numero;i+=2) {
	    		if(this.numero%i==0) {
	    			esPrimo = false;
	    			System.out.println(Thread.currentThread().getName() + " ha encontrado el divisor " 
	    			+ i + " para " + this.numero);
	    			break; //Si encontramos un divisor ya no es primo y salimos del bucle
	    		}
	    	}
	    }
	    //Si no es divisible -> nuestra suposición es cierta y será primo
	    
	    //Marcamos el final
//		long fin = date.getTime();
		long fin = System.nanoTime();
//		Instant fin = Instant.now();
		
		//Calculamos el tiempo invertido
//		long consumido = fin-comienzo; //Con Date
		float consumido = ((float)(fin-comienzo))/1000000000; //Lo pasamos a segundos
//		long consumido = Duration.between(comienzo, fin).toMillis(); //Con Instant
		
		//Mostramos por pantalla el resultado
		if(esPrimo) {
			System.out.println("El numero " + this.numero + " procesado por " + Thread.currentThread().getName() +
				" en " + consumido + "s ES PRIMO.\n");
		}
		else {
			System.out.println("El numero " + this.numero + " procesado por " + Thread.currentThread().getName() +
					" en " + consumido + "s NO ES PRIMO.\n");	
		}
	}
}
