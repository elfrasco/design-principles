package ar.com.epidataconsulting.principles.ocp.before;

import java.util.ArrayList;
import java.util.List;

import ar.com.epidataconsulting.principles.ocp.before.Employee;
import ar.com.epidataconsulting.principles.ocp.before.EmployeeType;

public class TeamMockBuilder {

	public static List<Employee> createTeam() {
		Employee florencia = EmployeeMockBuilder.createFlorenciaCastagnino();
		florencia.setType(EmployeeType.PROJECT_MANAGER);
		
		Employee adrian = EmployeeMockBuilder.createAdrianParedes();
		adrian.setType(EmployeeType.ARCHITECT);
		
		Employee leonardo = EmployeeMockBuilder.createLeonardoPavanello();
		leonardo.setType(EmployeeType.DEVELOPER);
		
		Employee juan = EmployeeMockBuilder.createJuanGaragorri();
		juan.setType(EmployeeType.DEVELOPER);
		
		Employee veronica = EmployeeMockBuilder.createVeronicaPechersky();
		veronica.setType(EmployeeType.ANALYST);

		Employee erica = EmployeeMockBuilder.createEricaQuispe();
		erica.setType(EmployeeType.TESTER);
		
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
