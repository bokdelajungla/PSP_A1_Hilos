package requerimiento2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class EmailRandomizer {
	
	//La variable ID debe ser un idetificador �nico
	//Hacemos la clase abstracta para que no se pueda instanciar y hacemos
	//el m�todo generar email static y adem�s synchronized para asegurar que solo
	//un thread pueda modificar el contador de id.
	private static int ID=1;	
	
	//Este es el �nico m�todo que pueden ver el resto de clases
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
	
	private static int generarId() {
		int id = ID;
		ID++;
		return id;
	}

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
	
	private static String generarMensaje() {
		Random r = new Random();
		int limiteInferior = 48; // numero '0'
	    int limiteSuperior = 122; // letra 'z'
	    StringBuilder mensaje = new StringBuilder();
	    
	    //C�digo para generar cadenas aleatorias de hasta 50 "palabras"
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
