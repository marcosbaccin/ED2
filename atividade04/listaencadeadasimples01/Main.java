package ed2.atividade04.listaencadeadasimples01;

public class Main {

	public static void main(String[] args) {
		
		ListaLigada lista = new ListaLigada();
		
		Paciente p1 = new Paciente("Gomes", 25, 'M');
		Paciente p2 = new Paciente("Maria", 68, 'F');
		Paciente p3 = new Paciente("Pedro", 14, 'M');
		Paciente p4 = new Paciente("Ana", 56, 'F');
		Paciente p5 = new Paciente("Franciso", 64, 'M');
		
		lista.adiciona(p1);
		lista.adiciona(p3);
		lista.adiciona(p5);
		lista.adiciona(p2);
		lista.adiciona(p4);
		
		lista.imprimirDados();
		
		lista.removeDoComeco();
		
		Paciente p6 = new Paciente("Luana", 34, 'F');
		Paciente p7 = new Paciente("Geraldo", 40, 'M');
		
		lista.adiciona(3, p6);
		lista.adiciona(2, p7);
		
		lista.imprimirDados();
	}
}