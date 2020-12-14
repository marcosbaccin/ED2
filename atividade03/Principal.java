package ed2.atividade03;

public class Principal {

	public static void main(String[] args) {
		
		LavaJato lj = new LavaJato();
		
		Veiculo[] veiculos = {
			new Carro("DFH-4569", "Lada Riva", "Cinza", 1994, "75 cv"),
			new Carro("NTY-7452", "Volkswagen Fusca", "Vermelho", 1992, "65 cv"),
			new Carro("DBS-6541", "Volkswagen Golf", "Preto", 2002, "125 cv"),
			new Carro("RWN-6351", "Ford F-Series", "Vermelho", 1999, "450 cv"),
			new Carro("GSE-1353", "Toyota Corolla", "Branco", 2007, "170 cv"),
			
			new Moto("STN-2105", "Honda CB", "Azul", 2018, "22 cv"),
			new Moto("RYD-6213", "Honda Pop", "Vermelho", 2007, "7.9 cv"),
			new Moto("NRJ-7269", "Honda CB", "Branca", 2016, "15 cv"),
			new Moto("QEO-5627", "Honda Biz", "Preto", 2017, "9.2 cv"),
			new Moto("EQN-7235", "Honda CG", "Vermelho", 1997, "10 cv"),
			
			new Caminhao("ENB-2959", "DAF XF", "Preto", 2006, "510 cv"),
			new Caminhao("VJN-9725", "Mercedes-Benz Actros", "Vermelho", 2019, "510 cv"),
			new Caminhao("WVD-5151", "Volvo FH", "Vermelho", 2004, "460 cv"),
			new Caminhao("KNN-7843", "Scania R", "Preto", 2011, "450 cv"),
			new Caminhao("CDS-2314", "Volvo FH", "Azul", 2008, "540 cv")
		};
		
		lj.start(veiculos);
	}
}