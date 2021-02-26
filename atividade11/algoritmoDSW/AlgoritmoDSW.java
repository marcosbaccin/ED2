package ed2.atividade11.algoritmoDSW;

import ed2.atividade10.NoArvore;

public class AlgoritmoDSW {

	private NoArvore leftRotate(NoArvore tree) {
		
		if(tree.getDireita() != null) {
			
			NoArvore rightChild = tree.getDireita();
			tree.setDireita(rightChild.getDireita());
			rightChild.setDireita(rightChild.getEsquerda());
			rightChild.setEsquerda(tree.getEsquerda());
			tree.setEsquerda(rightChild);
			
			int temp = tree.getInfo();
			tree.setInfo(rightChild.getInfo());
			rightChild.setInfo(temp);
		}
		
		return tree;
	}
	
	/*private NoArvore rightRotate(NoArvore tree) {
		
		if(tree.getEsquerda() != null) {
			
			NoArvore leftChild = tree.getEsquerda();
			tree.setEsquerda(leftChild.getEsquerda());
			leftChild.setEsquerda(leftChild.getDireita());
			leftChild.setDireita(tree.getDireita());
			tree.setDireita(leftChild);
			
			int temp = tree.getInfo();
			tree.setInfo(leftChild.getInfo());
			leftChild.setInfo(temp);
		}
		
		return tree;
	}*/
	
	/*private NoArvore createRightTree(NoArvore tree) {
		
		while(tree.getEsquerda() != null) {
			tree = rightRotate(tree);
		}
		
		if(tree.getDireita() != null)
			tree.setDireita(createRightTree(tree.getDireita()));
		
		return tree;
	}*/
	
	public int getNodeCount(NoArvore tree) {
		
		if(tree == null)
			return 0;
		
		int i = 1;
		
		while(tree.getDireita() != null) {
			
			tree = tree.getDireita();
			i++;
		}
		
		return i;
	}
	
	public NoArvore balanceTree(NoArvore tree, int nodeCount) {
		
		int times = (int)Math.log(nodeCount);
		NoArvore newTree = tree;
		
		for(int i = 0; i < times; i++) {
			
			newTree = leftRotate(newTree);
			tree = newTree.getDireita();
			
			for(int j = 0; j < nodeCount / 2 - 1; j++) {
				
				tree = leftRotate(tree);
				tree = tree.getDireita();
			}
			
			nodeCount >>= 1;
		}
		
		return newTree;
	}
}