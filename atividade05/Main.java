package ed2.atividade05;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

//import com.sun.tools.javac.code.Attribute.Array;

public class Main {

	public static void main(String[] args) throws IOException {
		
		LeitorDeArquivo l = new LeitorDeArquivo();
		
		int[] lista = l.lerArquivo("C:\\Users\\mbacc\\git\\ED2\\ED2\\dadosa.txt");
		System.out.println(Arrays.toString(lista));
		
		Ordenacao o = new Ordenacao();
		
		Instant tempoInicial = Instant.now();
		
		System.out.println(Arrays.toString(o.combSort(lista)));
		
		Instant tempoFinal = Instant.now();
		
		Duration  tempoDecorrido = Duration.between(tempoInicial, tempoFinal);
		
		String tempo = tempoDecorrido.toHoursPart()+":"+tempoDecorrido.toMinutesPart()+":"
				+tempoDecorrido.toSecondsPart()+":"+tempoDecorrido.toMillisPart();
		
		System.out.println("Tempo de execução: " + tempo);
		
		l.gravarArquivoOrdenado("Marcos Antônio Baccin Paulino", o.getQtdMovimentos(), tempo,
				Arrays.toString(lista), "dadosaCombSort.txt");
	}
}