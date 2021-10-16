package Req3;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
	
		public final static int MAX_ELEMENTOS = 5;
		
		private Queue<Carta> capacidad = new LinkedList<>();

		public synchronized void addEmail(Carta carta){
			while(capacidad.size() == MAX_ELEMENTOS){//5
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				// Añade los elementos al buffer cada 0,5 segundos
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if (carta.getDestinatario() == "pikachu@gmail.com") {
					System.out.println("No se le envia email a Pikachu");
			} else {
				//Add un elemento a la cola
				capacidad.offer(carta);
			}
			notify();
		}
		
		public synchronized Carta getEmail(){
			while(capacidad.size() == 0){
				try {

					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//Sacamos un elemento de la cola
			Carta c = capacidad.poll();
			notify();
			return c;
		}

}
