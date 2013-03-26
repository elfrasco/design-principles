package ar.com.epidataconsulting.principles.isp.before;

import org.apache.log4j.Logger;

import ar.com.epidataconsulting.principles.model2.Employee;

public class Developer extends Employee implements Workable {

	private static final Logger logger = Logger.getLogger(Developer.class);
	
	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm a DEVELOPER! My job is to develop! I'm developing...");
	}

	@Override
	public void eat() {
		logger.debug("Ey! I am a human! I need to EAT!!");
	}
	
}
