package Req2;


public class Consumidor extends Thread {
	
	public String nombre;
	public Buffer buffer;
	
	public Consumidor(String nombre, Buffer buffer){
		super();
		this.nombre = nombre;
		this.buffer = buffer;
	}
	
	public void run(){
		for(int i = 1;i <= 10;i++){
			Carta carta = buffer.getEmail();
			System.out.println(nombre + " ha enviado el email: " + carta);
		}
	}

}
