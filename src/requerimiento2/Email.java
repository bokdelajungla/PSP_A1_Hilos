package requerimiento2;

/**
 * Clase que representa un correo. Contiene toda la informción del correo electrónico:
 * <ul><li>id: Identificador numérico único.</li>
 * 	   <li>destinatario: direccion de correo del destinatario</li>
 *     <li>remitente: direccion de correo del remitente</li>
 *     <li>asunto: el asunto del correo</li>
 *     <li>mensaje: el cuerpo del mensaje</li>
 * Implementa Setter & Getters para los atributos y sobreescribe el método toString().
 * 
 * @author Jorge Sánchez-Alor Expósito, Adrian Rodriguez Montesinos, Antonio De Gea Velasco
 * 
 */
public class Email {
	
	private int id;
	private String destinatario;
	private String remitente;
	private String asunto;
	private String mensaje;
	
	public Email() {
		super();
	}

	public Email(int id, String destinatario, String remitente, String asunto, String mensaje) {
		super();
		this.id = id;
		this.destinatario = destinatario;
		this.remitente = remitente;
		this.asunto = asunto;
		this.mensaje = mensaje;
	}

	
	@Override
	public String toString() {
		return "Email [id=" + id + ", destinatario=" + destinatario + ", remitente=" + remitente + ", asunto=" + asunto
				+ ", mensaje=" + mensaje + "]";
	}
	
	//Setters & Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
	
}
