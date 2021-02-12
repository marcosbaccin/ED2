package ed2.atividade10;

public class ArvoreBinaria01 {

	public static void main(String[] args) {
		
		NoArvore tree = new NoArvore();
		int qtdPrimos = 1;
		int num = 2;
		
		tree.insereRaiz(tree, num);
		
		num++;
		
		while(qtdPrimos < 1000) {
			
			if(ePrimo(num)) {
				
				qtdPrimos++;
				tree.insere(tree, num);
			}
			
			num++;
		}
		
		tree.impPreOrdem(tree); System.out.println();
		tree.impEmOrdem(tree); System.out.println();
		tree.impPosOrdem(tree); System.out.println();
		
		tree = removerMenorPrimo(tree);
		
		System.out.println();
		
		tree.impPreOrdem(tree); System.out.println();
		tree.impEmOrdem(tree); System.out.println();
		tree.impPosOrdem(tree); System.out.println();
	}
	
	static boolean ePrimo(int num) {
		
		if(num == 1) {
			return true;
		}
		
		int contador = 2;
		boolean primo = true;
		
		while((primo) && (contador != num)) {
			
			if(num % contador == 0) {
				primo = false;
			}
			
			contador++;
		}
		
		return primo;
	}
	
	static NoArvore removerMenorPrimo(NoArvore tree) {
		
		int intervalo = 0;
		int contador = 2;
		int maior = tree.maior(tree);
		
		while (contador <= maior) {
			
			if(ePrimo(contador)) {
				
				tree = tree.retira(tree, contador);
				
				intervalo += 100;
				contador = intervalo;
			}
			
			else contador++;
		}
		
		return(tree);
	}
}