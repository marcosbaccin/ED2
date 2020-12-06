package ed2.atividade02;

import java.util.Scanner;

public class TorreDeHanoi {

	static void registrar(int origem, int destino) {
		
		System.out.println(origem + " -> " + destino);
	}
	
	static void calcularQtdDeMovimentos(int numDiscos) {
		int qtd = (int) (Math.pow(2, numDiscos) - 1);
		System.out.println("Quantidade de movimentos: " + qtd);
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
		
		movimentar(numDiscos, 1, 3, 2);
		calcularQtdDeMovimentos(numDiscos);
		
		scan.close();
	}
}