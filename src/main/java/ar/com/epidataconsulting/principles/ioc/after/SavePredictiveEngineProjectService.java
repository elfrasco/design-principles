package ar.com.epidataconsulting.principles.ioc.after;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import ar.com.epidataconsulting.principles.model2.Project;
import ar.com.epidataconsulting.principles.model2.mock.ProjectMockBuilder;

public class SavePredictiveEngineProjectService {
	
	private static final Logger logger = Logger.getLogger(SavePredictiveEngineProjectService.class);
	
	private static final String CONFIG_FILE_PATH = "src/main/java/ar/com/epidataconsulting/principles/ioc/after/applicationContext.xml";

	public void save() {
		
		// Create the Predictive Engine Project
		Project project = ProjectMockBuilder.createPredictiveEngine();
		
		// Persist the project
		ApplicationContext factory = new FileSystemXmlApplicationContext(CONFIG_FILE_PATH);
		ProjectDAO projectDAO = (ProjectDAO) factory.getBean("projectDAO");
		projectDAO.save(project);
		
		// Recovery the project to assert
		Project projectRecovered = projectDAO.findByName("Predictive Engine");
		logger.debug("NAME = " + projectRecovered.getName());
		logger.debug("CLIENT = " + projectRecovered.getClientName());
		logger.debug("TEAM SIZE = " + projectRecovered.getTeam().size());
		
	}
	
	public static void main(String[] args) {
		SavePredictiveEngineProjectService service = new SavePredictiveEngineProjectService();
		service.save();
	}
}
