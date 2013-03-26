package ar.com.epidataconsulting.principles.model2.mock;

import java.util.ArrayList;
import java.util.List;

import ar.com.epidataconsulting.principles.model.ProjectType;
import ar.com.epidataconsulting.principles.model2.Employee;
import ar.com.epidataconsulting.principles.model2.Project;

public class ProjectMockBuilder {

	public static Project createPredictiveEngine() {
		Project project = new Project();
		project.setName("Predictive Engine");
		project.setClientName("OSDE");
		project.setDurationInMonths(4);
		project.setType(ProjectType.DEVELOPMENT);
		project.setTeam(createTeam());
		return project;
	}
	
	private static List<Employee> createTeam() {

		Employee florencia = EmployeeMockBuilder.createFlorenciaCastagnino();		
		Employee adrian = EmployeeMockBuilder.createAdrianParedes();		
		Employee leonardo = EmployeeMockBuilder.createLeonardoPavanello();		
		Employee juan = EmployeeMockBuilder.createJuanGaragorri();		
		Employee veronica = EmployeeMockBuilder.createVeronicaPechersky();
		Employee erica = EmployeeMockBuilder.createEricaQuispe();
		
		List<Employee> team = new ArrayList<Employee>();
		team.add(florencia);
		team.add(veronica);
		team.add(adrian);
		team.add(leonardo);
		team.add(juan);
		team.add(erica);
		return team;
	}

}
