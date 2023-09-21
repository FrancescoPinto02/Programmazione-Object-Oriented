package exception;

@SuppressWarnings("serial")
public class SquadraRegisteredException extends Exception {

	public SquadraRegisteredException() {
		super("Squadra già registrata!");
	}

	public SquadraRegisteredException(String message) {
		super(message);
		//Squadra registrata ma in un altro campionato
	}
	
}
