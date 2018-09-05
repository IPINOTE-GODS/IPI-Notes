package IPINoteGods.IPINotes.Exception;

public class SessionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SessionNotFoundException(String e) {
		super(e);
	}
}
