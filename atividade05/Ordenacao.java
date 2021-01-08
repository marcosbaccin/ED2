package ed2.atividade05;

public class Ordenacao {
	
	private int movimentos = 0;

	public int[] insertionSort(int[] lista) {
		
		resetMovimentos();
		
		for (int i = 1; i < lista.length; i++) {
			
			int chave = lista[i];
			int j = i-1;
			
			while(j >= 0 && lista[j] > chave) {
				
				lista[j+1] = lista[j];
				j--;
				
				addMovimento();
			}
			
			lista[j+1] = chave;
		}
		
		qtdMovimentos();
		
		return lista;
	}
	
	public int[] selectionSort(int[] lista) {
		
		resetMovimentos();
		
		int n = lista.length;
		
		for(int j = 0; j < (n-1); j++) {
			
			int indexMinimo = j;
			
			for(int i = j; i < n; i++) {
				
				if(lista[i] < lista[indexMinimo]) {
					indexMinimo = i;
				}
			}
			
			if(lista[j] > lista[indexMinimo]) {
				
				int aux = lista[j];
				lista[j] = lista[indexMinimo];
				lista[indexMinimo] = aux;
				
				addMovimento();
			}
		}
		
		qtdMovimentos();
		
		return lista;
	}
	
	public int[] bubbleSort(int[] lista) {
		
		resetMovimentos();
		
		for(int i = 0; i < lista.length-1; i++) {
			
			for(int j = 0; j < lista.length-1; j++) {
				
				if(lista[j] > lista[j+1]) {
					
					int aux = lista[j];
					lista[j] = lista[j+1];
					lista[j+1] = aux;
					
					addMovimento();
				}
			}
		}
		
		qtdMovimentos();
		
		return lista;
	}
	
	public int[] combSort(int[] lista) {
		
		resetMovimentos();
		
		int intervalo = (int) (lista.length / 1.3);
		int indice = 0;
		
		while(intervalo > 0 && indice != lista.length-1) {
			
			indice = 0;
			
			while((indice + intervalo) < lista.length) {
				
				if(lista[indice] > lista[indice + intervalo]) {
					
					int aux = lista[indice];
					lista[indice] = lista[indice + intervalo];
					lista[indice + intervalo] = aux;
					
					addMovimento();
				}
				
				indice++;
			}
			
			intervalo = (int) (intervalo / 1.3);
		}
		
		qtdMovimentos();
		
		return lista;
	}
	
	private void addMovimento() {
		this.movimentos++;
	}
	
	private void qtdMovimentos() {
		System.out.println("Quantidade de movimentos: " + this.movimentos);
	}
	
	private void resetMovimentos() {
		this.movimentos = 0;
	}
	
	public int getQtdMovimentos() {
		return this.movimentos;
	}
}