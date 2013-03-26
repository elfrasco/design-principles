package ar.com.epidataconsulting.principles.ioc.after;

import org.apache.log4j.Logger;

import ar.com.epidataconsulting.principles.model2.Project;
import ar.com.epidataconsulting.principles.model2.mock.ProjectMockBuilder;

public class ProjectHibernateDAO implements ProjectDAO {
	
	private static final Logger logger = Logger.getLogger(ProjectHibernateDAO.class);

	@Override
	public void save(Project project) {
		logger.debug("Using HIBERNATE to SAVE the PROJECT...");
	}

	@Override
	public Project findByName(String name) {
		logger.debug("Using HIBERNATE to RECOVER the PROJECT...");
		// Mock
		return ProjectMockBuilder.createPredictiveEngine();
	}

}
