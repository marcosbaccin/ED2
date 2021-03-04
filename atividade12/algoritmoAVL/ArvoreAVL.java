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
	 
    //Uma função de utilidade para obter a altura da árvore
    private int height(Node n) {
        
    	if(n == null)
            return 0;
 
        return n.height;
    }
    
    //Uma função de utilidade para obter no máximo dois inteiros
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    
    //Uma função de utilidade para girar à direita a subárvore enraizada com y
    private Node rightRotate(Node y) {
        
    	Node x = y.left;
        Node t2 = x.right;
 
        //Executar rotação
        x.right = y;
        y.left = t2;
 
        //Atualizar alturas
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        //Retornar nova raiz
        return x;
    }
    
    //Uma função de utilidade para girar para a esquerda a subárvore enraizada com x
    private Node leftRotate(Node x) {
        
    	Node y = x.right;
        Node t2 = y.left;
 
        //Executar rotação
        y.left = x;
        x.right = t2;
 
        //Atualizar alturas
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        //Retornar nova raiz
        return y;
    }
    
    //Obter fator de equilíbrio do nó N
    private int getBalance(Node n) {
        
    	if (n == null)
            return 0;
 
        return height(n.left) - height(n.right);
    }
    
    public Node insert(Node node, int key) {
    	 
        //1. Faça a inserção normal do BST
        if(node == null)
            return (new Node(key));
 
        if(key < node.key)
            node.left = insert(node.left, key);
        
        else if(key > node.key)
            node.right = insert(node.right, key);
        
        else //Chaves duplicadas não permitidas
            return node;
 
        //2. Atualize a altura deste nó ancestral
        node.height = 1 + max(height(node.left), height(node.right));
 
        //3. Obtenha o fator de equilíbrio deste nó ancestral para verificar se este nó se tornou desequilibrado
        int balance = getBalance(node);
 
        //Se este nó se tornar desequilibrado, então haverá 4 casos Esquerda Caixa
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
 
        //retornar o ponteiro do nó (inalterado)
        return node;
    }
    
    //Dada uma árvore de pesquisa binária não vazia, retorna o nó com o valor de chave mínimo encontrado nessa árvore. Observe que a árvore inteira não precisa ser pesquisada.
    private Node minValueNode(Node node) {
        
    	Node current = node;
  
    	//Volta para baixo para encontrar a folha mais à esquerda
        while (current.left != null)
        	current = current.left;
  
        return current;
    }
    
    public Node deleteNode(Node root, int key) {
        
    	//PASSO 1: EXECUTAR PADRÃO BST DELETE
        if(root == null)
            return root;
  
        //Se a chave a ser excluída for menor do que a chave da raiz, ela fica na subárvore esquerda
        if(key < root.key)
            root.left = deleteNode(root.left, key);
  
        //Se a chave a ser deletada for maior que a chave da raiz, então ela está na subárvore direita
        else if(key > root.key)
            root.right = deleteNode(root.right, key);
  
        //Se a chave for igual à chave do root, então este é o nó a ser excluído
        else {
  
        	//Nó com apenas um filho ou nenhum filho
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
                    root = temp; //Copia o conteúdo do filho não vazio
            }  
            else {
  
            	//Nó com dois filhos: obtém o sucessor da ordem (o menor na subárvore direita)
                Node temp = minValueNode(root.right);
  
                //Copie os dados do sucessor do pedido para este nó
                root.key = temp.key;
  
                //Exclua o sucessor do pedido
                root.right = deleteNode(root.right, temp.key);
            }
        }
  
        //Se a árvore tinha apenas um nó, então retorna
        if(root == null)
            return root;
  
        //PASSO 2: ATUALIZAR ALTURA DO NÓ ATUAL
        root.height = max(height(root.left), height(root.right)) + 1;
  
        //PASSO 3: OBTER O FATOR DE EQUILÍBRIO DESTE NÓ (para verificar se este nó ficou desequilibrado)
        int balance = getBalance(root);
  
        //Se este nó se tornar desequilibrado, então existem 4 casos
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
    
    //Uma função utilitária para imprimir o percurso da pré-ordem da árvore. A função também imprime a altura de cada nó
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