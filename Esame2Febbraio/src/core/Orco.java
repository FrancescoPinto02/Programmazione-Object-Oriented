package core;

public class Orco extends Personaggio {

private static int countClass = 0;
	
	private int idClass;
	
	public Orco(int startPos) {
		super("Orco", startPos);
		countClass++;
		this.idClass = countClass;
	}
	
	
	//Getter e Setter
	public int getIdClass() {
		return idClass;
	}
	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}


	//colpisce il personaggio pers e riduce la sua energia di 1 unità
	@Override
	public void colpisci(Personaggio pers) {
		if(pers.getEnergia()>0) {
			pers.setEnergia(pers.getEnergia()-1);
		}

	}


	
	//Utility
	@Override
	public String toString() {
		return "Orco [idClass=" + idClass + " " + super.toString() + "]";
	}

}
