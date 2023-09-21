package core;

public class Paninoteca extends Locale {
	
	private int panini;
	private int birre;
	
	//Costruttori
	public Paninoteca(String nome, String indirizzo, int postiDisp, int panini, int birre) {
		super(nome, indirizzo, postiDisp);
		this.panini = panini;
		this.birre = birre;
	}
	
	
	//Getter e Setter
	public int getPanini() {
		return this.panini;
	}
	public void setPanini(int panini) {
		this.panini = panini;
	}
	public int getBirre() {
		return this.birre;
	}
	public void setBirre(int birre) {
		this.birre = birre;
	}

	//Metodo per prenotare paninoteca per np persone
	@Override
	public boolean prenota(int np) {
		int postiDisp = this.getPostiDisp();
		
		if(postiDisp >= np && this.panini >= np) {
			this.setPostiDisp(postiDisp-np);
			this.panini = this.panini - np;
			return true;
		}
		else {
			return false;
		}
	}
	
	//Utility
	public String toString() {
		return "PANINOTECA = [Panini Disponibili: " + this.panini + " Birre Disponibili: "+ this.birre + " " + super.toString() + "]";
	}

}
