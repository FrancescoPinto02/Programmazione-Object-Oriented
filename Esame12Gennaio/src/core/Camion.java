package core;

public class Camion extends Macchina {
	
	private double lunRim;
	private double pesoMax;
	private double peso;
	private int limVel;

	//Costruttori
	public Camion(String tipo, int ruote, int cilindrata, String colore, String targa, int marce, double lunRim, double pesoMax) {
		super(tipo, ruote, cilindrata, colore, targa, marce);
		this.lunRim = lunRim;
		this.pesoMax = pesoMax;
		this.peso = 0;
		this.limVel = 80;
	}
	
	//Get e Set
	public double getLunRim() {
		return this.lunRim;
	}
	public void setLunRim(double lunRim) {
		this.lunRim = lunRim;
	}
	public double getPeso() {
		return this.peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getPesoMax() {
		return this.pesoMax;
	}
	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}
	public int getLimVel() {
		return this.limVel;
	}
	public void setLimVel(int limVel) {
		this.limVel = limVel;
	}

	//Incrementa peso del carico
	public void caricaRimorchio() {
		if(this.pesoMax >= (this.peso + 1000)) {
			this.setPeso(this.peso + 1000);
			System.out.println("Peso carico aumentato!");
		}
		else {
			System.out.println("Impossibile aumentare ulteriormente il peso del carico!");
		}
		
	}
	
	//Scarica il rimorchio
	public void scaricaRimorchio() {
		this.setPeso(0);
		System.out.println("Rimorchio Scaricato!");
	}
	
	
	//Utility
	public String toString() {
		return "Camion = [Lunghezza Rimorichi:" + lunRim + ", Peso:" + peso + ", Limite Velocita:" + limVel
				+ " " + super.toString() + "]";
	}
}
