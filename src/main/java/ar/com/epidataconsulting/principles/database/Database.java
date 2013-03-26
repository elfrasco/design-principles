package ar.com.epidataconsulting.principles.database;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public final class Database {

	private static final Logger logger = Logger.getLogger(Database.class);
	
	private static final Map<String, String> DATABASE_USERS;
	
	public static final String SOFTWARE_FACTORY_SCHEMA_NAME = "SoftwareFactory";
	
	private static Connection connection;
	
	private static boolean userLogger = false;

	private static boolean started = false;
	
	static {
		DATABASE_USERS = new HashMap<String, String>();
		DATABASE_USERS.put("admin", "admin");
		DATABASE_USERS.put("guest", "guest");
	}
	
	private Database() {
	}
	
	public static void start() {
		started = true;
		logger.debug("Database STARTED OK...");
	}
	
	public static void shutdown() {
		started = false;
		logger.debug("Database SHUTDOWN OK...");
	}
	
	public static void login(String user, String password) {
		validateUser(user, password);
		userLogger = true;
		logger.debug("User Logged OK...");
	}

	public static Connection getConnection(String schemaName) {
		if (!started) {
			throw new DatabaseIsNotStarted();
		}
		if (!userLogger) {
			throw new InvalidUserException();
		}
		validateSchema(schemaName);
		if (connection == null) {
			connection = new Connection();
		}
		return connection;
	}
	
	private static void validateUser(String user, String password) {
		String pass = DATABASE_USERS.get(user);
		if (pass == null || !pass.equals(password)) {
			throw new InvalidUserException();
		}
	}
	
	private static void validateSchema(String schemaName) {
		if (!SOFTWARE_FACTORY_SCHEMA_NAME.equals(schemaName)) {
			throw new UnknownSchemaException(schemaName);
		}
	}

}
