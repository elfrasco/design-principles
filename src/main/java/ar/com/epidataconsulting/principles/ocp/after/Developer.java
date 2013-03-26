package ar.com.epidataconsulting.principles.ocp.after;

import org.apache.log4j.Logger;

public class Developer extends Employee {
	
	private static final Logger logger = Logger.getLogger(Developer.class);

	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm a DEVELOPER! My job is to develop! I'm developing...");
	}
}
