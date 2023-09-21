package core;

import exception.IllegalActionException;
import interfacce.TransActions;

public abstract class Veicolo implements TransActions {

	static int count = 0;
	
	private int id;
	private String tipo;
	private int km;
	
	//Costruttori
	public Veicolo(String tipo, int km) {
		count++;
		this.id = count;
		this.tipo = tipo;
		this.km = km;
	}
	public Veicolo(String tipo) {
		this(tipo, 0);
	}

		
	//Getter e Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	
	
	//Restituisce true se il ticket è valido e setta a false la sua validità
	@Override
	public boolean checkTicket(Ticket t) {
		if(t.isValido()) {
			t.setValido(false);
			return true;
		}
		else {
			return false;
		}
	}

	//e permette l’acquisto di un biglietto se e soltanto se i money sono maggiori del prezzo “costante” dei ticket (ad esempio 10 euro); 
	//lancia un’eccezione altrimenti.
	@Override
	public Ticket buyTicket(int money) throws IllegalActionException{
		if(money > 0 && money >= Ticket.PREZZO_BASE) {
			return new Ticket();
		}
		else {
			throw new IllegalActionException();
		}
	}
	
	//Stampa informazioni specifiche del tipo di veicolo
	public abstract void printDetailedInfo();
	
	//Utility
	@Override
	public String toString() {
		return "Veicolo [id=" + id + ", tipo=" + tipo + ", km=" + km + "]";
	}

}
