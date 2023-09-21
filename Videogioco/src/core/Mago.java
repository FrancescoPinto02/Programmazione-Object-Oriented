package core;

import exception.IllegalActionException;

public class Mago extends Player {

	private static final int DFL_MAGIA_LVL = 50;
	
	private int magiaLvl;
	
	//Costruttori
	public Mago(int hp, int attacco, int difesa) {
		super(hp, attacco, difesa);
		this.magiaLvl = DFL_MAGIA_LVL;
	}

	public Mago(int hp, int attacco, int difesa, int kill) {
		super(hp, attacco, difesa, kill);
		this.magiaLvl = DFL_MAGIA_LVL;
	}

	//Getter e Setter
	public int getMagiaLvl() {
		return magiaLvl;
	}

	public void setMagiaLvl(int magiaLvl) {
		this.magiaLvl = magiaLvl;
	}

	
	//Fusione non consentita per i maghi: Genera eccezione
	@Override
	public boolean fusione(Player two) throws IllegalActionException {
		throw new IllegalActionException("Fusione non disponibile per la classe Mago!");
	}

	//Attacco Aereo non consentito per i maghi: Genera eccezione
	@Override
	public boolean attaccoAereo(Player other) throws IllegalActionException {
		throw new IllegalActionException("Attacco Aereo non disponibile per la classe Mago!");
	}

	@Override
	public boolean attacco(Player other) {
		if(this.getHp()>0 && other.getHp()>0) {
			if(this.getAttacco()>=other.getDifesa()) {
				int dmg = this.magiaLvl + this.getAttacco();
				other.setHp(other.getHp()-dmg);
				
				if(other.getHp()<=0) {
					other.setHp(0);
					this.setKill(this.getKill()+1);
				}
				
				return true;
			}
			else {
				int dmg = other.getDifesa() - this.getAttacco();
				this.setHp(this.getHp() - dmg);
				
				if(this.getHp()<=0) {
					this.setHp(0);
					other.setKill(other.getKill()+1);
				}
				
				return false;
			}
			
		}
		else {
			return false;			
		}

	}

	@Override
	public void potenziamento() {
		if(this.getHp()>0 && this.getKill()>10) {
			this.magiaLvl += 50;
			this.setAttacco(this.getAttacco()*2);
			this.setDifesa(this.getDifesa()*4);
			this.setKill(0);
		}

	}
	
	//Utility
	@Override
	public String toString() {
		return "Mago [magiaLvl=" + magiaLvl + " " + super.toString() + "]";
	}

}
