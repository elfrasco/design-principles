package ar.com.epidataconsulting.principles.dip.after;

import java.util.Map;

import ar.com.epidataconsulting.principles.database.Connection;
import ar.com.epidataconsulting.principles.model2.Project;

public class ProjectHashMapDAO implements ProjectDAO {

	private static final String COLLECTION_NAME = "projects";
	
	private ConnectionManager connectionManager;
	
	private ProjectMapper projectMapper;
	
	@Override
	public void save(Project project) {
		
		Connection connection = connectionManager.getConnection();
		
		Map<String, Object> projectMap = projectMapper.projectToMap(project);
		
		connection.insert(COLLECTION_NAME, projectMap);
		
		connectionManager.closeConnection(connection);
		
	}
	
	@Override
	public Project findByName(String name) {
		
		Connection connection = connectionManager.getConnection();
		
		Map<String, Object> projectMap = connection.findByKey(COLLECTION_NAME, "name", name);
		
		connectionManager.closeConnection(connection);
		
		Project project = projectMapper.mapToProject(projectMap);
		
		return project;
	}
	
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}
	
}
