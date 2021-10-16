package requerimiento3;

public class ProductorEmail extends Thread {
	
	private BufferEmails buffer;
	private static int num_productor = 0; 
	private final int MAX_MAILS = 10;
	private Thread hilo;
	
	public ProductorEmail(BufferEmails buffer) {
		this.buffer = buffer;
		num_productor++;
		hilo = new Thread(this, "Productor nº " + num_productor);
		hilo.start();
	}
	
	@Override
	public void run() {
		Email mail;
		for(int i = 0; i < MAX_MAILS; i++) {
			mail = new Email(generarId(10000), generarCadena(30), generarCadena(30), generarCadena(20), generarCadena(50));		
			buffer.meter(mail);
			System.out.println("Productor nº " + num_productor + " ha generado el email:\n" + mail.toString() + "\n");
		}
		System.out.println("Productor nº " + num_productor + " ha generado 10 emails. Finaliza su función.\n");
		
	}
	
	private String generarCadena(int size) {
        String abecedario = "abcdefghijklmnñopqrstuvwxyz", cadena = "";
        int rand = 0;
        char letra;
        
        for (int i = 0; i < size; i++) {
            rand = (int) (Math.random()*abecedario.length());
            letra = abecedario.charAt(rand);
            cadena += letra;
        }
        return cadena;
    }
	
	private int generarId(int max) {
        int id = (int) (Math.random() * max + 1);
		return id;
    }
	
	
}
