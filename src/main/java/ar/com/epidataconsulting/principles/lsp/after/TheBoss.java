package ar.com.epidataconsulting.principles.lsp.after;

import ar.com.epidataconsulting.principles.model2.Employee;
import ar.com.epidataconsulting.principles.model2.Project;
import ar.com.epidataconsulting.principles.model2.mock.ProjectMockBuilder;

public class TheBoss {

	public void whip(Employee employee) {
		if (employee.hasAProject()) {
			employee.work();
		}
	}
	
	public static void main(String[] args) {
		
		Project predictiveEngine = ProjectMockBuilder.createPredictiveEngine();
		TheBoss theBoss = new TheBoss();
		
		for (Employee employee : predictiveEngine.getTeam()) {
			theBoss.whip(employee);
		}
	}
}
