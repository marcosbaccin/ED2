package ed2.atividade01;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Ex02_VetorInteiros {

	static int[] inicializarVetor(int[] numeros) {
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(i+1 + "° NÚMERO:"));
		}
		
		return numeros;
	}
	
	static void ordemCrescente(int[] numeros) {
		
		Arrays.sort(numeros);
		System.out.println("VETOR EM ORDEM CRESCENTE: " + Arrays.toString(numeros));
	}
	
	static void ordemDecrescente(int[] numeros) {
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = -numeros[i];
		}
		
		Arrays.sort(numeros);
		
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = -numeros[i];
		}
		
		System.out.println("VETOR EM ORDEM DECRESCENTE: " + Arrays.toString(numeros));
	}
	
	static void somaPares(int[] numeros) {
		
		ArrayList<Integer> pares = new ArrayList<Integer>();
		int soma = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] % 2 == 0) {
				pares.add(numeros[i]);
				soma += numeros[i];
			}
		}
		
		System.out.println("SOMA DOS PARES " + pares.toString() + " = " + soma);
	}
	
	static void produtoImpares(int[] numeros) {
		
		ArrayList<Integer> impares = new ArrayList<Integer>();
		int produto = 1;
		
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] % 2 != 0) {
				impares.add(numeros[i]);
				produto *= numeros[i];
			}
		}
		
		System.out.println("PRODUTO DOS ÍMPARES " + impares.toString() + " = " + produto);
	}
	
	public static void main(String[] args) {
		
		int[] numeros = new int[15];
		
		numeros = inicializarVetor(numeros);
		
		ordemCrescente(numeros);
		ordemDecrescente(numeros);
		somaPares(numeros);
		produtoImpares(numeros);
	}
}