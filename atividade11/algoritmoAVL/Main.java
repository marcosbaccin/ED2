package ed2.atividade11.algoritmoAVL;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {

	static ArvoreAVL createRandomTree(ArvoreAVL tree, int qtd) {
		
		Random gerador = new Random();
		
		for(int i = 1; i < qtd; i++) {
			
			tree.root = tree.insert(tree.root, gerador.nextInt(10000));
		}
		
		return tree;
	}
	
	static ArvoreAVL verificarPrimos(ArvoreAVL tree) {
		
		int [] dezPrimos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
		
		System.out.print("Dez primeiros primos encontrados: ");
		
		for(int i = 0; i < dezPrimos.length; i++) {
			
			if(tree.search(tree.root, dezPrimos[i]) != null) {
				
				System.out.print(dezPrimos[i] + ", ");
				
				tree.root = tree.deleteNode(tree.root, dezPrimos[i]);
			}
		}
		
		System.out.println("");
		
		return tree;	
	}
	
	static ArvoreAVL verificarMultiplosDe5(ArvoreAVL tree) {
		
		System.out.print("Múltiplo(s) de 5 encontrado(s): ");
		
		for(int i = 5; i < 10000; i += 5) {
			
			while(true) {
				
				if(tree.search(tree.root, i) != null) {
					
					System.out.print(i + ", ");
					
					tree.root = tree.deleteNode(tree.root, i);
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
		
		
		ArvoreAVL tree = new ArvoreAVL();
		tree = createRandomTree(tree, 100);
		tree.preOrder(tree.root);
		System.out.println("");
		
		//a)
		Instant tempoInicialA = Instant.now();
		
		tree = verificarPrimos(tree);
		//tree.preOrder(tree.root);
		//System.out.println("");
		
		Instant tempoFinalA = Instant.now();
		Duration  tempoDecorridoA = Duration.between(tempoInicialA, tempoFinalA);
		String tempoA = tempoDecorridoA.toHoursPart()+":"+tempoDecorridoA.toMinutesPart()+":"
				+tempoDecorridoA.toSecondsPart()+":"+tempoDecorridoA.toMillisPart();
		System.out.println("Tempo de execução de A: " + tempoA);
		
		//b)
		Instant tempoInicialB = Instant.now();
		
		tree = verificarMultiplosDe5(tree);
		//tree.preOrder(tree.root);
		//System.out.println("");
		
		Instant tempoFinalB = Instant.now();
		Duration  tempoDecorridoB = Duration.between(tempoInicialB, tempoFinalB);
		String tempoB = tempoDecorridoB.toHoursPart()+":"+tempoDecorridoB.toMinutesPart()+":"
				+tempoDecorridoB.toSecondsPart()+":"+tempoDecorridoB.toMillisPart();
		System.out.println("Tempo de execução de B: " + tempoB);
		
		//c)
		Instant tempoInicialC = Instant.now();
		
		tree = createRandomTree(tree, 100);
		tree.inOrder(tree.root);
		System.out.println("");
		
		Instant tempoFinalC = Instant.now();
		Duration  tempoDecorridoC = Duration.between(tempoInicialC, tempoFinalC);
		String tempoC = tempoDecorridoC.toHoursPart()+":"+tempoDecorridoC.toMinutesPart()+":"
				+tempoDecorridoC.toSecondsPart()+":"+tempoDecorridoC.toMillisPart();
		System.out.println("Tempo de execução de C: " + tempoC);
		
		//d)
		Instant tempoInicialD = Instant.now();
		
		tree = verificarPrimos(tree);
		tree = verificarMultiplosDe5(tree);
		
		Instant tempoFinalD = Instant.now();
		Duration  tempoDecorridoD = Duration.between(tempoInicialD, tempoFinalD);
		String tempoD = tempoDecorridoD.toHoursPart()+":"+tempoDecorridoD.toMinutesPart()+":"
				+tempoDecorridoD.toSecondsPart()+":"+tempoDecorridoD.toMillisPart();
		System.out.println("Tempo de execução de D: " + tempoD);
		
		tree.preOrder(tree.root);
	}
}