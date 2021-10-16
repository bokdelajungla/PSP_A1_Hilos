package requerimiento3;

public class ConsumidorEmail extends Thread{
	
	private BufferEmails buffer;
	private static int num_consumidor = 0; 
	private Thread hilo;
	
	public ConsumidorEmail(BufferEmails buffer) {
		this.buffer = buffer;
		num_consumidor++;
		hilo = new Thread(this, "Consumidor nº " + num_consumidor);
		hilo.start();
	}
	
	@Override
	public void run() {
		consumirMail();
	}
	
	public void consumirMail() {
		Email mail = buffer.sacar();
		if(mail != null) 
			System.out.println("Hilo Consumidor nº " + num_consumidor + "\nDatos del email: " + mail.toString() + "\n");
		else 
			System.out.println("No hay emails en el buffer");
	}

}
