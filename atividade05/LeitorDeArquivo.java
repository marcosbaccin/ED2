package ed2.atividade05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeitorDeArquivo {
	
	public int[] lerArquivo(String arquivo) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		
		String line = null;
		String[] valores;
		int[] valoresInt = null;
		
		while((line = br.readLine()) != null) {
			
			valores = line.split(", ");
			valoresInt = new int[valores.length];
		    
			for (int i = 0; i < valores.length; i++) {

			    try {
			        valoresInt[i] = Integer.parseInt(valores[i]);
			    }
			    catch (NumberFormatException nfe) {
			        continue;
			    }
			}
		}
		
		br.close();
		
		return valoresInt;
	}
	
	public void gravarArquivoOrdenado(String nomeDesenvolvedor, int qtdMovimentos, String tempo,
			String vetorOrdenado, String nomeArquivo) throws IOException {
		
		FileWriter arq = new FileWriter("C:\\Users\\mbacc\\Desktop\\" + nomeArquivo);
	    PrintWriter gravarArq = new PrintWriter(arq);
	    
	    gravarArq.printf("Desenvolvedor: %s%n", nomeDesenvolvedor);
	    gravarArq.printf("Movimentos: %d%n", qtdMovimentos);
	    gravarArq.printf("Tempo: %s%n", tempo);
	    gravarArq.printf("Vetor ordenado: %s%n", vetorOrdenado);
	    
	    gravarArq.close();
	    arq.close();
	}
}