package requerimiento2;

public class Principal {

	public static void main(String[] args) {
		BufferEmails buffer = new BufferEmails(5);
		new ProductorEmail(buffer);
		new ConsumidorEmail(buffer);
		new ProductorEmail(buffer);
		new ConsumidorEmail(buffer);
		new ProductorEmail(buffer);
	}
	

}
