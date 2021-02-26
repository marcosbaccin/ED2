package ed2.atividade11.algoritmoDoVetor;

import java.util.Vector;

import ed2.atividade10.NoArvore;

public class AlgoritmoDoVetor {
	
	//Esta fun��o atravessa a �rvore bin�ria distorcida e armazena seus ponteiros de n�s em n�s de vetor []
	private void storeBSTNodes(NoArvore tree, Vector<NoArvore> nos) {
	
	//Caso base
	if(tree == null)
		return;
	
	//Armazena n�s na ordem (que � a ordem de classifica��o para BST)
    storeBSTNodes(tree.getEsquerda(), nos);
    nos.add(tree);
    storeBSTNodes(tree.getDireita(), nos);
	}
	
	//Fun��o recursiva para construir �rvore bin�ria
    private NoArvore buildTreeUtil(Vector<NoArvore> nos, int start, int end) {
    	
    	//Caso base
    	if(start > end)
    		return null;
    	
    	//Obtenha o elemento do meio e torne-o raiz
        int mid = (start + end) / 2;
        NoArvore no = nos.get(mid);
        
        //Usando o �ndice na travessia da ordem, construir as sub�rvores esquerda e direita
        no.setEsquerda(buildTreeUtil(nos, start, mid - 1));
        no.setDireita(buildTreeUtil(nos, mid + 1, end));

        return no;
    }
    
    //Esta fun��o converte um BST n�o balanceado em um BST balanceado
    public NoArvore buildTree(NoArvore tree) {
    	
    	//Armazena n�s de determinado BST em ordem de classifica��o
        Vector<NoArvore> nos = new Vector<NoArvore>();
        storeBSTNodes(tree, nos);
        
        //Construir BST a partir de n�s []
        int n = nos.size();
        return buildTreeUtil(nos, 0, n - 1);
    }
}