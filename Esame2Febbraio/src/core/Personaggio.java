package core;

import exception.PositionException;
import interfacce.PersMaster;

public abstract class Personaggio implements PersMaster {
	
	static int count=0;
	
	private int id;
	private String tipo;
	private int energia;
	private int startPos;
	private int currentPos;
	private int rotazione;

	//Costruttori
	public Personaggio(String tipo, int startPos) {
		count++;
		this.id = count;
		this.tipo = tipo;
		this.energia = 100;
		this.startPos = startPos;
		this.currentPos = startPos;
		this.rotazione = 0;
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
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getCurrentPos() {
		return currentPos;
	}
	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}
	public int getRotazione() {
		return rotazione;
	}
	public void setRotazione(int rotazione) {
		this.rotazione = rotazione;
	}



	//Ruota il personaggio verso destra di g gradi
	@Override
	public void ruota(int g) {
		if(g>0) {
			this.rotazione = (this.rotazione + g) % 360;
		}
	}

	//Muove il personaggio avanti di s unità di misura. Genere un eccezione se la posizione supera il quadro di gioco
	@Override
	public void avanti(int s) throws PositionException {
		if(s>0) {
			int newPos = this.currentPos + s;
			if(newPos > 100) {
				throw new PositionException();
			}
			else {
				this.currentPos = newPos;
			}
		}
	}

	//Muove il personaggio indietro di s unità di misura. Genere un eccezione se la posizione supera il quadro di gioco
	@Override
	public void indietro(int s) throws PositionException {
		if(s>0) {
			int newPos = this.currentPos - s;
			if(newPos < 0) {
				throw new PositionException();
			}
			else {
				this.currentPos = newPos;
			}
		}
	}

	public abstract void colpisci(Personaggio pers);


	//Utility
	@Override
	public String toString() {
		return "Personaggio [id=" + id + ", tipo=" + tipo + ", energia=" + energia + ", startPos=" + startPos
				+ ", currentPos=" + currentPos + ", rotazione=" + rotazione + "]";
	}
}
