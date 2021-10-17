package requerimiento3;

import java.util.LinkedList; 
import java.util.Queue;

/**
 * Clase que actua de buffer de almacenamiento de emails. Para ello hace uso de una interfaz cola (queue).
 * Cuyas funcionalidades son meter y sacar emails del buffer.
 * Tiene un límite de 5 emails.
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 * @see java.util.LinkedList
 */
public class BufferEmails {
	
	/**
	 * Cola utilizada para almacenar los emails
	 */
	private Queue<Email> cola;
	/**
	 * Constante que limita el número de emails
	 */
	private final int LIMITE = 5;
	
	/**
	 * Contrusctor por defecto del buffer. Simplemente inicializa la cola.
	 */
	public BufferEmails() {
		cola = new LinkedList<Email>();
	}
	
	/**
	 * Método que introduce un email en la cola.
	 * COn la excepción de los mails cuyo destinatario es "pickachu@gmail.com"
	 * @param mail mail introducido en la cola
	 */
	public synchronized void meter(Email mail) { 
		if(cola.size() < LIMITE) {
			if(mail.getDestinatario().equals("pickachu@gmail.com"))
				System.out.println("Se ha descartado un email por tener un destinatario no deseado\n");
			else {
				cola.add(mail); 
				notify();
			}
		}
	}
	
	/**
	 * Metodo que saca un email de la cola.
	 * Utilizamos el syncronized para que no accedan varios hilos simultáneamente al buffer.
	 * También se hace uso del wait para el que un hilo espere y no se quede sin email; y del notify sepa cuando entrar en el bufer. 
	 * @return mail sacado de la cola
	 */
	public synchronized Email sacar() {
		int num_esperas = 0;
		while (cola.isEmpty() && num_esperas < 20) {
			num_esperas++;
			try {
				wait(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		if (num_esperas < 20) {
			Email mail = cola.remove();
			return mail;
		} else 
			return null;
	}
}