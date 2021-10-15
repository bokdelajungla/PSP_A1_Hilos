package requerimiento2;

public class Productor implements Runnable{
	
	private String nombre;
	private Buffer cola;
	
	public Productor(String nombre, Buffer cola) {
		super();
		this.nombre = nombre;
		this.cola = cola;
		Thread t1 = new Thread(this,nombre);
		t1.start();	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Genera 10 Emails
		EmailRandomizer er = new EmailRandomizer();
		for(int i=1;i <= 10;i++){
			Email email = er.generarEmail(); 
			System.out.println(this.nombre + " ha producido un correo " + email);
			cola.addMensaje(email);
		}
	}
	
}
