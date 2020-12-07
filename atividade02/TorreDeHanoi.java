package ed2.atividade02;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class TorreDeHanoi {

	static long numMovimentos;
	
	static void registrar(int origem, int destino) {
		
		numMovimentos++;
		System.out.println("[" + numMovimentos + "]: " + origem + " -> " + destino);
	}

	static void movimentar(int numDiscos, int origem, int destino, int trabalho) {

		if(numDiscos > 0) {
			movimentar(numDiscos - 1, origem, trabalho, destino);
			registrar(origem, destino);
			movimentar(numDiscos - 1, trabalho, destino, origem);
		}
	}
	
	public static void main(String[] args) {
		
		int numDiscos;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o número de discos: ");
		numDiscos = scan.nextInt();
		
		Instant tempoInicial = Instant.now();
		
		movimentar(numDiscos, 1, 3, 2);
		
		Instant tempoFinal = Instant.now();
		
		Duration  tempoDecorrido = Duration.between(tempoInicial, tempoFinal);
		
		String tempo = tempoDecorrido.toHoursPart()+":"+tempoDecorrido.toMinutesPart()+":"
						+tempoDecorrido.toSecondsPart()+":"+tempoDecorrido.toMillisPart();
		
		System.out.println("Tempo de execução para " + numDiscos + " discos: " + tempo);
		
		scan.close();
	}
}