package ed2.atividade11.algoritmoDSW;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import ed2.atividade10.NoArvore;

public class Main {

	static NoArvore createRandomTree(NoArvore tree, int qtd) {
		
		Random gerador = new Random();
		
		for(int i = 0; i < qtd; i++) {
			
			tree.insere(tree, gerador.nextInt(10000));
		}
		
		return tree;
	}
	
	static NoArvore balancearVetor(NoArvore tree) {
		
		AlgoritmoDSW dsw = new AlgoritmoDSW();
		
		int nodeCount = dsw.getNodeCount(tree);
		
		tree = dsw.balanceTree(tree, nodeCount);
		
		return tree;
	}
	
	static NoArvore verificarPrimos(NoArvore tree) {
		
		int [] dezPrimos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
		
		System.out.print("Dez primeiros primos encontrados: ");
		
		for(int i = 0; i < dezPrimos.length; i++) {
			
			if(tree.search(tree, dezPrimos[i]) != null) {
				
				System.out.print(dezPrimos[i] + ", ");
				
				tree.retira(tree, dezPrimos[i]);
			}
		}
		
		System.out.println("");
		
		return tree;
	}
	
	static NoArvore verificarMultiplosDe5(NoArvore tree) {
		
		System.out.print("Múltiplo(s) de 5 encontrado(s): ");
		
		for(int i = 5; i < 10000; i += 5) {
			
			while(true) {
				
				if(tree.search(tree, i) != null) {
					
					System.out.print(i + ", ");
					
					tree.retira(tree, i);
				}
				else {
					break;
				}
			}
		}
		
		System.out.println("");
		
		return tree;
	}
	
	public static void main(String[] args) {
		
		NoArvore tree = new NoArvore();
		tree = createRandomTree(tree, 5000);
		tree = balancearVetor(tree);
		tree.impPreOrdem(tree);
		System.out.println("");
		
		//a)
		Instant tempoInicialA = Instant.now();
		
		tree = verificarPrimos(tree);
		tree = balancearVetor(tree);
		//tree.impPreOrdem(tree);
		//System.out.println("");
		
		Instant tempoFinalA = Instant.now();
		Duration  tempoDecorridoA = Duration.between(tempoInicialA, tempoFinalA);
		String tempoA = tempoDecorridoA.toHoursPart()+":"+tempoDecorridoA.toMinutesPart()+":"
				+tempoDecorridoA.toSecondsPart()+":"+tempoDecorridoA.toMillisPart();
		System.out.println("Tempo de execução de A: " + tempoA);
		
		//b)
		Instant tempoInicialB = Instant.now();
		
		tree = verificarMultiplosDe5(tree);
		tree = balancearVetor(tree);
		//tree.impPreOrdem(tree);
		//System.out.println("");
		
		Instant tempoFinalB = Instant.now();
		Duration  tempoDecorridoB = Duration.between(tempoInicialB, tempoFinalB);
		String tempoB = tempoDecorridoB.toHoursPart()+":"+tempoDecorridoB.toMinutesPart()+":"
				+tempoDecorridoB.toSecondsPart()+":"+tempoDecorridoB.toMillisPart();
		System.out.println("Tempo de execução de B: " + tempoB);
		
		//c)
		Instant tempoInicialC = Instant.now();
		
		tree = createRandomTree(tree, 100);
		tree = balancearVetor(tree);
		tree.impEmOrdem(tree);
		System.out.println("");
		
		Instant tempoFinalC = Instant.now();
		Duration  tempoDecorridoC = Duration.between(tempoInicialC, tempoFinalC);
		String tempoC = tempoDecorridoC.toHoursPart()+":"+tempoDecorridoC.toMinutesPart()+":"
				+tempoDecorridoC.toSecondsPart()+":"+tempoDecorridoC.toMillisPart();
		System.out.println("Tempo de execução de C: " + tempoC);
		
		//d)
		Instant tempoInicialD = Instant.now();
		
		tree = verificarPrimos(tree);
		tree = balancearVetor(tree);
		tree = verificarMultiplosDe5(tree);
		tree = balancearVetor(tree);
		
		Instant tempoFinalD = Instant.now();
		Duration  tempoDecorridoD = Duration.between(tempoInicialD, tempoFinalD);
		String tempoD = tempoDecorridoD.toHoursPart()+":"+tempoDecorridoD.toMinutesPart()+":"
				+tempoDecorridoD.toSecondsPart()+":"+tempoDecorridoD.toMillisPart();
		System.out.println("Tempo de execução de D: " + tempoD);
		
		tree.impPreOrdem(tree);
	}
}