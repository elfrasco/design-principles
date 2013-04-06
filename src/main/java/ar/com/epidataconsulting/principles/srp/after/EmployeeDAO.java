package ar.com.epidataconsulting.principles.srp.after;

import java.util.Map;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.model.Employee;

public class EmployeeDAO {

	private static final String COLLECTION_NAME = "employees";
	
	private ConnectionManager connectionManager = new ConnectionManager();
	
	private EmployeeMapper employeeMapper = new EmployeeMapper();

	public void save(Employee employee) {
		
		Connection connection = connectionManager.getConnection();

		Map<String, Object> employeeMap = employeeMapper.employeeToMap(employee);
		
		connection.insert(COLLECTION_NAME, employeeMap);
		
		connectionManager.closeConnection(connection);
	}

	public Employee findById(String id) {
		
		Connection connection = connectionManager.getConnection();
		
		Map<String, Object> employeeMap = connection.findById(COLLECTION_NAME, id);
		
		connectionManager.closeConnection(connection);
		
		Employee employee = employeeMapper.mapToEmployee(employeeMap);
		
		return employee;
	}

	public Employee findByLastName(String lastName) {

		Connection connection = connectionManager.getConnection();
		
		Map<String, Object> employeeMap = connection.findByKey(COLLECTION_NAME, "lastName", lastName);
		
		connectionManager.closeConnection(connection);
		
		Employee employee = employeeMapper.mapToEmployee(employeeMap);
		
		return employee;
	}
	
	public void remove(String id) {
		
		Connection connection = connectionManager.getConnection();
		
		connection.delete(COLLECTION_NAME, id);
		
		connectionManager.closeConnection(connection);		
	}

}
