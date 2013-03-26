package ar.com.epidataconsulting.principles.database;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest {
	
	private static final Logger logger = Logger.getLogger(DatabaseTest.class);

	@Test
	public void testConnection() {
		
		// init database
		Database.start();
		Database.login("guest", "guest");
		
		// Get a connection
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		Assert.assertNotNull(connection);
		Assert.assertEquals("ERROR: Connection is in use!", false, connection.isInUse());
		
		// Open the connection
		connection.open();
		Assert.assertEquals("ERROR: Connection is not in use!", true, connection.isInUse());
		
		// Close the connection
		connection.close();
		Assert.assertEquals("ERROR: Connection is in use!", false, connection.isInUse());
		
		connection.close();
		Database.shutdown();
	}
	
	@Test
	public void testInvalidUser() {
		try {
			Database.start();
			Database.login("invalidUser", "");
		} catch (InvalidUserException e) {
			logger.debug(e.getMessage());
			return;
		}
		Assert.fail("The invalid User is not a valid user");
	}
	
	@Test
	public void testUnknownSchema() {
		
		// init database
		Database.start();
		Database.login("guest", "guest");
		
		try {
			Database.getConnection("invalidSchemaName");
		} catch (UnknownSchemaException e) {
			logger.debug(e.getMessage());
			return;
		}
		Assert.fail("The invalidSchemaName is not a valid user");		
	}
	
	@Test
	public void testConnectionInUse() {
		
		// init database
		Database.start();
		Database.login("guest", "guest");
		
		// Get a connection
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		Assert.assertNotNull(connection);
		Assert.assertEquals("ERROR: Connection is in use!", false, connection.isInUse());
		
		// Open the connection
		connection.open();
		Assert.assertEquals("ERROR: Connection is not in use!", true, connection.isInUse());
		
		// Open the connection again
		try {
			connection.open();
		} catch (ConnectionInUseException e) {
			logger.debug(e.getMessage());
			return;
		}
		Assert.fail("It should have thrown the ConnectionInUseException ");
	}
}
