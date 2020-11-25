package ed2.atividade01;

import javax.swing.JOptionPane;

public class Ex03_AlunosMedia {

	static String[] cadastrarAlunos(String[] alunos) {
		
		for(int i = 0; i < alunos.length; i++) {
			alunos[i] = JOptionPane.showInputDialog(i+1 + "° ALUNO:");
		}
		
		return alunos;
	}
	
	static double[] registrarNotasProva01(double[] notasProva01, String[] alunos){
		
		for(int i = 0; i < 5; i++) {
			notasProva01[i] = Double.parseDouble(JOptionPane.showInputDialog(alunos[i] + " nota na prova 1:"));
		}
		
		return notasProva01;
	}
	
	static double[] registrarNotasProva02(double[] notasProva02, String[] alunos){
		
		for(int i = 0; i < 5; i++) {
			notasProva02[i] = Double.parseDouble(JOptionPane.showInputDialog(alunos[i] + " nota na prova 2:"));
		}
		
		return notasProva02;
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
		notasProva01 = registrarNotasProva01(notasProva01, alunos);
		notasProva02 = registrarNotasProva02(notasProva02, alunos);
		medias = calcularMedias(notasProva01, notasProva02, medias);
		status = definirStatusDosAlunos(medias, status);
		
		for(int i = 0; i < alunos.length; i++) {
			System.out.printf("%s || Notas: %.1f , %.1f || Média: %.1f || Status: %s\n", 
					alunos[i], notasProva01[i], notasProva02[i], medias[i], status[i]);
		}
	}
}