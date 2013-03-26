package ar.com.epidataconsulting.principles.isp.before;

import org.apache.log4j.Logger;

import ar.com.epidataconsulting.principles.model2.Employee;

public class Robot extends Employee implements Workable {

	private static final Logger logger = Logger.getLogger(Developer.class);
	
	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm a ROBOT! I work much FASTER than any foolish human...");
	}
	
	@Override
	public void eat() {
		// Nothing TO-DO here: ROBOT doesn't eat!!
	}

}
