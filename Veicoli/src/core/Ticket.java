package core;

public class Ticket {

	public static final int PREZZO_BASE = 10;
	
	private boolean valido;
	private int prezzo;
	
	//Costruttori
	public Ticket() {
		this.valido = true;
		this.prezzo = PREZZO_BASE;
	}
	public Ticket(int prezzo) {
		this.valido = true;
		this.prezzo = prezzo;
	}
	
	
	//Getter e Setter
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	
	//Utility
	@Override
	public String toString() {
		return "Ticket [valido=" + valido + ", prezzo=" + prezzo + "]";
	}
	
	
}
