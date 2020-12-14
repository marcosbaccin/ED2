package ed2.atividade03;

public abstract class Veiculo {

	private String id;
	private String modelo;
	private String cor;
	private int ano;
	private String motor;
	
	public Veiculo(String id, String modelo, String cor, int ano, String motor) {
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.motor = motor;
	}

	public String getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public int getAno() {
		return ano;
	}

	public String getMotor() {
		return motor;
	}
	
	@Override
	public String toString() {
		return this.modelo + ", " + this.id + ", " + this.ano + ", " + this.cor + ", " + this.motor;
	}
}