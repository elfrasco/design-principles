package ar.com.epidataconsulting.principles.isp.after;

import org.apache.log4j.Logger;

import ar.com.epidataconsulting.principles.model2.Employee;

public class Tester extends Employee implements Workable, Feedable {

	private static final Logger logger = Logger.getLogger(Tester.class);
	
	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm an TESTER! My job is to test! I'm testing...");
	}

	@Override
	public void eat() {
		logger.debug("Ey! I am a human! I need to EAT too!!");
	}

}
