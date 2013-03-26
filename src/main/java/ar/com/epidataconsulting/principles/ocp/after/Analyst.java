package ar.com.epidataconsulting.principles.ocp.after;

import org.apache.log4j.Logger;

public class Analyst extends Employee {
	
	private static final Logger logger = Logger.getLogger(Analyst.class);

	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm an ANALYST! My job is to analyze! I'm analizing...");
	}
}
