package ar.com.epidataconsulting.principles.database;

public class ConnectionInUseException extends RuntimeException {

	private static final long serialVersionUID = -1734905392786741998L;

	public ConnectionInUseException() {
		super("ERROR: Connection is in use");
	}
	
}
