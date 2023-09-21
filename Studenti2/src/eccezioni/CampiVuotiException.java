package eccezioni;

@SuppressWarnings("serial")
public class CampiVuotiException extends RuntimeException {

	public CampiVuotiException() {
		super("Uno o più campi vuoti!");
		// TODO Auto-generated constructor stub
	}

	public CampiVuotiException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


}
