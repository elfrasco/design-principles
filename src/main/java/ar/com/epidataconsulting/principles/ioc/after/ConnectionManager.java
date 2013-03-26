package ar.com.epidataconsulting.principles.ioc.after;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.database.Database;

public class ConnectionManager {

	public Connection getConnection() {
		Database.start();
		Database.login("guest", "guest");
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		return connection;
	}

	public void closeConnection(Connection connection) {
		connection.close();
		Database.shutdown();
	}
	
}
