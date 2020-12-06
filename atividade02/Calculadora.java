package ed2.atividade02;

import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;


public class Calculadora {
	
	public static int calcularInfixa(String expressao) {
        
		char[] tokens = expressao.toCharArray();
 
         // Pilha para números: 'valores'
        Stack<Integer> valores = new Stack<Integer>();
 
        // Pilha para operadores: 'ops'
        Stack<Character> ops = new Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++) {
             
            // Token atual é um espaço em branco, pule-o.
            if (tokens[i] == ' ')
                continue;
 
            // Token atual é um número, adicione-o na pilha de números.
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                 
                // Pode haver mais de um dígito no número.
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                
                valores.push(Integer.parseInt(sbuf.toString()));
               
                /* Agora o i aponta para o caractere próximo ao dígito,
                   uma vez que o loop 'for' também aumenta o i,
                   nós pularíamos uma posição do token;
                   nós precisamos diminuir o valor de i em 1 para corrijir o deslocamento. */
                i--;
            }
 
            // O token atual é uma chave de abertura, adicione-a para 'ops'.
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Chave de fechamento encontrada, resolva toda a chave.
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                  valores.push(aplicarOp(ops.pop(), valores.pop(), valores.pop()));
                
                ops.pop();
            }
 
            // O token atual é um operador.
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                
            	/* Enquanto o topo de 'ops' tenha o mesmo ou maior precedência
                   para o atual token, que é um operador.
                   Aplicar operação do topo de 'ops'
                   para os dois primeiros elementos na pilha de valores. */
                while (!ops.empty() && temPrecedencia(tokens[i], ops.peek()))
                  valores.push(aplicarOp(ops.pop(), valores.pop(), valores.pop()));
 
                // Adicione o token atual para 'ops'.
                ops.push(tokens[i]);
            }
        }
 
        /* A expressão inteira foi analisada neste ponto,
           aplique o restante de ops para os valores restantes. */
        while (!ops.empty())
            valores.push(aplicarOp(ops.pop(), valores.pop(), valores.pop()));
 
        // O topo de 'valores' contém resultado, returne-o.
        return valores.pop();
    }
	
	/* Retorna verdadeiro se 'op2' tiver maior ou a mesma precedência de 'op1',
       caso contrário, retorna falso. */
    public static boolean temPrecedencia(char op1, char op2) {
        
    	if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    
    /* Um método utilitário para aplicar uma operaçãp 'op' nos operandos 'a' e 'b'.
       Returna o resultado. */
    public static int aplicarOp(char op, int b, int a) {
        
    	switch (op) {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Não é possível dividir por zero.");
            return a / b;
        }
        return 0;
    }
    
    static int calcularPrefixa(String expressao) {
        
    	Stack<Integer> Stack = new Stack<Integer>(); 
  
        for (int j = expressao.length() - 1; j >= 0; j--) { 
  
            /* Adicione o operando para Stack para converter expressao[j]
               ao subtrair dígito '0' a partir da expressão [j]. */
            if (isOperando(expressao.charAt(j))) 
                Stack.push((expressao.charAt(j) - 48)); 
  
            else { 
  
                // Operador encontrado, Pop dois elementos da pilha;
                int o1 = Stack.peek(); 
                Stack.pop(); 
                int o2 = Stack.peek(); 
                Stack.pop(); 
  
                // Use switch case para operar em o1 e o2.
                switch (expressao.charAt(j)) { 
                case '+': 
                    Stack.push(o1 + o2); 
                    break; 
                case '-': 
                    Stack.push(o1 - o2); 
                    break; 
                case '*': 
                    Stack.push(o1 * o2); 
                    break; 
                case '/': 
                    Stack.push(o1 / o2); 
                    break; 
                } 
            } 
        } 
  
        return Stack.peek(); 
    }
    
    static Boolean isOperando(char c) {
        // Se o caractere for um dígito, deve ser um operando.
        if (c >= 48 && c <= 57) 
            return true; 
        else
            return false; 
    }
    
    static int calcularPosfixa(String expressao) {
        
    	// Crie uma pilha. 
        Stack<Integer> stack=new Stack<Integer>(); 
          
        // Leia todos os caracteres um por um. 
        for(int i = 0; i < expressao.length() ;i++) {
            
        	char c = expressao.charAt(i); 
              
            // Se o caractere varrido for um operando, coloque-o na pilha.
            if(Character.isDigit(c)) 
            	stack.push(c - '0'); 
              
            /* Se o caractere escaneado for um operador, 
               retire dois elementos da pilha e aplicar o operador. */
            else {
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 
                  
                switch(c) {
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
              } 
            } 
        } 
        return stack.pop();     
    }
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int tipo;
		String expressao;
		
		System.out.println("1)Infixa\t2)Pré-fixa\t3)Pós-fixa");
		tipo = scan.nextInt();
		expressao = JOptionPane.showInputDialog("Informe a expressão a ser calculada:");
		
		switch(tipo) {
		
			case 1:
				System.out.println(expressao + " = " + calcularInfixa(expressao));
				break;
			case 2:
				System.out.println(expressao + " = " + calcularPrefixa(expressao));
				break;
			case 3:
				System.out.println(expressao + " = " + calcularPosfixa(expressao));
				break;
			default:
				System.out.println("Tipo inválido.");
		}
		
		scan.close();
	}
}