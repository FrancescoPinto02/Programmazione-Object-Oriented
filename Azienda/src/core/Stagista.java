package core;

public class Stagista extends Dipendente {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8580308281591695015L;

	static final double RITENUTA = 300;
	
	private Dipendente supervisore;
	
	public Stagista(String nome, String cognome, int ID, double salario, Dipendente supervisore) {
		super(nome, cognome, ID, salario);
		this.supervisore = supervisore;
	}
	
	
	//Setter e Getter
	public Dipendente getSupervisore() {
		return this.supervisore;
	}
	public void setSupervisore(Dipendente supervisore) {
		this.supervisore = supervisore;
	}

	
	//Calcola stipendio mensile
	@Override
	public double calcolaStipendio() {
		return this.getSalario() - RITENUTA;
	}
	
	
	//Utility
		public String toString() {
			return "STAGISTA = [Supervisore: " + this.supervisore + " " + super.toString() + "]";
		}

}
