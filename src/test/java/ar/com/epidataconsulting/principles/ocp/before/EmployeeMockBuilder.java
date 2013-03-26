package ar.com.epidataconsulting.principles.ocp.before;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmployeeMockBuilder {

	public static Employee createFlorenciaCastagnino() {
		Employee employee = new Employee();
		employee.setName("Florencia");
		employee.setLastName("Castagnino");
		employee.setDateOfBirth(new GregorianCalendar(1980, Calendar.JANUARY, 15).getTime());
		employee.setFileNumber("123");
		return employee;
	}
	
	public static Employee createAdrianParedes() {
		Employee employee = new Employee();
		employee.setName("Adrian");
		employee.setSecondName("Marcelo");
		employee.setLastName("Paredes");
		employee.setDateOfBirth(new GregorianCalendar(1982, Calendar.JUNE, 3).getTime());
		employee.setFileNumber("456");
		return employee;
	}
	
	public static Employee createLeonardoPavanello() {
		Employee employee = new Employee();
		employee.setName("Leonardo");
		employee.setLastName("Pavanello");
		employee.setDateOfBirth(new GregorianCalendar(1984, Calendar.MAY, 28).getTime());
		employee.setFileNumber("789");
		return employee;		
	}
	
	public static Employee createJuanGaragorri() {
		Employee employee = new Employee();
		employee.setName("Juan");
		employee.setLastName("Garagorri");
		employee.setDateOfBirth(new GregorianCalendar(1986, Calendar.AUGUST, 11).getTime());
		employee.setFileNumber("859");
		return employee;		
	}
	
	public static Employee createVeronicaPechersky() {
		Employee employee = new Employee();
		employee.setName("Veronica");
		employee.setLastName("Pechersky");
		employee.setDateOfBirth(new GregorianCalendar(1981, Calendar.APRIL, 5).getTime());
		employee.setFileNumber("242");
		return employee;		
	}
	
	public static Employee createEricaQuispe() {
		Employee employee = new Employee();
		employee.setName("Erica");
		employee.setLastName("Quispe");
		employee.setDateOfBirth(new GregorianCalendar(1983, Calendar.SEPTEMBER, 21).getTime());
		employee.setFileNumber("999");
		return employee;			
	}
}
