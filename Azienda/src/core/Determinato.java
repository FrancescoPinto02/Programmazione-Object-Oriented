package core;

import java.util.Date;

public class Determinato extends Dipendente {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5814084560142871147L;
	private Date scadenza;
	
	//Costruttori
	public Determinato(String nome, String cognome, int ID, double salario, Date scadenza) {
		super(nome, cognome, ID, salario);
		this.scadenza = scadenza;
	}
	
	
	//Getter e Setter
	public Date getScadenza() {
		return this.scadenza;
	}
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	
	//Calcola lo stipendio mensile
	@Override
	public double calcolaStipendio() {
		return this.getSalario();
	}

	
	//Utility
	@Override
	public String toString() {
		return "DETERMINATO = [Scadenza: " + this.scadenza + " " + super.toString() + "]";
	}
}
