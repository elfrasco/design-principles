package ar.com.epidataconsulting.principles.model2;

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
	
	public void work() {
		logger.debug("Employee working!!!");
	}
	
	public boolean hasAProject() {
		return true;
	}

}
