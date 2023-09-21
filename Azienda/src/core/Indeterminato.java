package core;

public class Indeterminato extends Dipendente {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4129641440283525261L;

	static final int BONUS = 30;
	
	private String qualifica;
	
	//Costruttori
	public Indeterminato(String nome, String cognome, int ID, double salario, String qualifica) {
		super(nome, cognome, ID, salario);
		this.qualifica = qualifica;
	}
	
	
	//Getter e Setter
	public String getQualifica() {
		return this.qualifica;
	}
	public void setQualifica(String qualifica) {
		this.qualifica = qualifica;
	}

	
	//Calcolare Stipendio Mensile
	@Override
	public double calcolaStipendio() {
		double bonus = (this.getSalario()/100)*BONUS;
		return this.getSalario() + bonus;
	}

	
	//Utility
	public String toString() {
		return "INDETERMINATO = [Qualifica: " + this.qualifica + " " + super.toString() + "]";
	}
}
