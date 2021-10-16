package requerimiento1;

/**
 * Clase extendida de Thread (se trata de un hilo de ejecucion) cuyp objetivo es calcular si un numero es primo o no
 * 
 * @author Adrian Rodriguez Montesinos
 * @version 1.0
 *
 */
public class EsPrimo extends Thread{
	
	private boolean primo;
	private int num, contador;
	private long inicio, fin; 
	
	/**
	 * Constructor de la clase EsPrimo. Se parte de la premisa de que el numero es primo, ya que no se va a evaluar si 1 o 2 son primos; se epezara la evaluacion por el numero 3.
	 * 
	 * @param nombre nombre del hilo
	 * @param prioridad prioridad del hilo
	 * @param num numero a calcular si es primo o no
	 */
	public EsPrimo(String nombre, int prioridad, int num) {
		super(nombre);
		this.setPriority(prioridad);
		this.num = num;
		contador = 2;
		primo = false;
		this.start();
	}

	/**
	 * Sobreescritura del metodo run donde se realiza la ejecucion del hilo. Calculara si un numero es primo o no, mediante un condicional (que excluya los dos primero numeros) y un bucle, ademas, calculara los tiempos de inicio y fin e imprimira la informacion por pantalla.
	 * Para hacer el programa mas rapido y evitar recursividad se han descartado los pares como primos dentro de la condicion anidada en el bucle.  
	 */
	public void run() {
		inicio = System.nanoTime();
		primo = esPrimo(num, contador);
		fin = System.nanoTime();
		System.out.println(this.toString());
	}
	
	public boolean esPrimo(int n, int i) {
		if(n == 1 || n == 2)
			return true;
		else if(i < n) {
			if(n % i == 0)
				return false;
			else 
				esPrimo(n, i + 1);
		}
		return true;
	}
	
	/**
	 * Sobreescritura del metodo toString() que nos permitira imprimir los datos deseados del hilo por pantalla. 
	 *
	 * @return cadena con la informacion del hilo, el numero a procesar, el tiempo de ejeccion y el resultado: si es primo o no.
	 */
	public String toString() {
		String esPrimo = null;
		long tiempo = fin - inicio;
		if(primo)
			esPrimo = "es primo";
		else 
			esPrimo = "no es primo";
		return "Numero a procesar: " + num + "\nProcesado por: " + this.getName() + "\nTiempo de ejecucion(ns): " + tiempo + "\nResultado: " + esPrimo +"\n";		
	}
	
}
