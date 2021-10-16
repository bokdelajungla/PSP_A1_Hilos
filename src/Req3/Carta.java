package Req3;

public class Carta {
	
	private int id;
	private String destinatario;
	private String remitente;
	private String asunto;
	private String cuerpo;
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
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	@Override
	public String toString() {
		return "Carta [id= " + id + ", destinatario= " + destinatario + ", remitente= " + remitente + ", asunto= " + asunto
				+ ", cuerpo= " + cuerpo + "]";
	}
}
