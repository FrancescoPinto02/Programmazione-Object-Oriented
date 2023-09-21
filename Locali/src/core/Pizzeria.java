package core;

import java.util.HashMap;

public class Pizzeria extends Locale {

	private HashMap<String, Integer> menu;
	
	//Costruttori
	public Pizzeria(String nome, String indirizzo, int postiDisp) {
		super(nome, indirizzo, postiDisp);
		this.menu = new HashMap<String, Integer>();	
	}
	public Pizzeria(String nome, String indirizzo, int postiDisp, HashMap<String,Integer> menu) {
		super(nome, indirizzo, postiDisp);
		this.menu = menu;	
	}

	
	//Getter e Setter
	public HashMap<String, Integer> getMenu(){
		return this.menu;
	}
	public void setMenu(HashMap<String, Integer> menu) {
		this.menu = menu;
	}

	//Metodo per aggiungere una pizza al menu
	public void addPizza(String nome, int prezzo) {
		this.menu.put(nome, prezzo);
	}

	//Metodo per prenotare pizzeria per np persone
	@Override
	public boolean prenota(int np) {
		int postiDisp = this.getPostiDisp();
		if(postiDisp >= np) {
			this.setPostiDisp(postiDisp-np);
			return true;
		}
		else {
			return false;			
		}
	}

	
	//Utility
	public String toString() {
		return "PIZZERIA = [Menu: " + this.menu + " " + super.toString() + "]";
	}
}
