package core;

public class Treno extends Veicolo {

	private int minRitardo;
	
	//Costruttori
	public Treno(int km, int minRitardo) {
		super("Treno", km);
		this.minRitardo = minRitardo;
	}
	public Treno(int minRitardo) {
		super("Treno");
		this.minRitardo = minRitardo;
	}
	public Treno() {
		super("Treno");
		this.minRitardo = 0;
		// TODO Auto-generated constructor stub
	}
	
	
	//Getter e Setter
	public int getMinRitardo() {
		return minRitardo;
	}
	public void setMinRitardo(int minRitardo) {
		this.minRitardo = minRitardo;
	}
	
	
	//Utility
	@Override
	public String toString() {
		return "Treno [minRitardo=" + minRitardo + " " + super.toString() + "]";
	}
	
	@Override
	public void printDetailedInfo() {
		System.out.println(this);

	}

}
