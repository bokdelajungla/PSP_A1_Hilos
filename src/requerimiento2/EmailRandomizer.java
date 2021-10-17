package requerimiento2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que se encarga de generar los Emails para simular el envío por parte de los Productores.
 * La clase es abstracta para que no se puedan generar instancias de ella, y posee un atributo privado 
 * de clase {@link EmailRandomizer#ID}, que contiene el identificador de los Emails que se incrementa 
 * cada vez que se crea un nuevo objeto. 
 * Sin embargo, como tenemos varios hilos creando Emails, para garantizar la unicidad del ID
 * tenemos que forzar que el método {@link EmailRandomizer#generarEmail()} sea synchronized, para que 
 * sólo un hilo pueda ejecutarlo a la vez.
 *
 * @author Jorge Sánchez-Alor Expósito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 *
 */

public abstract class EmailRandomizer {
	
	//La variable ID debe ser un idetificador único
	//Hacemos la clase abstracta para que no se pueda instanciar y hacemos
	//el método generar email static y además synchronized para asegurar que solo
	//un thread pueda modificar el contador de id.
	private static int ID=1;	
	
	//Este es el único método que pueden ver el resto de clases
	//Al poner synchronized aseguramos que solo un hilo puede ejecutarlo a la vez
	public static synchronized Email generarEmail() {
		Email email = new Email();
		email.setId(generarId());
		email.setRemitente(generarRemitente());
		email.setDestinatario(generarDestinatario());
		email.setAsunto(generarAsunto());
		email.setMensaje(generarMensaje());
		return email;
	}
	/**
	 * El metodo le asigna la variable {@link EmailRandomizer#ID} de clase al nuevo objeto y luego la incrementa en 1
	 * 
	 * @return id un entero con el valor actual de la variable {@link EmailRandomizer#ID} 
	 */
	private static int generarId() {
		int id = ID;
		ID++;
		return id;
	}

	/**
	 * El metodo selecciona una direccion de correo de una lista de forma aleatoria.
	 *  
	 * @return remitente un String con la direccion de correo del emisor del mensaje
	 */
	private static String generarRemitente() {
		List<String> lista = new ArrayList<String>();
		lista.add("arthasMenethil@lordaeron.com");
		lista.add("thrallwarchief@orgrimmar.orc");
		lista.add("party.mediv@karazhan.com");
		lista.add("lilragnito@molten.core.com");
		lista.add("xxxillidanxxx@you.are.not.prepared");
		lista.add("mrbigglesworth@undead.naxx");
		lista.add("pikachu@gmail.com");
		
		Random r = new Random();
		int indice = r.nextInt(lista.size());
		
		return lista.get(indice);
	}
	
	/**
	 * El metodo selecciona una direccion de correo de una lista de forma aleatoria.
	 *  
	 * @return destinatario un String con la direccion de correo del receptor del mensaje
	 * 
	 * NOTA: En este caso al ser las dos listas iguales, el funcionamiento es identico al de 
	 * {@link EmailRandomizer#generarRemitente()} pero los destinatarios podrian ser diferentes
	 * a los remitentes
	 * 
	 */
	private static String generarDestinatario() {
		List<String> lista = new ArrayList<String>();
		lista.add("arthasMenethil@lordaeron.com");
		lista.add("thrallwarchief@orgrimmar.orc");
		lista.add("party.mediv@karazhan.com");
		lista.add("lilragnito@molten.core.com");
		lista.add("xxxillidanxxx@you.are.not.prepared");
		lista.add("mrbigglesworth@undead.naxx");
		lista.add("pikachu@gmail.com");
		
		Random r = new Random();
		int indice = r.nextInt(lista.size());
		
		return lista.get(indice);
	}
	
	/**
	 * * El metodo selecciona un asunto para el correo de una lista de forma aleatoria.
	 *  
	 * @return asunto un String con el asunto del mensaje
	 * 
	 */
	private static String generarAsunto() {
		List<String> lista = new ArrayList<String>();
		lista.add("TOO SOON!!");
		lista.add("FOR THE HORDE!");
		lista.add("FOR THE ALLIANCE");
		lista.add("Froustmourne hungers");
		lista.add("You are not prepared");
		lista.add("Justice shall be met indeed!");
		lista.add("Noggenfogger order");
		lista.add("Need gold!");
		lista.add("Damn Ninjas");
		
		Random r = new Random();
		int indice = r.nextInt(lista.size());
		
		return lista.get(indice);
	}
	
	/**
	 * El metodo genera un mensaje aleatoria para el correo
	 * 
	 * @return mensaje un String con un mensaje generado de forma aleatoria
	 */
	private static String generarMensaje() {
		Random r = new Random();
		int limiteInferior = 48; // numero '0'
	    int limiteSuperior = 122; // letra 'z'
	    StringBuilder mensaje = new StringBuilder();
	    
	    //Código para generar cadenas aleatorias de hasta 50 "palabras"
	    for(int j=0;j<r.nextInt(51);j++) {
		    int longitudString = r.nextInt(11);
		    String aleatoriaString = r.ints(limiteInferior, limiteSuperior + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(longitudString)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		    mensaje.append(aleatoriaString + " ");
	    }
	 
	    return mensaje.toString();
	}
}
