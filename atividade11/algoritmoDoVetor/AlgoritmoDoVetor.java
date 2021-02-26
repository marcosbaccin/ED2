package ed2.atividade11.algoritmoDoVetor;

import java.util.Vector;

import ed2.atividade10.NoArvore;

public class AlgoritmoDoVetor {
	
	//Esta função atravessa a árvore binária distorcida e armazena seus ponteiros de nós em nós de vetor []
	private void storeBSTNodes(NoArvore tree, Vector<NoArvore> nos) {
	
	//Caso base
	if(tree == null)
		return;
	
	//Armazena nós na ordem (que é a ordem de classificação para BST)
    storeBSTNodes(tree.getEsquerda(), nos);
    nos.add(tree);
    storeBSTNodes(tree.getDireita(), nos);
	}
	
	//Função recursiva para construir árvore binária
    private NoArvore buildTreeUtil(Vector<NoArvore> nos, int start, int end) {
    	
    	//Caso base
    	if(start > end)
    		return null;
    	
    	//Obtenha o elemento do meio e torne-o raiz
        int mid = (start + end) / 2;
        NoArvore no = nos.get(mid);
        
        //Usando o índice na travessia da ordem, construir as subárvores esquerda e direita
        no.setEsquerda(buildTreeUtil(nos, start, mid - 1));
        no.setDireita(buildTreeUtil(nos, mid + 1, end));

        return no;
    }
    
    //Esta função converte um BST não balanceado em um BST balanceado
    public NoArvore buildTree(NoArvore tree) {
    	
    	//Armazena nós de determinado BST em ordem de classificação
        Vector<NoArvore> nos = new Vector<NoArvore>();
        storeBSTNodes(tree, nos);
        
        //Construir BST a partir de nós []
        int n = nos.size();
        return buildTreeUtil(nos, 0, n - 1);
    }
}