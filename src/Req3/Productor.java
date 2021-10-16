package Req3;


public class Productor extends Thread {

	public String nombre;
	public Buffer buffer;
	
	public Productor(String nombre, Buffer buffer){
		super();
		this.nombre = nombre;
		this.buffer = buffer;
	}
	
	public void run(){
		GeneradorCarta gc = new GeneradorCarta();
		for(int i = 1;i <= 10;i++){
			Carta carta = gc.generarCarta();
			System.out.println(nombre + " ha producido el email y con el id: " + carta.getId());
			buffer.addEmail(carta);
		}
	}
}
