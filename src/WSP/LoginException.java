package WSP;

public class LoginException extends Exception {
	private static final long serialVersionUID = 1L;
	private int number;
	
	public LoginException(String message, int number) {
		super(message);
		this.number = number;
	}
}
