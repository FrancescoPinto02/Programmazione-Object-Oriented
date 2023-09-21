package exception;

@SuppressWarnings("serial")
public class NumberNotAvailableException extends RuntimeException {

	public NumberNotAvailableException() {
		super("Numero non disponibile!");
		//Numero già preso da un altro giocatore
	}

	public NumberNotAvailableException(String message) {
		super(message);
		//Numero ritirato
	}

}
