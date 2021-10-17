package requerimiento2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase que implementa la cola que almacena los Emails y que permite que los Productores depositen mensajes
 * y Consumidores recojan mensajes. 
 * En caso de que se llegue al m�ximo de capacidad indicar� a los Productores que detengan su ejecuci�n hasta que 
 * se tenga espacio de nuevo.
 * En caso de que no se tengan mensajes en la cola, indicar� a los Consumidores que se detengan hasta que de nuevo
 * tengamos elementos en la cola.
 * 
 * 
 * @author Jorge S�nchez-Alor Exp�sito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 *
 */
public class Buffer {
	
	//Definimos el n�mero m�ximo de elementos y la Lista donde almacenar los Emails
	public final static int MAX_ELEMENTOS = 5;
	private Queue<Email> cola = new LinkedList<>();
	
	public Buffer() {
		super();
	}

	//El metodo para a�adir mensajes est� sincronizado
	public synchronized void addMensaje(Email email){
		
		//Si la cola esta llena no debemos introducir ningun elemento m�s
		//Hacemos el bucle del wait()
		while(cola.size() == MAX_ELEMENTOS){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//A�adimos un elemento a la cola
		cola.offer(email);
		//Notify, notificamos a todos los hilos que esten en estado wait que
		//despierten (tanto los de addMensaje como los de getMensaje)
		notify();
	}
	
	//El metodo para retirar mensajes est� sincronizado
	public synchronized Email getMensaje(){
		Email email = null;
		while(cola.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Sacamos un elemento de la cola
		email = cola.poll();
		//Notificamos a los que est�n esperando a recoger
		notify();
		return email;
	}
	
	

}
