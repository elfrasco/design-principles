package ar.com.epidataconsulting.principles.dry.before;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.database.Database;
import ar.com.epidataconsulting.principles.model.Employee;

public class EmployeeDAO {
	
	private static final String COLLECTION_NAME = "employees";

	public void save(Employee employee) {
		
		Database.start();
		Database.login("guest", "guest");
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);

		Map<String, Object> employeeMap = new HashMap<String, Object>();
		employeeMap.put("id", employee.getId());
		employeeMap.put("name", employee.getName());
		employeeMap.put("secondName", employee.getSecondName());
		employeeMap.put("lastName", employee.getLastName());
		employeeMap.put("dateOfBirth", employee.getDateOfBirth());
		employeeMap.put("fileNumber", employee.getFileNumber());
		
		connection.insert(COLLECTION_NAME, employeeMap);
		
		connection.close();
		Database.shutdown();
	}
	
	public Employee findById(String id) {
		
		Database.start();
		Database.login("guest", "guest");
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		
		Map<String, Object> employeeMap = connection.findById(COLLECTION_NAME, id);
		
		connection.close();
		Database.shutdown();
		
		Employee employee = new Employee();
		employee.setId((String) employeeMap.get("id"));
		employee.setFileNumber((String) employeeMap.get("fileNumber"));
		employee.setName((String) employeeMap.get("name"));
		employee.setSecondName((String) employeeMap.get("secondName"));
		employee.setLastName((String) employeeMap.get("lastName"));
		employee.setDateOfBirth((Date) employeeMap.get("dateOfBirth"));
		
		return employee;
	}
	
	public Employee findByLastName(String lastName) {

		Database.start();
		Database.login("guest", "guest");
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		
		Map<String, Object> employeeMap = connection.findByKey(COLLECTION_NAME, "lastName", lastName);
		
		connection.close();
		Database.shutdown();
		
		Employee employee = new Employee();
		employee.setId((String) employeeMap.get("id"));
		employee.setFileNumber((String) employeeMap.get("fileNumber"));
		employee.setName((String) employeeMap.get("name"));
		employee.setSecondName((String) employeeMap.get("secondName"));
		employee.setLastName((String) employeeMap.get("lastName"));
		employee.setDateOfBirth((Date) employeeMap.get("dateOfBirth"));
		
		return employee;
	}
	
	public void remove(String id) {
		
		Database.start();
		Database.login("guest", "guest");
		Connection connection = Database.getConnection(Database.SOFTWARE_FACTORY_SCHEMA_NAME);
		
		connection.delete(COLLECTION_NAME, id);
		
		connection.close();
		Database.shutdown();		
	}
	
}
