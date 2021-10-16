package Req2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class GeneradorCarta {
	
	public Carta generarCarta() {
		Carta carta = new Carta();
		carta.setId(generarId());
		carta.setDestinatario(generarDestinatario());
		carta.setRemitente(generarRemitente());
		carta.setAsunto(generarAsunto());
		carta.setCuerpo(generarCuerpo());
		return carta;
	}
	
	public String generarDestinatario() {
		List<String> listaDestinatarios = new ArrayList<String>();
		listaDestinatarios.add("njerg@gmail.com");
		listaDestinatarios.add("ludens@gmail.com");
		listaDestinatarios.add("brunomars@gmail.com");
		listaDestinatarios.add("batman@gmail.com");
		listaDestinatarios.add("fernandoexposito@gmail.com");
		listaDestinatarios.add("logitech@gmail.com");
		listaDestinatarios.add("paquito@gmail.com");
		listaDestinatarios.add("elsafrozen@gmail.com");
		listaDestinatarios.add("bruno@gmail.com");
		listaDestinatarios.add("pikachu@gmail.com");
		
		int numero = ThreadLocalRandom.current().nextInt(0, 10);
		
		return listaDestinatarios.get(numero);
	}
	
	public String generarRemitente() {
		List<String> listaRemitente = new ArrayList<String>();
		listaRemitente.add("gilbert@gmail.com");
		listaRemitente.add("darek@gmail.com");
		listaRemitente.add("uhjiel@gmail.com");
		listaRemitente.add("oliver@gmail.com");
		listaRemitente.add("erdwin@gmail.com");
		
		int numero = ThreadLocalRandom.current().nextInt(0, 5);
		
		return listaRemitente.get(numero);
	}
	
	public String generarAsunto() {
		List<String> listaAsunto= new ArrayList<String>();
		listaAsunto.add("Su p�liza de seguro se renovar�");
		listaAsunto.add("Subscribase e Nintendo Switch Online");
		listaAsunto.add("�Tiene un momento para poder hablar de nuestro se�or Jesucrito?");
		listaAsunto.add("Taki taki rumba");
		listaAsunto.add("[Github] Please reset your password");
		
		int numero = ThreadLocalRandom.current().nextInt(0, 5);
		
		return listaAsunto.get(numero);
	}
	
	public String generarCuerpo() {
		List<String> listaCuerpo= new ArrayList<String>();
		listaCuerpo.add("Lorem Ipsum es simplemente el texto de relleno de las imprentas "
				+ "y archivos de texto. Lorem Ipsum ha sido el texto de relleno est�ndar");
		listaCuerpo.add("Es un hecho establecido hace demasiado tiempo que un lector se distraer�"
				+ " con el contenido del texto de un sitio mientras que mira su dise�o");
		listaCuerpo.add("Hay muchas variaciones de los pasajes de Lorem Ipsum disponibles, "
				+ "pero la mayor�a sufri� alteraciones en alguna manera, ya sea porque se le agreg� humor, "
				+ "o palabras aleatorias que no parecen ni un poco cre�bles.");
		listaCuerpo.add("Al contrario del pensamiento popular, el texto de Lorem Ipsum no es simplemente texto aleatorio.");
		listaCuerpo.add("El trozo de texto est�ndar de Lorem Ipsum usado desde el a�o 1500 es reproducido debajo para aquellos interesados.");
		
		int numero = ThreadLocalRandom.current().nextInt(0, 5);
		
		return listaCuerpo.get(numero);
	}
	
	public int generarId() {
		int numero = ThreadLocalRandom.current().nextInt(0, 10000);
		return numero;
	}
	

}
