package core;

import exception.IllegalActionException;

public class Lottatore extends Player {
	
	private final static int HP_MUL = 2; //moltiplicatore vita
	private final static int ATT_MUL = 4; //moltiplicatore attacco
	private final static int DEF_MUL = 1; //moltiplicatore difesa

	//Costruttori
	public Lottatore(int hp, int attacco, int difesa) {
		super(hp*HP_MUL, attacco*ATT_MUL, difesa*DEF_MUL);
	}

	public Lottatore(int hp, int attacco, int difesa, int kill) {
		super(hp*HP_MUL, attacco*ATT_MUL, difesa*DEF_MUL, kill);
	}

	//Metodo per fondere due lottatori: il secondo non esisterà più una volta completato il processo
	@Override
	public boolean fusione(Player two) throws IllegalActionException {
		if(!(two instanceof Lottatore && this.getHp()>0 && two.getHp()>0)) {
			throw new IllegalActionException();
		}
		else {
			this.setHp(this.getHp() + two.getHp());
			this.setAttacco(this.getAttacco() + this.getAttacco());
			this.setDifesa(two.getDifesa());
			this.setKill(0);
			two = null;
			
			return true;
		}
	}

	//Non consentito per Lottatore (Genera sempre un eccezione)
	@Override
	public boolean attaccoAereo(Player other) throws IllegalActionException {
		throw new IllegalActionException("Lottatore non può eseguire un Attacco Aereo");
	}

	//Metodo per attaccare un altro Player
	@Override
	public boolean attacco(Player other) {
		if(this.getHp()<=0  ||  other.getHp()<=0  ||  this.getAttacco() <= other.getDifesa()) {
			return false;
		}
		else {
			int dmg = this.getAttacco() * 2;
			other.setHp(other.getHp() - dmg);
			
			if(other.getHp()<=0) {
				other.setHp(0);
				this.setKill(this.getKill() + 1);
			}
			
			return true;
		}
	}

	//Metodo per potenziare un player
	@Override
	public void potenziamento() {
		if(this.getKill()>5 && this.getHp()>0) {
			this.setDifesa(this.getDifesa()*2);
			this.setKill(0);
		}
	}

	
	//Utility
	@Override
	public String toString() {
		return "Lottatore [" + super.toString() + "]";
	}

	
	

	
	
}
