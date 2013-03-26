package ar.com.epidataconsulting.principles.model2;

import java.util.List;

import ar.com.epidataconsulting.principles.model.ProjectType;

public class Project {

	private String id;
	
	private String name;
	
	private Integer durationInMonths;
	
	private String clientName;
	
	private ProjectType type;
	
	private List<Employee> team;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(Integer durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

	public List<Employee> getTeam() {
		return team;
	}

	public void setTeam(List<Employee> team) {
		this.team = team;
	}
	
	public void execute() {
		if (team != null) {
			for (Employee employee : team) {
				employee.work();
			}
		}
	}
	
}
