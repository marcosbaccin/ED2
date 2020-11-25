package ed2.atividade01;

import javax.swing.JOptionPane;

public class Ex01_EncontrarNomeNoVetor {

	static String[] inicializarVetor(String[] nomes) {
		
		for(int i = 0; i < nomes.length; i++) {
			nomes[i] = JOptionPane.showInputDialog(i+1 + "° NOME:");
		}
		
		return nomes;
	}
	
	static void verificarNome(String encontra, String[] nomes) {
		
		for(int i = 0; i < nomes.length; i++) {
			if(nomes[i].equals(encontra)) {
				System.out.println(encontra + " encontra-se na posição " + i + " do vetor!");
				return;
			}
		}
		
		System.out.println("Nome não encontrado.");
	}
	
	public static void main(String[] args) {
		
		String[] nomes = new String[5];
		
		nomes = inicializarVetor(nomes);
		
		String encontra = JOptionPane.showInputDialog("Informe o nome a ser verificado:");
		
		verificarNome(encontra, nomes);
	}
}