package ed2.atividade10;

public class NoArvore {

	int info;
	NoArvore esquerda = null;
	NoArvore direita = null;
	
	public void impEmOrdem(NoArvore tree) {
		
		if(tree != null) {
			
			impEmOrdem(tree.esquerda);
			
			System.out.print(tree.info + " ");
			
			impEmOrdem(tree.direita);
		}
	}
	
	public void impPosOrdem(NoArvore tree) {
		
		if(tree != null) {
			
			impPosOrdem(tree.esquerda);
			impPosOrdem(tree.direita);
			
			System.out.print(tree.info + " ");
		}
	}
	
	public void impPreOrdem(NoArvore tree) {
		
		if(tree != null) {
			
			System.out.print(tree.info + " ");
			
			impPreOrdem(tree.esquerda);
			impPreOrdem(tree.direita);
		}
	}
	
	public NoArvore search(NoArvore tree, int valor) {
		
		if(tree == null) {
			return null;
		}
		
		else if(tree.info > valor) {
			return search(tree.esquerda, valor);
		}
		
		else if(tree.info < valor) {
			return search(tree.direita, valor);
		}
		
		else return(tree);
	}
	
	public NoArvore insereRaiz(NoArvore tree, int valor) {
		
		tree.info = valor;
		tree.direita = null;
		tree.esquerda = null;
		
		return(tree);
	}
	
	public NoArvore insere(NoArvore tree, int valor) {
		
		if(tree == null) {
			
			tree = new NoArvore();
			tree.info = valor;
			tree.direita = null;
			tree.esquerda = null;
		}
		
		else if(valor < tree.info) {
			tree.esquerda = insere(tree.esquerda, valor);
		}
		
		else {
			tree.direita = insere(tree.direita, valor);
		}
		
		return(tree);
	}
	
	public NoArvore retira(NoArvore tree, int valor) {
		
		if(tree == null) {
			
			System.out.println("Elemento não encontrado: " + valor);
			
			return(null);
		}
		
		else if(tree.info > valor) {
			tree.esquerda = retira(tree.esquerda, valor);
		}
		
		else if(tree.info < valor) {
			tree.direita = retira(tree.direita, valor);
		}
		
		else {
			
			if((tree.esquerda == null) && (tree.direita == null)) {
				tree = null;
			}
			
			else if(tree.esquerda == null) {
				
				NoArvore novo = tree;
				tree = tree.direita;
			}
			
			else if(tree.direita == null) {
				
				NoArvore novo = tree;
				tree = tree.esquerda;
			}
			
			else {
				
				NoArvore novo = tree.esquerda;
				
				while(novo.direita != null) {
					novo = novo.direita;
				}
				
				tree.info = novo.info;
				novo.info = valor;
				tree.esquerda = retira(tree.esquerda, valor);
			}
		}
		
		return(tree);
	}
	
	public int maior(NoArvore tree) {
		
		if(tree != null && tree.direita == null) {
			return tree.info;
		}
		
		else {
			return maior(tree.direita);
		}
	}
	
	public int getInfo() {
		return info;
	}

	public NoArvore getEsquerda() {
		return esquerda;
	}

	public NoArvore getDireita() {
		return direita;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public void setEsquerda(NoArvore esquerda) {
		this.esquerda = esquerda;
	}

	public void setDireita(NoArvore direita) {
		this.direita = direita;
	}
}