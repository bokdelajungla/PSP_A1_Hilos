package requerimiento3;

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
		for(int i=1;i <= 10;i++){
			try {
				Thread.sleep(500);
				Email email = EmailRandomizer.generarEmail(); 
				cola.addMensaje(email);
				System.out.println(this.nombre + " ha producido un correo con id=" + email.getId());
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
