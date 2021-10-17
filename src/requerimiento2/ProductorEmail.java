package requerimiento2;

/**
 * Clase que simula un productor de emails.
 * Produce hasta un máximo de 10 emails
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 */
public class ProductorEmail extends Thread {
	
	/**
	 * buffer donde se introducirán los emails
	 */
	private BufferEmails buffer;
	/**
	 * número de productores
	 */
	private static int num_productor = 0; 
	/**
	 * constante con el máximo de mails a producir
	 */
	private final int MAX_MAILS = 10;
	/**
	 * Hilo que se va a utilizar
	 */
	private Thread hilo;
	
	/**
	 * Constructor de un productor de emails
	 * @param buffer buffer en donde se introducirán los emails
	 */
	public ProductorEmail(BufferEmails buffer) {
		this.buffer = buffer;
		num_productor++;
		hilo = new Thread(this, "Productor nº " + num_productor);
		hilo.start();
	}
	
	/**
	 * Sobreescritura del método run donde se encuentra la ejecución del hilo
	 * Produce un email cada 0,5 seg y lo intruce en el buffer (hasta que se hayan generado 10, que ha cumplido su función)
	 */
	@Override
	public void run() {
		Email mail;
		for(int i = 0; i < MAX_MAILS; i++) {
			try {
				Thread.sleep(500);
				mail = new Email(generarId(10000), generarCadena(30), generarCadena(30), generarCadena(20), generarCadena(50));		
				buffer.meter(mail);
				System.out.println("Productor nº " + num_productor + " ha generado el email:\n" + mail.toString() + "\n");
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
		}
		System.out.println("Productor nº " + num_productor + " ha generado 10 emails. Finaliza su función.\n");
		
	}
	
	/**
	 * Genera una cadena alatoria
	 * @param size tamaño de la cadena a generar
	 * @return cadena generada
	 */
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
	
	/**
	 * Genera un ID aleatorio
	 * @param max cota superior del ID
	 * @return ID generado
	 */
	private int generarId(int max) {
        int id = (int) (Math.random() * max + 1);
		return id;
    }
	
	
}
