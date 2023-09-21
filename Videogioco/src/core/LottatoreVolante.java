package core;

import exception.IllegalActionException;
import exception.StatLowerException;

public class LottatoreVolante extends Lottatore {

	//Costruttori
	public LottatoreVolante(int hp, int attacco, int difesa) {
		super(hp, attacco, difesa);
		if(this.getAttacco()<=this.getDifesa()) {
			throw new StatLowerException();
		}
	}

	public LottatoreVolante(int hp, int attacco, int difesa, int kill) {
		super(hp, attacco, difesa, kill);
		if(this.getAttacco()<=this.getDifesa()) {
			throw new StatLowerException();
		}
	}
	
	public boolean fusione(Player two) throws IllegalActionException{
		throw new IllegalActionException("Fusione non disponibile per Lottatore Volante");
	}
	
	public boolean attaccoAereo(Player other) throws IllegalActionException {
		if(this.getHp()>0 && other.getHp()>0 && this.getAttacco()>=other.getDifesa()) {
			other.setHp(other.getHp() - this.getAttacco());
			
			if(other.getHp() <=0) {
				other.setHp(0);
				this.setKill(this.getKill()+1);
			}
			
			return true;
		}
		else {
			throw new IllegalActionException("Attacco Aereo Fallito!");
		}
	}

	
	@Override
	public String toString() {
		return "LottatoreVolante [" + super.toString() + "]";
	}
	
	
	

}
