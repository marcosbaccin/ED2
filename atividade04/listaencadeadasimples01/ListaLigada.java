package ed2.atividade04.listaencadeadasimples01;

public class ListaLigada {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos = 0;
	
	public void adicionaNoComeco(Object elemento) {
		 
		Celula nova = new Celula(this.primeira,elemento);
		
		this.primeira = nova;
		
		if(this.totalDeElementos == 0) {
			this.ultima = this.primeira;
		}
		
		this.totalDeElementos++;
	 }
	
	public void adiciona(Object elemento) {
		 
		if(this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		}
		else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	 }
	
	public boolean posicaoOcupada(int pos) {
		return((pos >= 0)&&(pos < this.totalDeElementos));
	}
	
	public Celula pegaCelula(int pos) {
		 
		if(!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao Existe");
		}
		else {
			Celula atual = this.primeira;
			
			for(int i=0; i < pos; i++) {
				atual = atual.getProxima();
			}
			
			return(atual);
		}
	 }
	
	public void adiciona(int pos, Object elemento) {
		 
		if(pos == 0) {
			this.adicionaNoComeco(elemento);
		}
		else if(pos == this.totalDeElementos) {
			this.adiciona(elemento);
		}
		else {
			Celula anterior = this.pegaCelula(pos-1);
			Celula Nova = new Celula(anterior.getProxima(),elemento);
			anterior.setProxima(Nova);
			this.totalDeElementos++;
		}
	 }
	
	public Object pega(int posicao) {
		 return(this.pegaCelula(posicao).getElemento());
	}
	
	public void removeDoComeco() {
		 
		if(!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não Existe");
		}
		else {
			
			this.primeira = this.primeira.getProxima();
			this.totalDeElementos--;
			
			if(this.totalDeElementos == 0) {
				this.ultima = null;
			}
		}
	}
	
	public boolean contem(Object elemento) {
		 
		Celula atual = this.primeira;
		
		while(atual!=null) {
			
			if(atual.getElemento().equals(elemento)) {
				return(true);
			}
			
			atual = atual.getProxima();
		}
		
		return(false);
	}
	
	public int tamanho() {
		 return(this.totalDeElementos);
	}
	
	public void imprimirDados() {
		
		Celula atual = this.primeira;
		
		System.out.println("===============================================");
		while(atual != null) {
			System.out.println(atual.getElemento().toString());
			atual = atual.getProxima();
		}
		System.out.println("===============================================");
	}
}