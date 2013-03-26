package ar.com.epidataconsulting.principles.inmutability;

import java.math.BigDecimal;

public class Money {

	private final BigDecimal value;
	
	private final Currency currency;
	
	public Money(final BigDecimal value, final Currency currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
	public Currency getCurrency() {
		return currency;
	}
}
