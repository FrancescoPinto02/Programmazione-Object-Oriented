package aerodromo;

public class Aereomotore extends Aeromobile {
	private double cv;

	public Aereomotore(String sigla, double cv) {
		super(sigla);
		this.cv = cv;
	}
	
	public double getCv() {
		return this.cv;
	}

	@Override
	public boolean superiore(Aeromobile x) {
		if(x instanceof Aereomotore) {
			if(this.cv > ((Aereomotore) x).getCv()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return ("Sigla: " + this.getSigla() + " Cv: " + this.getCv());
	}
}
