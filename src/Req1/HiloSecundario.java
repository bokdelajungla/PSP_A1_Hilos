package Req1;
import java.time.Duration;
import java.time.temporal.Temporal;

public class HiloSecundario implements Runnable {

	private long numeroProcesar;
	private String nombre;

	public HiloSecundario(long numero, String nombre) {
		numeroProcesar = numero;
		this.nombre = nombre;
		Thread th = new Thread(this, nombre);
		th.start();
	}
	
	private boolean isPrime(long numero) {
	    if ( numero > 2 && numero%2 == 0 ) {
	        return false;
	    }
	    int top = (int)Math.sqrt(numero) + 1;
	    for(int i = 3; i < top; i+=2){
	        if(numero % i == 0){
	            return false;
	        }
	    }
	    return true; 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long inicioTiempo = System.nanoTime();
		
		boolean primo;
		primo = isPrime(numeroProcesar);

		long finalTiempo = System.nanoTime();
		long tiempo = (finalTiempo - inicioTiempo);
		
		Numero num = new Numero(numeroProcesar, tiempo, primo);

		if (primo) {
			System.out.println("El hilo " + this.nombre + " ha procesado el " + num.toString() + " y es primo");
		} else {
			System.out.println("El hilo " + this.nombre + " ha procesado el " + num.toString() + " y no es primo");
		}
	}
}
