package ar.com.epidataconsulting.principles.model2;

import org.apache.log4j.Logger;

public class Architect extends Employee {
	
	private static final Logger logger = Logger.getLogger(Architect.class);

	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm an ARCHITECT! My job is to design! I'm designing...");
	}
}
