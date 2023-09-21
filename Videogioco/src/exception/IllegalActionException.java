package exception;

@SuppressWarnings("serial")
public class IllegalActionException extends Exception {

	public IllegalActionException() {
		super("Azione non Consentita!");
	}

	public IllegalActionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
