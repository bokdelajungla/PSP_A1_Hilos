package requerimiento3;

/**
 * Clase que prueba la funcionalidad de el sistema
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 */
public class Principal {

	/**
	 * Método principal. Inicia la ejecución del programa
	 * @param args argumentos por consola de comandos
	 */
	public static void main(String[] args) {
		BufferEmails buffer = new BufferEmails();
		new ProductorEmail(buffer);
		new ConsumidorEmail(buffer);
		new ProductorEmail(buffer);
		new ConsumidorEmail(buffer);
		new ProductorEmail(buffer);
	}
	

}
