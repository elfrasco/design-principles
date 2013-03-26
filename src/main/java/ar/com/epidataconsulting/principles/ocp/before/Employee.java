package ar.com.epidataconsulting.principles.ocp.before;

import java.util.Date;

import org.apache.log4j.Logger;

public class Employee {

	private static final Logger logger = Logger.getLogger(Employee.class);
	
	private String id;
	
	private String name;
	
	private String secondName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private String fileNumber;
	
	private EmployeeType type;

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

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	
	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	public EmployeeType getType() {
		return type;
	}
	
	public void work() {
		switch (type) {
			case DEVELOPER:
				logger.debug("I'm " + name + "! I'm a DEVELOPER! My job is to develop! I'm developing...");
				break;
			case ANALYST:
				logger.debug("I'm " + name + "! I'm an ANALYST! My job is to analyze! I'm analizing...");
				break;
			case ARCHITECT:
				logger.debug("I'm " + name + "! I'm an ARCHITECT! My job is to design! I'm designing...");
				break;
			case TESTER:
				logger.debug("I'm " + name + "! I'm an TESTER! My job is to test! I'm testing...");
				break;
			case PROJECT_MANAGER:
				logger.debug("I'm " + name + "! I'm a MANAGER! My job is to manage! I'm managing...");
				break;
		}
	}
	
}
