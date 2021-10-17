package requerimiento1;

/**
 * Clase extendida de Thread (se trata de un hilo de ejecucion) cuyo objetivo es calcular si un numero es primo o no
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 *
 */
public class EsPrimo extends Thread{
	
	/**
	 * Condución de ser primo (true) o no (false)
	 */
	private boolean primo;
	/**
	 * Número a evaluar si es primo
	 */
	private int num;
	/**
	 * Contador de recursividad necesario para el algoritmo (parámetro del método) que calcula si un número es primo.
	 * Para su correcto funcionamiento es conveniente que sea 2.
	 */
	private int contador;
	/**
	 * Tiempo de inicio de ejecución del hilo, en nanosegundos (ns).
	 */
	private long inicio;
	/**
	 * Tiempo de fin de ejecución del hilo, en nanosegundos (ns).
	 */
	private long fin; 
	
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
	 * Sobreescritura del metodo run donde se realiza la ejecucion del hilo. Calculara si un numero es primo o no, mediante la llamada a un método interno. 
	 * Además calculará los tiempos de ejecución del hilo e imprimirá por pantalla una cadena con los datos relevantes.
	 */
	@Override
	public void run() {
		inicio = System.nanoTime();
		primo = esPrimo(num, contador);
		fin = System.nanoTime();
		System.out.println(this.toString());
	}
	
	/**
	 * Método que calcula si un enteros es primo. Se trata de un método recursivo.
	 * Utiliza un doble condicional if - else if, con un if - else anidado que tiene una llamada asía misma (función recursiva).
	 * En el primer if descarta los números 1 y 2, ya que son primos. 
	 * El else if nos sirve para no seguir haciendo llamadas recursivas en caso de que el contador sea igual al número, ya que, si si se da el caso de llegar al número sin que el resto de la división entera sea 0, el número es primo.
	 * En caso contrario se recurirá a la recursividad incrementando en 1 el contador, para seguir evaluando divisores (contador) hasta llegar al número.
	 * @param n número a calcular si es primo
	 * @param i contador de recursividad. Para su correcto funcionamiento es conveniente que comience por 2, ya que todo número divido entre 1 es primo.
	 * @return true si el número es primo o false en caso contrario
	 */
	private boolean esPrimo(int n, int i) {
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
	 * @see java.lang.Object
	 */
	@Override
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
