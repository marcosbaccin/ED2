package ed2.atividade01;

import javax.swing.JOptionPane;

public class Ex03_AlunosMedia {

	static String[] cadastrarAlunos(String[] alunos) {
		
		for(int i = 0; i < alunos.length; i++) {
			alunos[i] = JOptionPane.showInputDialog(i+1 + "° ALUNO:");
		}
		
		return alunos;
	}
	
	static double[] registrarNotas(double[] notas, String[] alunos, String titulo){
		
		for(int i = 0; i < 5; i++) {
			notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, alunos[i] + ", nota:", titulo, 1));
		}
		
		return notas;
	}
	
	static double[] calcularMedias(double[] notasProva01, double[] notasProva02, double[] medias) {
		
		for(int i = 0; i < medias.length; i++) {
			medias[i] = (notasProva01[i] + notasProva02[i]) / 2;
		}
		
		return medias;
	}
	
	static String[] definirStatusDosAlunos(double[] medias, String[] status) {
		
		for(int i = 0; i < status.length; i++) {
			if(medias[i] >= 6) {
				status[i] = "AP";
			} else {
				status[i] = "RP";
			}
		}
		
		return status;
	}
	
	public static void main(String[] args) {
		
		String[] alunos = new String[5];
		double[] notasProva01 = new double[5];
		double[] notasProva02 = new double[5];
		double[] medias = new double[5];
		String[] status = new String[5];
		
		alunos = cadastrarAlunos(alunos);
		notasProva01 = registrarNotas(notasProva01, alunos, "PROVA 01");
		notasProva02 = registrarNotas(notasProva02, alunos, "PROVA 02");
		medias = calcularMedias(notasProva01, notasProva02, medias);
		status = definirStatusDosAlunos(medias, status);
		
		for(int i = 0; i < alunos.length; i++) {
			System.out.printf("%s || Notas: %.1f , %.1f || Média: %.1f || Status: %s\n", 
					alunos[i], notasProva01[i], notasProva02[i], medias[i], status[i]);
		}
	}
}