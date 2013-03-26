package ar.com.epidataconsulting.principles.ocp.after;

import ar.com.epidataconsulting.principles.model.ProjectType;

public class ProjectMockBuilder {

	public static Project createPredictiveEngine() {
		Project project = new Project();
		project.setName("Predictive Engine");
		project.setClientName("OSDE");
		project.setDurationInMonths(4);
		project.setType(ProjectType.DEVELOPMENT);
		return project;
	}

}
