package ed2.atividade12.algoritmoAVL;

class Node {
    int key, height;
    Node left, right;
 
    Node(int d) {
        key = d;
        height = 1;
    }
}

public class ArvoreAVL {

	Node root;
	 
    //Uma fun��o de utilidade para obter a altura da �rvore
    private int height(Node n) {
        
    	if(n == null)
            return 0;
 
        return n.height;
    }
    
    //Uma fun��o de utilidade para obter no m�ximo dois inteiros
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    //Uma fun��o de utilidade para girar � direita a sub�rvore enraizada com y
    private Node rightRotate(Node y) {
        
    	Node x = y.left;
        Node t2 = x.right;
 
        //Executar rota��o
        x.right = y;
        y.left = t2;
 
        //Atualizar alturas
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        //Retornar nova raiz
        return x;
    }
    
    //Uma fun��o de utilidade para girar para a esquerda a sub�rvore enraizada com x
    private Node leftRotate(Node x) {
        
    	Node y = x.right;
        Node t2 = y.left;
 
        //Executar rota��o
        y.left = x;
        x.right = t2;
 
        //Atualizar alturas
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        //Retornar nova raiz
        return y;
    }
    
    //Obter fator de equil�brio do n� N
    private int getBalance(Node n) {
        
    	if (n == null)
            return 0;
 
        return height(n.left) - height(n.right);
    }
    
    public Node insert(Node node, int key) {
    	 
        //1. Fa�a a inser��o normal do BST
        if(node == null)
            return (new Node(key));
 
        if(key < node.key)
            node.left = insert(node.left, key);
        
        else if(key > node.key)
            node.right = insert(node.right, key);
        
        else //Chaves duplicadas n�o permitidas
            return node;
 
        //2. Atualize a altura deste n� ancestral
        node.height = 1 + max(height(node.left), height(node.right));
 
        //3. Obtenha o fator de equil�brio deste n� ancestral para verificar se este n� se tornou desequilibrado
        int balance = getBalance(node);
 
        //Se este n� se tornar desequilibrado, ent�o haver� 4 casos Esquerda Caixa
        if(balance > 1 && key < node.left.key)
            return rightRotate(node);
 
        //Caso Direita Direita
        if(balance < -1 && key > node.right.key)
            return leftRotate(node);
 
        //Caso Direita Esquerda
        if(balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        //Caso Esquerda Direita
        if(balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        //retornar o ponteiro do n� (inalterado)
        return node;
    }
    
    //Dada uma �rvore de pesquisa bin�ria n�o vazia, retorna o n� com o valor de chave m�nimo encontrado nessa �rvore. Observe que a �rvore inteira n�o precisa ser pesquisada.
    private Node minValueNode(Node node) {
        
    	Node current = node;
  
    	//Volta para baixo para encontrar a folha mais � esquerda
        while (current.left != null)
        	current = current.left;
  
        return current;
    }
    
    public Node deleteNode(Node root, int key) {
        
    	//PASSO 1: EXECUTAR PADR�O BST DELETE
        if(root == null)
            return root;
  
        //Se a chave a ser exclu�da for menor do que a chave da raiz, ela fica na sub�rvore esquerda
        if(key < root.key)
            root.left = deleteNode(root.left, key);
  
        //Se a chave a ser deletada for maior que a chave da raiz, ent�o ela est� na sub�rvore direita
        else if(key > root.key)
            root.right = deleteNode(root.right, key);
  
        //Se a chave for igual � chave do root, ent�o este � o n� a ser exclu�do
        else {
  
        	//N� com apenas um filho ou nenhum filho
            if((root.left == null) || (root.right == null)) {
                
            	Node temp = null;
                
                if(temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
  
                //Caso sem filho
                if(temp == null) {
                    temp = root;
                    root = null;
                }
                else //Caso um filho
                    root = temp; //Copia o conte�do do filho n�o vazio
            }  
            else {
  
            	//N� com dois filhos: obt�m o sucessor da ordem (o menor na sub�rvore direita)
                Node temp = minValueNode(root.right);
  
                //Copie os dados do sucessor do pedido para este n�
                root.key = temp.key;
  
                //Exclua o sucessor do pedido
                root.right = deleteNode(root.right, temp.key);
            }
        }
  
        //Se a �rvore tinha apenas um n�, ent�o retorna
        if(root == null)
            return root;
  
        //PASSO 2: ATUALIZAR ALTURA DO N� ATUAL
        root.height = max(height(root.left), height(root.right)) + 1;
  
        //PASSO 3: OBTER O FATOR DE EQUIL�BRIO DESTE N� (para verificar se este n� ficou desequilibrado)
        int balance = getBalance(root);
  
        //Se este n� se tornar desequilibrado, ent�o existem 4 casos
        //Caso Esquerda Esquerda
        if(balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
  
        //Caso Direita Esquerda
        if(balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
  
        //Caso Direita Direita
        if(balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
  
        //Caso Esquerda Direita
        if(balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
  
        return root;
    }
    
    //Uma fun��o utilit�ria para imprimir o percurso da pr�-ordem da �rvore. A fun��o tamb�m imprime a altura de cada n�
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
    public void inOrder(Node node) {
    	if(node != null) {
			inOrder(node.left);
			System.out.print(node.key + " ");
			inOrder(node.right);
		}
    }
    
    public Node search(Node tree, int valor) {
		
		if(tree == null) {
			return null;
		}
		
		else if(tree.key > valor) {
			return search(tree.left, valor);
		}
		
		else if(tree.key < valor) {
			return search(tree.right, valor);
		}
		
		else return(tree);
	}
}