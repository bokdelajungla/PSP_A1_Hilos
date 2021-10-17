package requerimiento2;

/**
 * Clase que simula email.
 * 
 * @author Adrian Rodriguez Montesinos (Grupo 16)
 * @version 1.0
 */
public class Email {
	
	/**
	 * id del mail
	 */
	private int id;
	/**
	 * destinatario del mail
	 */
	private String destinatario;
	/**
	 * remitente del mail
	 */
	private String remitente;
	/**
	 * asunto del mail
	 */
	private String asunto;
	/**
	 * cuerpo del mail
	 */
	private String cuerpo;
	
	/**
	 * Constructir de la clase mail
	 * @param id id del mail
	 * @param destinatario destinatario del mail
	 * @param remitente remitente del mail
	 * @param asunto asunto del correo
	 * @param cuerpo texto del correo
	 */
	public Email(int id, String destinatario, String remitente, String asunto, String cuerpo) {
		this.id = id;
		this.destinatario = destinatario;
		this.remitente = remitente;
		this.asunto = asunto;
		this.cuerpo = cuerpo;
	}

	/**
	 * Sobreescritura del método to string que indica información relevante del mail
	 */
	@Override
	public String toString() {
		return "Email [id=" + id + ", destinatario=" + destinatario + ", remitente=" + remitente + ", asunto=" + asunto
				+ ", cuerpo=" + cuerpo + "]";
	}

	// Getters y setters
	
	/**
	 * getter del id
	 * @return id del mail
	 */
	public int getId() {
		return id;
	}

	/**
	 * setter del id del mail
	 * @param id id del mail
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter del destinatario
	 * @return destinatario del mail
	 */
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * setter del destinatario del mail
	 * @param destinatario destinatario del mail
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * getter del remitente
	 * @return remitente del mail
	 */
	public String getRemitente() {
		return remitente;
	}

	/**
	 * setter del remitente del mail
	 * @param remitente remitente del mail
	 */
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	/**
	 * getter del asunto del mail
	 * @return asunto del mail
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * getter del asunto del mail
	 * @param asunto asunto del mail
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * getter del cuerpo
	 * @return cuerpo del mail
	 */
	public String getCuerpo() {
		return cuerpo;
	}

	/**
	 * setter del cuerpo del mail
	 * @param cuerpo cuerpo del mail
	 */
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

}
