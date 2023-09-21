package core;

public class StudenteDSA extends Studente {
	private String patologia;
	
	//Costruttori
	public StudenteDSA(String matricola, String nome, String cognome, String patologia) {
		super(matricola, nome, cognome);
		this.patologia = patologia;
	}
	
	
	//Getter e Setter
	public String getPatologia() {
		return this.patologia;
	}
	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}
	
	
	//Utility
	public String toString() {
		return "STUDENTE DSA = [Matricola: " + this.getMatricola() + " Nome: " + this.getNome() + " Cognome: " + this.getCognome() + " Patologia: " + this.patologia + "]";
	}
}
