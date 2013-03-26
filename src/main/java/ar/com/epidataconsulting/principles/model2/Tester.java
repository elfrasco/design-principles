package ar.com.epidataconsulting.principles.model2;

import org.apache.log4j.Logger;

public class Tester extends Employee {
	
	private static final Logger logger = Logger.getLogger(Tester.class);

	@Override
	public void work() {
		logger.debug("I'm " + getName() + "! I'm an TESTER! My job is to test! I'm testing...");
	}
}
