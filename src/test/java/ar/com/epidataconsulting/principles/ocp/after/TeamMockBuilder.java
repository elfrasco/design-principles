package ar.com.epidataconsulting.principles.ocp.after;

import java.util.ArrayList;
import java.util.List;

public class TeamMockBuilder {

	public static List<Employee> createTeam() {
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
