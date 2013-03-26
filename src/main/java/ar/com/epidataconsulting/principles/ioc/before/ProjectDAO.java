package ar.com.epidataconsulting.principles.ioc.before;

import java.util.Map;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.model2.Project;

public class ProjectDAO {

	private static final String COLLECTION_NAME = "projects";
	
	private ConnectionManager connectionManager = new ConnectionManager();
	
	private ProjectMapper projectMapper = new ProjectMapper();
	
	public void save(Project project) {
		
		Connection connection = connectionManager.getConnection();
		
		Map<String, Object> projectMap = projectMapper.projectToMap(project);
		
		connection.insert(COLLECTION_NAME, projectMap);
		
		connectionManager.closeConnection(connection);
		
	}
	
	public Project findByName(String name) {
		
		Connection connection = connectionManager.getConnection();
		
		Map<String, Object> projectMap = connection.findByKey(COLLECTION_NAME, "name", name);
		
		connectionManager.closeConnection(connection);
		
		Project project = projectMapper.mapToProject(projectMap);
		
		return project;
	}
	
}
