package ar.com.epidataconsulting.principles.dry.after;

import java.util.Map;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.model.Employee;

public class EmployeeDAO {

	private static final String COLLECTION_NAME = "employees";
	
	private DAOUtil daoUtil = new DAOUtil();

	public void save(Employee employee) {
		
		Connection connection = daoUtil.getConnection();

		Map<String, Object> employeeMap = daoUtil.employeeToMap(employee);
		
		connection.insert(COLLECTION_NAME, employeeMap);
		
		daoUtil.closeConnection(connection);
	}

	public Employee findById(String id) {
		
		Connection connection = daoUtil.getConnection();
		
		Map<String, Object> employeeMap = connection.findById(COLLECTION_NAME, id);
		
		daoUtil.closeConnection(connection);
		
		Employee employee = daoUtil.mapToEmployee(employeeMap);
		
		return employee;
	}

	public Employee findByLastName(String lastName) {

		Connection connection = daoUtil.getConnection();
		
		Map<String, Object> employeeMap = connection.findByKey(COLLECTION_NAME, "lastName", lastName);
		
		daoUtil.closeConnection(connection);
		
		Employee employee = daoUtil.mapToEmployee(employeeMap);
		
		return employee;
	}
	
	public void remove(String id) {
		
		Connection connection = daoUtil.getConnection();
		
		connection.delete(COLLECTION_NAME, id);
		
		daoUtil.closeConnection(connection);		
	}

}
