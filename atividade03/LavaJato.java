package ed2.atividade03;

import java.util.ArrayDeque;
import java.util.Queue;

public class LavaJato {

	private Queue<Veiculo> filaDeEspera;
	private Queue<Veiculo> filaDeSaida;
	
	public LavaJato() {
		this.filaDeEspera = new ArrayDeque<Veiculo>();
		this.filaDeSaida = new ArrayDeque<Veiculo>();
	}
	
	public void adicionar(Veiculo veiculo) {
		filaDeEspera.add(veiculo);
		System.out.println(veiculo.getModelo() + ", " +veiculo.getId() + ", adicionado na fila de espera.");
	}
	
	public void remover() {
		System.out.println(filaDeEspera.peek().getModelo() + ", " + filaDeEspera.peek().getId() + ", foi lavado.");
		filaDeSaida.add(filaDeEspera.remove());
	}
	
	public void infoEspera() {
		System.out.println("=============================================================");
		System.out.println("Veículos na fila de espera:");
		for(Veiculo v : this.filaDeEspera) {
			System.out.println(v.toString());
		}
		System.out.println("=============================================================");
	}
	
	public void infoSaida() {
		System.out.println("=============================================================");
		System.out.println("Veículos lavados:");
		for(Veiculo v : this.filaDeSaida) {
			System.out.println(v.toString());
		}
		System.out.println("=============================================================");
	}
	
	public void start(Veiculo[] veiculos) {
		
		int controlador = 0;
		
		for(int i = 0; i < veiculos.length; i++) {
			
			if(controlador == 3) {
				this.remover();
				controlador = 0;
				
				
			}
			
			this.adicionar(veiculos[i]);
			controlador++;
			
			this.infoEspera();
			this.infoSaida();
		}
		
		while(!filaDeEspera.isEmpty()) {
			this.remover();
			this.infoEspera();
			this.infoSaida();
		}
	}
}