package ed2.atividade04.listaduplamenteencadeada;

public class Main {

	public static void main(String[] args) {
	
		ListaDupla lista = new ListaDupla();
		
		//Adicione Homer e Marge na lista e depois imprima o resultado.
		
		lista.adiciona("Homer");
		lista.adiciona("Marge");
		System.out.println(lista.imprimir());
		
		//Esvazie a lista e imprima.
		
		lista.esvaziaLista();
		System.out.println(lista.imprimir());
		
		/*Adicione Homer na lista.
		Depois adicione Bart na posição 0 e Camila na posição 1 e imprima a lista.*/
		
		lista.adiciona("Homer");
		lista.adiciona(0, "Bart");
		lista.adiciona(1, "Camila");
		System.out.println(lista.imprimir());
		
		//Esvazie a lista.
		
		lista.esvaziaLista();
		
		/*Adicione Homer e Bart na lista e depois adicione Lisa no início da lista.
		Imprima o resultado e o tamanho da lista.*/
		
		lista.adiciona("Homer");
		lista.adiciona("Bart");
		lista.adicionaNoComeco("Lisa");
		System.out.println(lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		//Esvazie a lista e imprima.
		
		lista.esvaziaLista();
		System.out.println(lista.imprimir());
		
		/*Adicione Homer, Maggie na lista.
		Depois adicione Bart na posição 0 e Marge na posição 1 e imprima a lista.
		Verifique se Lisa está na lista.*/
		
		lista.adiciona("Homer");
		lista.adiciona("Maggie");
		lista.adiciona(0, "Bart");
		lista.adiciona(1, "Marge");
		System.out.println(lista.imprimir() + ", CONTÉM LISA: " + lista.contem("Lisa"));
		
		//Esvazie a lista.
		
		lista.esvaziaLista();
		
		//Adicione Homer e Bart na lista e depois imprima o resultado e o tamanho da lista.
		
		lista.adiciona("Homer");
		lista.adiciona("Bart");
		System.out.println(lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		//Verifique se Marge, Homer, Bart e Maggie estão na lista e depois imprima o resultado e o tamanho da lista.
		
		System.out.println("CONTÉM HOMER, BART E MAGGIE: " + lista.contem("Homer") + ", " +
				lista.contem("Bart") + ", " + lista.contem("Maggie") + " || " +
				lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		//Esvazie a lista.
		
		lista.esvaziaLista();
		
		/*Adicione Homer e Bart no começo da lista.
		Depois adicione Marge, e depois Maggie na posição 1
		e depois Jose no começo da lista e Sr. Burns no final da lista imprima a lista.*/
		
		lista.adiciona("Homer");
		lista.adicionaNoComeco("Bart");
		lista.adiciona("Marge");
		lista.adiciona(1, "Maggie");
		lista.adicionaNoComeco("Jose");
		lista.adiciona("Sr. Burns");
		System.out.println(lista.imprimir());
		
		//Remova do fim da lista e imprima a lista.
		
		lista.removeDoFim();
		lista.imprimir();
		System.out.println(lista.imprimir());
		
		//Remova a posição 1, depois imprima a lista e o tamanho da lista.

		lista.remove(1);
		System.out.println(lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		/*Verifique se Marge, Homer, Bart e Maggie estão na lista
		e depois imprima o resultado e o tamanho da lista.*/
		
		System.out.println("CONTÉM MARGE, HOMER, BART E MAGGIE: " + lista.contem("Marge") + ", " +
				lista.contem("Homer") + ", " + lista.contem("Bart") + ", " + lista.contem("Maggie") +
				" || " + lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		//Remova do começo da lista, depois imprima a lista e o tamanho da lista.
		
		lista.removeDoComeco();
		System.out.println(lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		/*Verifique se Marge, Homer, Bart e Maggie na lista
		e depois imprima o resultado e o tamanho da lista.*/
		
		System.out.println("CONTÉM MARGE, HOMER, BART E MAGGIE: " + lista.contem("Marge") + ", " +
				lista.contem("Homer") + ", " + lista.contem("Bart") + ", " + lista.contem("Maggie") +
				" || " + lista.imprimir() + ", TAMANHO: " + lista.tamanho());
		
		//Esvazie a lista e imprima.
		
		lista.esvaziaLista();
		System.out.println(lista.imprimir());
	}
}