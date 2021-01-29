package ed2.atividade08;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import ed2.atividade05.LeitorDeArquivo;

public class Main {

	public static void main(String[] args) throws IOException {
		
		LeitorDeArquivo l = new LeitorDeArquivo();
		
		int[] lista = l.lerArquivo("C:\\Users\\mbacc\\git\\ED2\\ED2\\dadosa.txt");
		//System.out.println(Arrays.toString(lista));
		
		OrdenacaoIV o = new OrdenacaoIV();
		
		Instant tempoInicial = Instant.now();
		
		System.out.println(Arrays.toString(o.countingSort(lista)));
		
		Instant tempoFinal = Instant.now();
		
		Duration  tempoDecorrido = Duration.between(tempoInicial, tempoFinal);
		
		String tempo = tempoDecorrido.toHoursPart()+":"+tempoDecorrido.toMinutesPart()+":"
				+tempoDecorrido.toSecondsPart()+":"+tempoDecorrido.toMillisPart();
		
		System.out.println("Tempo de execu��o: " + tempo);
		
		l.gravarArquivoOrdenado("Marcos Ant�nio Baccin Paulino", o.getQtdMovimentos(), tempo,
				Arrays.toString(lista), "dadosaCountingSort.txt");
	}
	
}