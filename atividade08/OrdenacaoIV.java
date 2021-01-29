package ed2.atividade08;

import java.util.Arrays;

public class OrdenacaoIV {

	private long movimentos = 0;
	
	public int[] radixSort(int[] lista) {
		
        int numeroDeDigitos = 1;
        int[][] balde = new int[20][lista.length > 19 ? lista.length : 20];
        
        for(int i = 1, ordem = 0; i <= numeroDeDigitos; ordem = 0) {
            
            boolean gastoDeDigitos = false;
            int[] qtdNumeros = new int[20];
            
            for(int num : lista) {
                
                int digito = (num / i) % 10;
                
                digito += 10;
                balde[digito][qtdNumeros[digito]++] = num;
            
                if(num >= (numeroDeDigitos * 10) && !gastoDeDigitos) {
                    
                	numeroDeDigitos *= 10;
                	gastoDeDigitos = true;
                }
            }
            
            for(int j = 0; j < 20; j++) {
                for (int k = 0; k < qtdNumeros[j]; k++) {
                    lista[ordem++] = balde[j][k];
                }
            }
            
            i *= 10;
        }

        return lista;
    }
	
	public int[] gnomeSort(int[] lista) {
		
		int index = 0;
		
		while(index < lista.length) {
			
			if(index == 0)
                index++;
            
			if(lista[index] >= lista[index - 1])
                index++;
            
			else {
                
				int temp = 0; 
                
				temp = lista[index]; 
                lista[index] = lista[index - 1]; 
                lista[index - 1] = temp; 
                index--;
                
                addMovimento();
            }
		}
		
		return lista;
	}
	
	public int[] countingSort(int[] lista) {
		
		int maximo = Arrays.stream(lista).max().getAsInt();
		int minimo = Arrays.stream(lista).min().getAsInt();
		int range = maximo - minimo + 1;
		int contador[] = new int[range];
		int saida[] = new int[lista.length];
		
		for(int i = 0; i < lista.length; i++) {
            contador[lista[i] - minimo]++;
        }
 
        for(int i = 1; i < contador.length; i++) {
            contador[i] += contador[i - 1];
        }
 
        for(int i = lista.length - 1; i >= 0; i--) {
            
        	saida[contador[lista[i] - minimo] - 1] = lista[i];
            contador[lista[i] - minimo]--;
        }
 
        for(int i = 0; i < lista.length; i++) {
            lista[i] = saida[i];
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