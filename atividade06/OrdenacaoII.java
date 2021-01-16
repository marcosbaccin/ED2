package ed2.atividade06;

public class OrdenacaoII {

	private long movimentos = 0;
	
	public int[] quickSort(int[] lista, int inicio, int fim) {
		
		if(inicio < fim) {
            
			int posicaoPivo = separar(lista, inicio, fim);
            
			quickSort(lista, inicio, posicaoPivo - 1);
            quickSort(lista, posicaoPivo + 1, fim);
		}
		
		return lista;
	}
	
	private int separar(int[] lista, int inicio, int fim) {
		
		int pivo = lista[inicio];
        int i = inicio + 1;
        int f = fim;
        
        while(i <= f) {
        	
        	if(lista[i] <= pivo)
        		i++;
            else if(pivo < lista[f])
            	f--;
            else {
            	int troca = lista[i];
            	lista[i] = lista[f];
            	lista[f] = troca;
            	
            	i++;
            	f--;
            	
            	addMovimento();
               }
        }
        
        lista[inicio] = lista[f];
        lista[f] = pivo;
        
        return f;
	}
	
	public int[] mergeSort(int[] lista, int inicio, int fim) {
		
		if(inicio < fim - 1) {
		      
			int meio = (inicio + fim) / 2;
		    
			mergeSort(lista, inicio, meio);
		    mergeSort(lista, meio, fim);
		    intercala(lista, inicio, meio, fim);
		}
		
		return lista;
	}
	
	private void intercala(int[] lista, int inicio, int meio, int fim) {
		
		int novoVetor[] = new int[fim - inicio];
	    int i = inicio;
	    int m = meio;
	    int pos = 0;
	    
	    while(i < meio && m < fim) {

	        if(lista[i] <= lista[m]) {
	        	
	        	novoVetor[pos] = lista[i];
	        	pos = pos + 1;
	        	i = i + 1;
	        	
	        	addMovimento();
	        } else {
	        	
	        	novoVetor[pos] = lista[m];
	        	pos = pos + 1;
	        	m = m + 1;
	        }
	    }
	    
	    while(i < meio) {
	        
	    	novoVetor[pos] = lista[i];
	        pos = pos + 1;
	        i = i + 1;
	        
	        addMovimento();
	    }
	    
	    while(m < fim) {
	        
	    	novoVetor[pos] = lista[m];
	        pos = pos + 1;
	        m = m + 1;
	        
	        addMovimento();
	    }
	    
	    for(pos = 0, i = inicio; i < fim; i++, pos++) {
	        lista[i] = novoVetor[pos];
	    }
	}
	
	public int[] shellSort(int[] lista) {
		
		int i;
		int j;
		int temp;
		int size = lista.length;
	    int incremento = 1;
	    
	    while(incremento < size) {
	        incremento = 3 * incremento + 1;
	    }
	    
	    while (incremento > 1) {
	        
	    	incremento /= 3;
	        
	        for(i = incremento; i < size; i++) {
	            
	        	temp = lista[i];
	            j = i - incremento;
	            
	            while (j >= 0 && temp < lista[j]) {
	                
	            	lista[j + incremento] = lista[j];
	                j -= incremento;
	                
	                addMovimento();
	            }
	            
	            lista[j + incremento] = temp;
	        }
	    }
		
		return lista;
	}
	
	private void addMovimento() {
		this.movimentos++;
	}
	
	/*private void qtdMovimentos() {
		System.out.println("Quantidade de movimentos: " + this.movimentos);
	}
	
	private void resetMovimentos() {
		this.movimentos = 0;
	}*/
	
	public long getQtdMovimentos() {
		return this.movimentos;
	}
}