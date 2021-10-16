package requerimiento3;

import java.util.LinkedList; 
import java.util.Queue;

public class BufferEmails {
	
	private Queue<Email> cola;
	private final int LIMITE = 5;
	
	public BufferEmails(int limite) {
		cola = new LinkedList<Email>();
	}
	
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