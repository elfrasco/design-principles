package ar.com.epidataconsulting.principles.inmutability;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class MoneyServiceTest {
	
	private static final Logger logger = Logger.getLogger(MoneyServiceTest.class);

	@Test
	public void sum() {
		Currency pesos = new Currency("ARS", "$");
		Money m1 = new Money(new BigDecimal(20), pesos);
		Money m2 = new Money(new BigDecimal(20), pesos);
		
		MoneyService moneyService = new MoneyService();
		Money m3 = moneyService.sum(m1, m2);
		
		Assert.assertEquals(new BigDecimal(20), m1.getValue());
		Assert.assertEquals(new BigDecimal(20), m2.getValue());
		Assert.assertEquals(new BigDecimal(40), m3.getValue());
		Assert.assertEquals(pesos, m3.getCurrency());
	}
	
	@Test
	public void subtraction() {
		Currency pesos = new Currency("ARS", "$");
		Money m1 = new Money(new BigDecimal(30), pesos);
		Money m2 = new Money(new BigDecimal(20), pesos);
		
		MoneyService moneyService = new MoneyService();
		Money m3 = moneyService.subtraction(m1, m2);

		Assert.assertEquals(new BigDecimal(30), m1.getValue());
		Assert.assertEquals(new BigDecimal(20), m2.getValue());
		Assert.assertEquals(new BigDecimal(10), m3.getValue());
		Assert.assertEquals(pesos, m3.getCurrency());
	}
	
	@Test
	public void differentCurrency() {
		Currency pesos = new Currency("ARS", "$");
		Currency dollar = new Currency("USD", "U$S");
		
		Money m1 = new Money(new BigDecimal(20), pesos);
		Money m2 = new Money(new BigDecimal(20), dollar);
		
		MoneyService moneyService = new MoneyService();
		try {
			moneyService.sum(m1, m2);
		} catch (DifferentCurrenciesException ex) {
			logger.debug(ex.getMessage());
			return;
		}
		Assert.fail("It should have thrown the DifferentCurrenciesException");
	}
}
