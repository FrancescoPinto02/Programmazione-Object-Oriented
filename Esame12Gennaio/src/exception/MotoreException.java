package exception;

@SuppressWarnings("serial")
public class MotoreException extends Exception {

	public MotoreException() {
		super("Motore Già Acceso/Spento!");
	}

	public MotoreException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
