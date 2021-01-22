package ed2.atividade07;

public class OrdenacaoIII {

	private long movimentos = 0;
	
	public int[] heapSort(int[] lista) {
		
		int n = lista.length;
		  
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(lista, n, i);
  
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--) {
            // Move current root to end
            int temp = lista[0];
            lista[0] = lista[i]; 
            lista[i] = temp;
            
            addMovimento();
  
            // Call max heapify on the reduced heap
            heapify(lista, i, 0); 
        } 
		
		return lista;
	}
	
	private void heapify(int[] lista, int n, int i) {
		
		int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
  
        // If left child is larger than root
        if (l < n && lista[l] > lista[largest])
            largest = l;
  
        // If right child is larger than largest so far
        if (r < n && lista[r] > lista[largest])
            largest = r;
  
        // If largest is not root
        if (largest != i) {
            
        	int swap = lista[i];
            lista[i] = lista[largest];
            lista[largest] = swap;
            
            addMovimento();
  
            // Recursively heapify the affected sub-tree
            heapify(lista, n, largest);
        } 
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