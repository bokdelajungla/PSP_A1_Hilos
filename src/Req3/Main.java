package Req3;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer();
		
		Productor p1 = new Productor("Producto 1",buffer);
		Productor p2 = new Productor("Producto 2",buffer);
		Productor p3 = new Productor("Producto 3",buffer);
		
		Consumidor c1 = new Consumidor("Consumidor 1",buffer);
		Consumidor c2 = new Consumidor("Consumidor 2",buffer);
		
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
	}

}
