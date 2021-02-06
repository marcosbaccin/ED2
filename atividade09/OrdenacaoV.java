package ed2.atividade09;

public class OrdenacaoV {

	private long movimentos = 0;
	//private static int RUN = 32;
	
	public int[] bucketSort(int[] lista) {
		
		//CONTA A QTD DE NÚMEROS NEGATIVOS E POSITIVOS EM 'LISTA'
		int qtdNeg = 0, qtdPos = 0;
		
		for(int i = 0; i < lista.length; i++) {
			
			if(lista[i] < 0) {
				qtdNeg++;
			}
			else {
				qtdPos++;
			}
		}
		
		//POPULA OS VETORES DE NEGATIVOS E POSITIVOS
		int[] negativos = new int[qtdNeg];
		int[] positivos = new int[qtdPos];
		
		int indexNeg = 0, indexPos = 0;
		
		for(int i = 0; i < lista.length; i++) {
			
			if(lista[i] < 0) {
				
				negativos[indexNeg] = lista[i];
				indexNeg++;
			}
			else {
				
				positivos[indexPos] = lista[i];
				indexPos++;
			}
		}
		
		
		int maxValue = maxValue(lista);
		int minValue = minValue(lista);
		
		//ORDENANDO 'NEGATIVOS'
		int[] bucket_neg = new int[minValue + 1];
        int[] sorted_numsNeg = new int[negativos.length];
        int[] neg_sorted = new int[negativos.length];
        
        for(int i = 0; i < negativos.length; i++) {
        	negativos[i] *= -1;
        }
        
        for(int i = 0; i < negativos.length; i++)
            bucket_neg[negativos[i]]++;
        
        int outPosition_neg = 0;
        
        for(int i = 0; i < bucket_neg.length; i++)
            for (int j = 0; j < bucket_neg[i]; j++)
                sorted_numsNeg[outPosition_neg++] = i;
        
        for(int i = 0; i < negativos.length; i++) {
        	sorted_numsNeg[i] *= -1;
        }
        
        int idx = 0;
        
        for(int i = negativos.length-1; i >= 0; i--) {
        	
        	neg_sorted[idx] = sorted_numsNeg[i];
        	idx++;
        }
        
        //ORDENANDO 'POSITIVOS'
  		int[] bucket_pos = new int[maxValue + 1];
        int[] sorted_numsPos = new int[positivos.length];
          
        for(int i = 0; i < positivos.length; i++)
            bucket_pos[positivos[i]]++;
          
        int outPosition_pos = 0;
          
        for(int i = 0; i < bucket_pos.length; i++)
            for (int j = 0; j < bucket_pos[i]; j++)
                sorted_numsPos[outPosition_pos++] = i;
        
        //ORDENANDO 'LISTA'
        int aux = 0;
        
        for(int i = 0; i < neg_sorted.length; i++) {
        	
        	lista[aux] = neg_sorted[i];
        	aux++;
        }
        
        for(int i = 0; i < sorted_numsPos.length; i++) {
        	
        	lista[aux] = sorted_numsPos[i];
        	aux++;
        }
          
        
		return lista;
	}
	
	private int maxValue(int[] lista) {
		
		int maxValue = lista[0];
		
		for(int i = 0; i < lista.length; i++)
            
			if(lista[i] > maxValue)
                maxValue = lista[i];
		
		return maxValue;
	}
	
	private int minValue(int[] lista) {
		
		int minValue = lista[0];
		
		for(int i = 0; i < lista.length; i++)
            
			if(lista[i] < minValue)
                minValue = lista[i];
		
		return Math.abs(minValue);
	}
	
	public int[] cocktailSort(int[] lista) {
		
		boolean swapped = true;
        int start = 0;
        int end = lista.length;
        
        while(swapped == true) {
        	
        	swapped = false;
        	
        	for(int i = start; i < end - 1; ++i) {
                
        		if (lista[i] > lista[i + 1]) {
                    
        			int temp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = temp;
                    swapped = true;
                    
                    addMovimento();
                }
            }
        	
        	if (swapped == false)
                break;
        	
        	swapped = false;
        	end = end - 1;
        	
        	for(int i = end - 1; i >= start; i--) {
                
        		if (lista[i] > lista[i + 1]) {
                    
        			int temp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = temp;
                    swapped = true;
                    
                    addMovimento();
                }
            }
        	
        	start = start + 1;
        }
		
		return lista;
	}
	
	/*public int[] timSort(int[] arr) {
		
		int n = arr.length;

        for (int i = 0; i < n; i += RUN)
            arr = insertionSort(arr, i, Math.min((i+31), (n-1)));

        for (int size = RUN; size < n; size = 2*size) {

            for (int left = 0; left < n; left += 2*size) {

                int mid = Math.min((left + size - 1), (n-1));
                int right = Math.min((left + 2*size - 1), (n-1));
                arr = merge(arr, left, mid, right);
            }
        }
        
        return arr;
    }
	
	public int[] insertionSort(int[] arr, int left, int right) {

        for(int i = left + 1; i <= right; i++) {

            int temp = arr[i];
            int j = i - 1;

            while (arr[j] > temp && j >= left) {

                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
        }
        
        return arr;
    }
	
	public int[] merge(int[] arr, int l, int m, int r) {

        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        for(int x = 0; x < len1; x++)
            left[x] = arr[l + x];

        for(int x = 0; x < len2; x++)
            right[x] = arr[m + 1 + x];

        int i = 0;
        int j = 0;
        int k = l;

        while(i < len1 && j < len2) {

            if(left[i] <= right[j]) {

                arr[k] = left[i];
                i++;
            }
            else {

                arr[k] = right[j];
                j++;
            }

            k++;
        }

        while(i < len1) {

            arr[k] = left[i];
            k++;
            i++;
        }

        while(j < len2) {

            arr[k] = right[j];
            k++;
            j++;
        }
        
        return arr;
    }*/
	
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