package ed2.atividade13.arvoreRubroNegra;

class Node {
	int data;
	Node parent;
	Node left;
	Node right;
	int color; //1.Vermelho, 0.Preto
}

public class ArvoreRubroNegra {

	Node root;
	private Node TNULL;
	
	public void preOrder(Node node) {
		
		if(node != TNULL) {
			
			System.out.print(node.data + " ");
			
			preOrder(node.left);
			preOrder(node.right);
		} 
	}
	
	public void inOrder(Node node) {
		
		if(node != TNULL) {
			inOrder(node.left);
			
			System.out.print(node.data + " ");
			
			inOrder(node.right);
		} 
	}

	public void postOrder(Node node) {
		
		if(node != TNULL) {
			
			postOrder(node.left);
			postOrder(node.right);
			
			System.out.print(node.data + " ");
		} 
	}
	
	public Node search(Node node, int key) {
		
		if(node == TNULL) {
			return null;
		}
		
		if(key == node.data) {
			return node;
		}

		if(key < node.data) {
			return search(node.left, key);
		}
		
		return search(node.right, key);
	}
	
	//Corrige a Árvore RB modificada pela operação de exclusão
	private void fixDelete(Node x) {
		
		Node s;
		
		while(x != root && x.color == 0) {
			
			if(x == x.parent.left) {
				
				s = x.parent.right;
				
				if(s.color == 1) {
					
					//Caso 3.1
					s.color = 0;
					x.parent.color = 1;
					
					leftRotate(x.parent);
					
					s = x.parent.right;
				}

				if(s.left.color == 0 && s.right.color == 0) {
					
					//Caso 3.2
					s.color = 1;
					x = x.parent;
				}
				
				else {
					
					if(s.right.color == 0) {
						
						//Caso 3.3
						s.left.color = 0;
						s.color = 1;
						
						rightRotate(s);
						
						s = x.parent.right;
					}

					//Caso 3.4
					s.color = x.parent.color;
					x.parent.color = 0;
					s.right.color = 0;
					
					leftRotate(x.parent);
					
					x = root;
				}
			}
			
			else {
				
				s = x.parent.left;
				
				if(s.color == 1) {
					
					//Caso 3.1
					s.color = 0;
					x.parent.color = 1;
					
					rightRotate(x.parent);
					
					s = x.parent.left;
				}

				if(s.right.color == 0 && s.right.color == 0) {
					
					//Caso 3.2
					s.color = 1;
					x = x.parent;
				}
				
				else {
					
					if(s.left.color == 0) {
						
						//Caso 3.3
						s.right.color = 0;
						s.color = 1;
						
						leftRotate(s);
						
						s = x.parent.left;
					}

					//Caso 3.4
					s.color = x.parent.color;
					x.parent.color = 0;
					s.left.color = 0;
					
					rightRotate(x.parent);
					
					x = root;
				}
			} 
		}
		
		x.color = 0;
	}
	
	private void troca(Node u, Node v){
		
		if(u.parent == null) {
			root = v;
		}
		
		else if(u == u.parent.left) {
			u.parent.left = v;
		}
		
		else {
			u.parent.right = v;
		}
		
		v.parent = u.parent;
	}
	
	public void delete(Node node, int key) {
		
		Node z = TNULL;
		Node x, y;
		
		while(node != TNULL){
			
			if(node.data == key) {
				z = node;
			}

			if(node.data <= key) {
				node = node.right;
			}
			
			else {
				node = node.left;
			}
		}

		if(z == TNULL) {
			
			System.out.println("Couldn't find key in the tree");
			
			return;
		}

		y = z;
		int yOriginalColor = y.color;
		
		if(z.left == TNULL) {
			
			x = z.right;
			
			troca(z, z.right);
		}
		
		else if(z.right == TNULL) {
			
			x = z.left;
			
			troca(z, z.left);
		}
		
		else {
			
			y = minimum(z.right);
			yOriginalColor = y.color;
			x = y.right;
			
			if(y.parent == z) {
				x.parent = y;
			}
			
			else {
				
				troca(y, y.right);
				
				y.right = z.right;
				y.right.parent = y;
			}

			troca(z, y);
			
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		
		if(yOriginalColor == 0){
			fixDelete(x);
		}
	}
	
	//Corrige a Árvore RB modificada pela operação de insercão
	private void fixInsert(Node k){
		
		Node u;
		
		while(k.parent.color == 1) {
			
			if(k.parent == k.parent.parent.right) {
				
				u = k.parent.parent.left; // uncle
				
				if(u.color == 1) {
					
					// case 3.1
					u.color = 0;
					k.parent.color = 0;
					k.parent.parent.color = 1;
					k = k.parent.parent;
				}
				
				else {
					
					if(k == k.parent.left) {
						
						//Caso 3.2.2
						k = k.parent;
						
						rightRotate(k);
					}
					
					//Caso 3.2.1
					k.parent.color = 0;
					k.parent.parent.color = 1;
					
					leftRotate(k.parent.parent);
				}
			}
			
			else {
				
				u = k.parent.parent.right; //Tio

				if(u.color == 1) {
					
					//Caso espelho 3.1
					u.color = 0;
					k.parent.color = 0;
					k.parent.parent.color = 1;
					k = k.parent.parent;	
				}
				
				else {
					
					if(k == k.parent.right) {
						
						//Caso espelho 3.2.2
						k = k.parent;
						
						leftRotate(k);
					}
					
					//Caso espelho 3.2.1
					k.parent.color = 0;
					k.parent.parent.color = 1;
					
					rightRotate(k.parent.parent);
				}
			}
			
			if(k == root) {
				break;
			}
		}
		
		root.color = 0;
	}
	
	public ArvoreRubroNegra() {
		
		TNULL = new Node();
		TNULL.color = 0;
		TNULL.left = null;
		TNULL.right = null;
		root = TNULL;
	}

	//Encontra o nó com a chave mínima
	private Node minimum(Node node) {
		
		while(node.left != TNULL) {
			node = node.left;
		}
		
		return node;
	}
	
	private void leftRotate(Node x) {
		
		Node y = x.right;
		x.right = y.left;
		
		if(y.left != TNULL) {
			y.left.parent = x;
		}
		
		y.parent = x.parent;
		
		if(x.parent == null) {
			this.root = y;
		}
		
		else if(x == x.parent.left) {
			x.parent.left = y;
		}
		
		else {
			x.parent.right = y;
		}
		
		y.left = x;
		x.parent = y;
	}
	
	private void rightRotate(Node x) {
		
		Node y = x.left;
		x.left = y.right;
		
		if(y.right != TNULL) {
			y.right.parent = x;
		}
		
		y.parent = x.parent;
		
		if(x.parent == null) {
			this.root = y;
		}
		
		else if(x == x.parent.right) {
			x.parent.right = y;
		}
		
		else {
			x.parent.left = y;
		}
		
		y.right = x;
		x.parent = y;
	}
	
	public void insert(int key) {
		
		Node node = new Node();
		node.parent = null;
		node.data = key;
		node.left = TNULL;
		node.right = TNULL;
		node.color = 1; // new node must be red
		Node y = null;
		Node x = this.root;

		while(x != TNULL) {
			
			y = x;
			
			if(node.data < x.data) {
				x = x.left;
			}
			
			else {
				x = x.right;
			}
		}

		//y é pai de x
		node.parent = y;
		
		if(y == null) {
			root = node;
		}
		
		else if(node.data < y.data) {
			y.left = node;
		}
		
		else {
			y.right = node;
		}

		//Se o novo nó for um nó raiz, basta retornar
		if(node.parent == null){
			node.color = 0;
			return;
		}

		//Se o avô for nulo, basta retornar
		if(node.parent.parent == null) {
			return;
		}

		//Corrige a árvore
		fixInsert(node);
	}
	
	/*public Node getRoot(){
		return this.root;
	}*/
}