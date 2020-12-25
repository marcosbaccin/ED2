package ed2.atividade04.listaduplamenteencadeada;

public class Celula {

	private Celula proxima;
	private Celula anterior;
	private Object elemento;
	
	Celula(Celula prox, Object ele) {
		this.proxima = prox;
		this.anterior = null;
		this.elemento = ele;
	}
	Celula(Object ele) {
		this.proxima = null;
		this.anterior = null;
		this.elemento = ele;
	}
	
	void setProxima(Celula prox) {
		this.proxima = prox;
	}
	void setAnterior(Celula ant) {
		this.anterior = ant;
	}
	Celula getProxima() {
		return(this.proxima);
	}
	Celula getAnterior() {
		return(this.anterior);
	}
	Object getElemento() {
		 return(this.elemento);
	}
}