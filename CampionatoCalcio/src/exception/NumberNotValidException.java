package exception;

@SuppressWarnings("serial")
public class NumberNotValidException extends RuntimeException {

	public NumberNotValidException() {
		super("Numero non compreso tra 1 e 99!");
	}

	public NumberNotValidException(String message) {
		super(message);
	}
}
