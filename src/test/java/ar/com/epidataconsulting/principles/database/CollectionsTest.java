package ar.com.epidataconsulting.principles.database;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class CollectionsTest {
	
	private static final Logger logger = Logger.getLogger(CollectionsTest.class);

	@Test
	public void saveFindAndDelete() {

		Database.start();
		Database.login("guest", "guest");
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		
		connection.insert("employees", createAdrianParedes());
		connection.insert("employees", createJuanGaragorri());
		connection.insert("employees", createLeonardoPavanello());
		connection.insert("projects", createProject());
		
		List<Map<String, Object>> allEmployees = connection.findAll("employees");
		Assert.assertFalse("There are not employees in the database", allEmployees.isEmpty());
		Assert.assertTrue("There should be three employees", allEmployees.size() == 3);
		
		Map<String, String> ids = new HashMap<String, String>();
		for (Map<String, Object> employee : allEmployees) {
			Assert.assertNotNull("There must be an ID", employee.get("id"));
			Assert.assertNotNull("ID must be a String", employee.get("id") instanceof String);
			ids.put((String) employee.get("id"), (String) employee.get("name"));
		}
		
		logger.debug(ids);
		
		for (Map.Entry<String, String> entry : ids.entrySet()) {
			Map<String, Object> employee = connection.findById("employees", entry.getKey());
			Assert.assertEquals(employee.get("id"), entry.getKey());
			Assert.assertEquals(employee.get("name"), entry.getValue());
			logger.debug(employee);
		}
		
		// Find by names
		Map<String, Object> adrian = connection.findByKey("employees", "name", "Adrian");
		Assert.assertNotNull("Adrian employee was not found...", adrian);
		Assert.assertEquals("Expected name is Adrian", "Adrian", adrian.get("name"));
		Map<String, Object> juan = connection.findByKey("employees", "name", "Juan");
		Assert.assertNotNull("Juan employee was not found...", juan);
		Assert.assertEquals("Expected name is Juan", "Juan", juan.get("name"));
		Map<String, Object> leonardo = connection.findByKey("employees", "name", "Leonardo");
		Assert.assertNotNull("Leonardo employee was not found...", leonardo);
		Assert.assertEquals("Expected name is Leonardo", "Leonardo", leonardo.get("name"));
		
		List<Map<String, Object>> allProjects = connection.findAll("projects");
		Assert.assertFalse("There are not projects in the database", allProjects.isEmpty());
		Assert.assertTrue("There should be one project", allProjects.size() == 1);
		
		for (Map.Entry<String, String> entry : ids.entrySet()) {
			connection.delete("employees", entry.getKey());
		}
		
		allEmployees = connection.findAll("employees");
		Assert.assertTrue("Employees should be empty", allEmployees.isEmpty());
		
		connection.close();
		Database.shutdown();		
	}
	
	private Map<String, Object> createAdrianParedes() {
		Map<String, Object> employee = new HashMap<String, Object>();
		employee.put("name", "Adrian");
		employee.put("lastName", "Paredes");
		employee.put("dateOfBirth", new GregorianCalendar(
				1982, Calendar.JUNE, 3).getTime());
		employee.put("fileNumber", 854223);
		return employee;
	}

	private Map<String, Object> createJuanGaragorri() {
		Map<String, Object> employee = new HashMap<String, Object>();
		employee.put("name", "Juan");
		employee.put("lastName", "Garagorri");
		employee.put("dateOfBirth", new GregorianCalendar(
				1984, Calendar.FEBRUARY, 16).getTime());
		employee.put("fileNumber", 152660);
		return employee;
	}
	
	private Map<String, Object> createLeonardoPavanello() {
		Map<String, Object> employee = new HashMap<String, Object>();
		employee.put("name", "Leonardo");
		employee.put("lastName", "Pavanello");
		employee.put("dateOfBirth", new GregorianCalendar(
				1985, Calendar.DECEMBER, 22).getTime());
		employee.put("fileNumber", 8763344);
		return employee;
	}
	
	private Map<String, Object> createProject() {
		Map<String, Object> project = new HashMap<String, Object>();
		project.put("name", "Predictive Engine");
		project.put("durationInMonths", 5);
		project.put("clientName", "OSDE");
		project.put("projectType", "DEVELOPMENT");
		return project;
	}

}
