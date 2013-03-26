package ar.com.epidataconsulting.principles.dip.after;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ar.com.epidataconsulting.principles.model2.Project;

public class SavePredictiveEngineProjectService {
	
	private static final Logger logger = Logger.getLogger(SavePredictiveEngineProjectService.class);
	
	private static final String CONFIG_FILE_PATH = "src/main/java/ar/com/epidataconsulting/principles/dip/after/applicationContext.xml";
	
	private ProjectDAO projectDAO;
	
	private Project project;

	public void save() {
		
		// Persist the project
		projectDAO.save(project);
		
		// Recovery the project to assert
		Project projectRecovered = projectDAO.findByName("Predictive Engine");
		
		// Log results
		logger.debug("NAME = " + projectRecovered.getName());
		logger.debug("CLIENT = " + projectRecovered.getClientName());
		logger.debug("TEAM SIZE = " + projectRecovered.getTeam().size());
		
	}
	
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public static void main(String[] args) {
		ApplicationContext factory = new FileSystemXmlApplicationContext(CONFIG_FILE_PATH);
		SavePredictiveEngineProjectService saveProjectService = (SavePredictiveEngineProjectService) factory.getBean("saveProjectService");
		saveProjectService.save();
	}
}
