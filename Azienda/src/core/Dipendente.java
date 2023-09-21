package core;

import java.io.Serializable;

public abstract class Dipendente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8435715979722871669L;
	private String nome;
	private String cognome; 
	private int ID;
	private double salario;
	
	//Costruttori
	public Dipendente(String nome, String cognome, int ID, double salario) {
		this.nome = nome;
		this.cognome = cognome;
		this.ID = ID;
		this.salario = salario;
	}
	
	
	//Getter e Setter
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getID() {
		return this.ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public double getSalario() {
		return this.salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	
	//Calcolo Stipendio mensile
	public abstract double calcolaStipendio();
	
	//Utility
	public String toString() {
		return "DIPENDENTE = [Nome: " + this.nome + " Cognome: " + this.cognome + " ID: " + this.ID + " Salario: " + this.salario + "]";
	}
}
