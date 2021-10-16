package Req1;

public class Numero {

	private volatile long numeroProcesado;
	private volatile long tiempo;
	private volatile Boolean primo;
	
	public Numero(long numeroProcesado, long tiempo, Boolean primo) {
		super();
		this.numeroProcesado = numeroProcesado;
		this.tiempo = tiempo;
		this.primo = primo;
	}

	@Override
	public String toString() {
		return "Numero [numeroProcesado= " + numeroProcesado
				+ ", tiempo= " + tiempo + " en milisegundos, primo= " + primo + "]";
	}
	public long getNumeroProcesado() {
		return numeroProcesado;
	}
	public void setNumeroProcesado(long numeroProcesado) {
		this.numeroProcesado = numeroProcesado;
	}
	public long getTiempo() {
		return tiempo;
	}
	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}
	public Boolean getPrimo() {
		return primo;
	}
	public void setPrimo(Boolean primo) {
		this.primo = primo;
	}
}
