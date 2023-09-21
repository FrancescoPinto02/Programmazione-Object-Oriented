package aerodromo;

public abstract class Aeromobile implements Cmp {
	private String sigla;
	
	public Aeromobile(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return this.sigla;
	}
	
	public boolean eqCode(Aeromobile x) {
		if(this.sigla.equals(x.sigla)==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return("Sigla: " + this.sigla);
	}

}
