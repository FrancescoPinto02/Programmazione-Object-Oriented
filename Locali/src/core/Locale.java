package core;

import java.util.Objects;

public abstract class Locale {

	private String nome;
	private String indirizzo;
	private int postiDisp;
	
	//Costruttori
	public Locale(String nome, String indirizzo, int postiDisp) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.postiDisp = postiDisp;
	}
	



	//Getter e Setter
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIndirizzo() {
		return this.indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public int getPostiDisp() {
		return this.postiDisp;
	}
	public void setPostiDisp(int postiDisp) {
		this.postiDisp = postiDisp;
	}


	//Metodo per effettuare una prenotazione per n persone
	public abstract boolean prenota(int np);
	
	//Utility
	public String toString() {
		return "LOCALE = [Nome: " + this.nome + " Indirizzo: " + this.indirizzo + " Posti Disponibili: " + this.postiDisp + "]";
	}
	
	public boolean equals(Object l) {
		if(this == l) {
			return true;
		}
		if(l == null) {
			return false;
		}
		if(this.getClass() != l.getClass()) {
			return false;
		}
		
		return this.indirizzo.equalsIgnoreCase(((Locale)l).getIndirizzo()) && this.nome.equalsIgnoreCase(((Locale)l).getNome());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.indirizzo, this.nome);
	}
	
	
	
	
}
