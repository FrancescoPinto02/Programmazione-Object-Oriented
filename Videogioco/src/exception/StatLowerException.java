package exception;

@SuppressWarnings("serial")
public class StatLowerException extends RuntimeException {

	public StatLowerException() {
		super("Statistiche non valide!");
	}

	public StatLowerException(String message) {
		super(message);
	}

}
