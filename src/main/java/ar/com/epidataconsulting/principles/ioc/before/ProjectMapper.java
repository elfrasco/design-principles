package ar.com.epidataconsulting.principles.ioc.before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.epidataconsulting.principles.model.ProjectType;
import ar.com.epidataconsulting.principles.model2.Employee;
import ar.com.epidataconsulting.principles.model2.Project;

public class ProjectMapper {
	
	private EmployeeMapper employeeMapper = new EmployeeMapper();

	public Map<String, Object> projectToMap(Project project) {
		Map<String, Object> projectMap = new HashMap<String, Object>();
		projectMap.put("id", project.getId());
		projectMap.put("name", project.getName());
		projectMap.put("clientName", project.getClientName());
		projectMap.put("durationInMoths", project.getDurationInMonths());
		projectMap.put("type", project.getType());
		List<Map<String, Object>> team = new ArrayList<Map<String, Object>>();
		for (Employee employee : project.getTeam()) {
			team.add(employeeMapper.employeeToMap(employee));
		}
		projectMap.put("team", team);
		return projectMap;
	}
	
	@SuppressWarnings("unchecked")
	public Project mapToProject(Map<String, Object> projectMap) {
		Project project = new Project();
		project.setId((String) projectMap.get("id"));
		project.setName((String) projectMap.get("name"));
		project.setClientName((String) projectMap.get("clientName"));
		project.setDurationInMonths((Integer) projectMap.get("durationInMonths"));
		project.setType((ProjectType) projectMap.get("type"));
		List<Employee> team = new ArrayList<Employee>();
		for (Map<String, Object> employeeMap : (List<Map<String, Object>>) projectMap.get("team")) {
			team.add(employeeMapper.mapToEmployee(employeeMap));
		}
		project.setTeam(team);
		return project;
	}
}
