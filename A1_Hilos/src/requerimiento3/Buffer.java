package requerimiento3;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
	public final static int MAX_ELEMENTOS = 5;
	private Queue<Email> cola = new LinkedList<>();
	
	public synchronized void addMensaje(Email email){
		
		//Si la cola esta llena no debemos introducir ningun elemento más
		//Hacemos el bucle del wait()
		while(cola.size() == MAX_ELEMENTOS){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Añadir un elemento a la cola pero no si el destinatario es pikachu@gmail.com
		if(email.getDestinatario().equals("pikachu@gmail.com")) {
			System.out.println("NO ESTÁ PERMITIDO ENVIAR CORREOS A PIKACHU!!! -> Su mensaje con id=" +email.getId()+ " ha sido descartado");
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
		//Notificamos a los que están esperando a recoger
		notify();
		return email;
	}
	
	

}
