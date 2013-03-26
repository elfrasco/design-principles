package ar.com.epidataconsulting.principles.model2;

import org.apache.log4j.Logger;

public class ProjectManager extends Employee {
	
	private static final Logger logger = Logger.getLogger(ProjectManager.class);

	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm a MANAGER! My job is to manage! I'm managing...");
	}
}
