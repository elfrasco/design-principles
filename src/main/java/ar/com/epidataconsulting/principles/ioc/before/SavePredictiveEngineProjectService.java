package ar.com.epidataconsulting.principles.ioc.before;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;

import ar.com.epidataconsulting.principles.model.ProjectType;
import ar.com.epidataconsulting.principles.model2.Analyst;
import ar.com.epidataconsulting.principles.model2.Architect;
import ar.com.epidataconsulting.principles.model2.Developer;
import ar.com.epidataconsulting.principles.model2.Employee;
import ar.com.epidataconsulting.principles.model2.Project;
import ar.com.epidataconsulting.principles.model2.ProjectManager;
import ar.com.epidataconsulting.principles.model2.Tester;

public class SavePredictiveEngineProjectService {
	
	private static final Logger logger = Logger.getLogger(SavePredictiveEngineProjectService.class);

	public void save() {
		
		// Create the Predictive Engine Project
		Project project = new Project();
		project.setName("Predictive Engine");
		project.setClientName("OSDE");
		project.setDurationInMonths(4);
		project.setType(ProjectType.DEVELOPMENT);
		project.setTeam(createTeam());
		
		// Persist the project
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.save(project);
		
		// Recovery the project to assert
		Project projectRecovered = projectDAO.findByName("Predictive Engine");
		logger.debug("NAME = " + projectRecovered.getName());
		logger.debug("CLIENT = " + projectRecovered.getClientName());
		logger.debug("TEAM SIZE = " + projectRecovered.getTeam().size());
		
	}
	
	private List<Employee> createTeam() {
		
		Employee florencia = createFlorenciaCastagnino();		
		Employee adrian = createAdrianParedes();		
		Employee leonardo = createLeonardoPavanello();		
		Employee juan = createJuanGaragorri();		
		Employee veronica = createVeronicaPechersky();
		Employee erica = createEricaQuispe();
		
		List<Employee> team = new ArrayList<Employee>();
		team.add(florencia);
		team.add(veronica);
		team.add(adrian);
		team.add(leonardo);
		team.add(juan);
		team.add(erica);
		return team;
	}

	private Employee createFlorenciaCastagnino() {
		Employee employee = new ProjectManager();
		employee.setName("Florencia");
		employee.setLastName("Castagnino");
		employee.setDateOfBirth(new GregorianCalendar(1980, Calendar.JANUARY, 15).getTime());
		employee.setFileNumber("123");
		return employee;
	}
	
	private Employee createAdrianParedes() {
		Employee employee = new Architect();
		employee.setName("Adrian");
		employee.setSecondName("Marcelo");
		employee.setLastName("Paredes");
		employee.setDateOfBirth(new GregorianCalendar(1982, Calendar.JUNE, 3).getTime());
		employee.setFileNumber("456");
		return employee;
	}
	
	private Employee createLeonardoPavanello() {
		Employee employee = new Developer();
		employee.setName("Leonardo");
		employee.setLastName("Pavanello");
		employee.setDateOfBirth(new GregorianCalendar(1984, Calendar.MAY, 28).getTime());
		employee.setFileNumber("789");
		return employee;		
	}
	
	private Employee createJuanGaragorri() {
		Employee employee = new Developer();
		employee.setName("Juan");
		employee.setLastName("Garagorri");
		employee.setDateOfBirth(new GregorianCalendar(1986, Calendar.AUGUST, 11).getTime());
		employee.setFileNumber("859");
		return employee;		
	}
	
	private Employee createVeronicaPechersky() {
		Employee employee = new Analyst();
		employee.setName("Veronica");
		employee.setLastName("Pechersky");
		employee.setDateOfBirth(new GregorianCalendar(1981, Calendar.APRIL, 5).getTime());
		employee.setFileNumber("242");
		return employee;		
	}
	
	private Employee createEricaQuispe() {
		Employee employee = new Tester();
		employee.setName("Erica");
		employee.setLastName("Quispe");
		employee.setDateOfBirth(new GregorianCalendar(1983, Calendar.SEPTEMBER, 21).getTime());
		employee.setFileNumber("999");
		return employee;			
	}

	public static void main(String[] args) {
		SavePredictiveEngineProjectService service = new SavePredictiveEngineProjectService();
		service.save();
	}
}
