package requerimiento2;

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
