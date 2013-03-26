package ar.com.epidataconsulting.principles.database;

public class DatabaseIsNotStarted extends RuntimeException {

	private static final long serialVersionUID = -8592620191962491874L;

	public DatabaseIsNotStarted() {
		super("ERROR: Database is not started");
	}
}
