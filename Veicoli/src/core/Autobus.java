package core;

public class Autobus extends Veicolo {

	private int posti;
	
	//Costruttori
	public Autobus(int km, int posti) {
		super("Autobus", km);
		this.posti=posti;
	}
	public Autobus(int posti) {
		super("Autobus");
		this.posti = posti;
	}

	
	//Getter e Setter
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	
	//Utility
	@Override
	public String toString() {
		return "Autobus [posti=" + posti + " " + super.toString() + "]";
	}
	
	@Override
	public void printDetailedInfo() {
		System.out.println(this);

	}

}
