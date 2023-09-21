package core;

import java.util.*;

public class Studente {

	private String matricola;
	private String nome;
	private String cognome;
	private ArrayList<Esame> esami;
	
	//Costruttori
	public Studente(String matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.esami = new ArrayList<Esame>();
	}
	
	
	//Getter e Setter
	public String getMatricola() {
		return this.matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
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
	public ArrayList<Esame> getEsami(){
		return this.esami;
	}
	public void setEsami(ArrayList<Esame> esami) {
		this.esami = esami;
	}
	
	
	//Inserire nuovo esame superato
	public boolean insertEsame(Esame e) {
		if(this.esami.contains(e)) {
			return false;
		}
		else {
			this.esami.add(e);
			return true;
		}
	}
	
	//Utility
	public String toString() {
		return "STUDENTE = [Matricola: " + this.matricola + " Nome: " + this.nome + " Cognome: " + this.cognome + "]";
	}
	public boolean equals(Studente s) {
		return this.matricola.equals(s.getMatricola());
	}
}
