package requerimiento2;

/**
 * Clase que simula un consumidor de emails.
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 */
public class ConsumidorEmail extends Thread{
	
	/**
	 * Buffer de donde se sacarán los mails
	 */
	private BufferEmails buffer;
	/**
	 * Contador de consumidores
	 */
	private static int num_consumidor = 0;
	/**
	 * Hilo de ejecución utilizado
	 */
	private Thread hilo;
	
	/**
	 * Constructor principal
	 * @param buffer buffer de donde se cogerán los emails
	 */
	public ConsumidorEmail(BufferEmails buffer) {
		this.buffer = buffer;
		num_consumidor++;
		hilo = new Thread(this, "Consumidor nº " + num_consumidor);
		hilo.start();
	}
	
	/**
	 * Método de ejecución del hilo
	 */
	@Override
	public void run() {
		consumirMail();
	}
	
	/**
	 * Método que simula la consumición de un email: saca un email del buffer e imprime la información del mismo por pantalla
	 */
	public void consumirMail() {
		Email mail = buffer.sacar();
		if(mail != null) 
			System.out.println("Hilo Consumidor nº " + num_consumidor + "\nDatos del email: " + mail.toString() + "\n");
		else 
			System.out.println("No hay emails en el buffer");
	}

}
