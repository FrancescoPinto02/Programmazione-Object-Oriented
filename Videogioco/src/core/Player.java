package core;


import interfacce.ComandiAvanzati;
import interfacce.ComandiBase;

public abstract class Player implements ComandiAvanzati, ComandiBase {

	private int hp;
	private int attacco;
	private int difesa;
	private int kill;
	
	
	//Costruttori
	public Player(int hp, int attacco, int difesa) {
		this.hp = hp;
		this.attacco = attacco;
		this.difesa = difesa;
		this.kill = 0;
	}

	public Player(int hp, int attacco, int difesa, int kill) {
		this.hp = hp;
		this.attacco = attacco;
		this.difesa = difesa;
		this.kill = kill;
	}

	//Getter e Setter
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttacco() {
		return attacco;
	}

	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	public int getKill() {
		return kill;
	}

	public void setKill(int kill) {
		this.kill = kill;
	}

	
	//Utility
	@Override
	public String toString() {
		return "Player [hp=" + hp + ", attacco=" + attacco + ", difesa=" + difesa + ", kill=" + kill + "]";
	}

}
