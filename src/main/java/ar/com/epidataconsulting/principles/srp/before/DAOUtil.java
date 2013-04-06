package ar.com.epidataconsulting.principles.srp.before;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.database.Database;
import ar.com.epidataconsulting.principles.model.Employee;

public class DAOUtil {
	
	public Map<String, Object> employeeToMap(Employee employee) {
		Map<String, Object> employeeMap = new HashMap<String, Object>();
		employeeMap.put("id", employee.getId());
		employeeMap.put("name", employee.getName());
		employeeMap.put("secondName", employee.getSecondName());
		employeeMap.put("lastName", employee.getLastName());
		employeeMap.put("dateOfBirth", employee.getDateOfBirth());
		employeeMap.put("fileNumber", employee.getFileNumber());
		return employeeMap;
	}
	
	public Employee mapToEmployee(Map<String, Object> employeeMap) {
		Employee employee = new Employee();
		employee.setId((String) employeeMap.get("id"));
		employee.setFileNumber((String) employeeMap.get("fileNumber"));
		employee.setName((String) employeeMap.get("name"));
		employee.setSecondName((String) employeeMap.get("secondName"));
		employee.setLastName((String) employeeMap.get("lastName"));
		employee.setDateOfBirth((Date) employeeMap.get("dateOfBirth"));
		return employee;
	}

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
