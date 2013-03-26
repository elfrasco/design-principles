package ar.com.epidataconsulting.principles.ocp.after;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void work() {
		Project project = createProject();
		project.execute();
	}
	
	private Project createProject() {
		Project project = ProjectMockBuilder.createPredictiveEngine();
		project.setTeam(TeamMockBuilder.createTeam());
		return project;
	}
	
}
