package interfacce;

import exception.PositionException;

public interface PersMaster {

	void ruota(int g);
	
	void avanti(int s) throws PositionException;

	void indietro(int s) throws PositionException;
}
