package requerimiento3;

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
