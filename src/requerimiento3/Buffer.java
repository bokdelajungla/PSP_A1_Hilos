package requerimiento3;

/**
 * Clase que implementa la cola que almacena los Emails y que permite que los Productores depositen mensajes
 * y Consumidores recojan mensajes. 
 * En caso de que se llegue al m�ximo de capacidad indicar� a los Productores que detengan su ejecuci�n hasta que 
 * se tenga espacio de nuevo.
 * En caso de que no se tengan mensajes en la cola, indicar� a los Consumidores que se detengan hasta que de nuevo
 * tengamos elementos en la cola.
 * 
 * Adem�s, si el destinatario del mensaje es "pikachu@gmail.com" el mensaje no se a�adir� a la cola y se dar� un aviso
 * por pantalla de que el mensaje ha sido descartado.
 * 
 * 
 * @author Jorge S�nchez-Alor Exp�sito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	public final static int MAX_ELEMENTOS = 5;
	private Queue<Email> cola = new LinkedList<>();
	
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
		
		//A�adir un elemento a la cola pero no si el destinatario es pikachu@gmail.com
		if(email.getDestinatario().equals("pikachu@gmail.com")) {
			System.out.println("NO EST� PERMITIDO ENVIAR CORREOS A PIKACHU!!! -> Su mensaje con id=" +email.getId()+ " ha sido descartado");
		}
		else {
			cola.offer(email);	
		}
		
		//Notify, notificamos a todos los hilos que esten en estado wait que
		//despierten(tanto los de addMensaje como los de getMensaje)
		notify();
	}
	
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
