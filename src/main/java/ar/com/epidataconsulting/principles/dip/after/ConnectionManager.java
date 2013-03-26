package ar.com.epidataconsulting.principles.dip.after;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.database.Database;

public class ConnectionManager {
	
	private String databaseName;
	private String userName;
	private String password;

	public Connection getConnection() {
		Database.start();
		Database.login(userName, password);
		Connection connection = Database.getConnection(databaseName);
		return connection;
	}

	public void closeConnection(Connection connection) {
		connection.close();
		Database.shutdown();
	}
	
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
