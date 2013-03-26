package ar.com.epidataconsulting.principles.dip.after;

import ar.com.epidataconsulting.principles.model2.Project;

public interface ProjectDAO {

	void save(Project project);
	Project findByName(String name);
	
}