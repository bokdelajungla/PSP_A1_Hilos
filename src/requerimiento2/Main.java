package requerimiento2;

/**
 * Clase que se encarga de simular el Requerimiento 2 creando: 1 Buffer para contener los Emails,
 * 3 Productores que generaran mensajes y 2 Consumidores que recogen mensajes.
 *  
 * @author Jorge Sánchez-Alor Expósito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 * 
 */
public class Main {

	public static void main(String[] args) {
		Buffer cola = new Buffer();
	
		new Productor("Productor 1", cola);
		new Productor("Productor 2", cola);
		new Productor("Productor 3", cola);
	
		new Consumidor("Consumidor 1", cola);
		new Consumidor("Consumidor 2", cola);
		
	}
}
