package ar.com.epidataconsulting.principles.database;

public class InvalidUserException extends RuntimeException {
	
	private static final long serialVersionUID = -7358108696665959979L;

	public InvalidUserException() {
		super("ERROR: Invalid USER or PASSWORD");
	}

}
