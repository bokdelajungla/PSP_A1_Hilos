package requerimiento3;
/**
 * Clase que implementa un hilo que se encarga de generar 10 mensajes mediante {@link EmailRandomizer} 
 * cada 0.5 segundos y pasarselos al Buffer. Cada vez que genera un correo muestra un mensaje con el 
 * nombre del hilo que ha generado el mensaje y el {@link Email#getId()} del objeto Email.
 * 
 * @author Jorge Sánchez-Alor Expósito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 *
 */
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
