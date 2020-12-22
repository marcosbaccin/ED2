package ed2.atividade04.listaencadeadasimples01;

public class Paciente {
	
	private String nome;
	private int idade;
	private char sexo;
	
	public Paciente(String nome, int idade, char sexo) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(byte idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return this.nome + ", Idade: " + this.idade + ", Sexo: " + this.sexo;
	}
}