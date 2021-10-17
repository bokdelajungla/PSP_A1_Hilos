package requerimiento2;

/**
 * Clase que implementa un hilo que se encarga de recoger los mensajes del Buffer y muestra su contenido al recogerlo
 * llamando a {@link Email#toString()}.
 * 
 * @author Jorge Sánchez-Alor Expósito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 *
 */

public class Consumidor implements Runnable {

	private String nombre;
	private Buffer cola;
	
	public Consumidor(String nombre, Buffer cola) {
		super();
		this.nombre = nombre;
		this.cola = cola;
		Thread t = new Thread(this,nombre);
		t.start();	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Recoge los mensajes del Buffer
		while(true) {
			Email email = cola.getMensaje();
			System.out.println(this.nombre + " ha consumido el correo: " + email);
		}
	}

	
}
