package ar.com.epidataconsulting.principles.lsp.before;

import ar.com.epidataconsulting.principles.model2.Analyst;
import ar.com.epidataconsulting.principles.model2.Architect;
import ar.com.epidataconsulting.principles.model2.Developer;
import ar.com.epidataconsulting.principles.model2.Employee;
import ar.com.epidataconsulting.principles.model2.Project;
import ar.com.epidataconsulting.principles.model2.ProjectManager;
import ar.com.epidataconsulting.principles.model2.Tester;
import ar.com.epidataconsulting.principles.model2.mock.ProjectMockBuilder;

public class TheBoss {

	public void whip(ProjectManager projectManager) {
		if (projectManager.hasAProject()) {
			projectManager.work();
		}
	}
	
	public void whip(Tester tester) {
		if (tester.hasAProject()) {
			tester.work();
		}
	}
	
	public void whip(Analyst analyst) {
		if (analyst.hasAProject()) {
			analyst.work();
		}
	}
	
	public void whip(Architect architect) {
		if (architect.hasAProject()) {
			architect.work();
		}
	}
	
	public void whip(Developer developer) {
		if (developer.hasAProject()) {
			developer.work();
		}
	}
	
	public static void main(String[] args) {
		
		Project predictiveEngine = ProjectMockBuilder.createPredictiveEngine();
		TheBoss theBoss = new TheBoss();
		
		for (Employee employee : predictiveEngine.getTeam()) {
			if (employee instanceof ProjectManager) {
				theBoss.whip((ProjectManager) employee);
			} else if (employee instanceof Architect) {
				theBoss.whip((Architect) employee);
			} else if (employee instanceof Analyst) {
				theBoss.whip((Analyst) employee);
			} else if (employee instanceof Developer) {
				theBoss.whip((Developer) employee);
			} else if (employee instanceof Tester) {
				theBoss.whip((Tester) employee);
			}
		}
	}
	
}
