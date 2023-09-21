package aerodromo;

public class Aliante extends Aeromobile {
	private int efficienza;
	
	public Aliante(String sigla, int efficienza) {
		super(sigla);
		this.efficienza=efficienza;
	}
	
	public int getEfficienza() {
		return this.efficienza;
	}

	@Override
	public boolean superiore(Aeromobile x) {
		if(x instanceof Aliante) {
			if(this.efficienza > ((Aliante)x).getEfficienza()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return ("Sigla: " + this.getSigla() + " Efficienza: " + this.getEfficienza());
	}
}
