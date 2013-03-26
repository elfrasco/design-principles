package ar.com.epidataconsulting.principles.inmutability;


public class MoneyService {

	public Money sum(Money m1, Money m2) {
		validateCurrency(m1, m2);
		return new Money(m1.getValue().add(m2.getValue()), m1.getCurrency());
	}
	
	public Money subtraction(Money m1, Money m2) {
		validateCurrency(m1, m2);
		return new Money(m1.getValue().subtract(m2.getValue()), m1.getCurrency());
	}
	
	private void validateCurrency(Money m1, Money m2) {
		if (!m1.getCurrency().equals(m2.getCurrency())) {
			throw new DifferentCurrenciesException(m1.getCurrency(), m2.getCurrency());
		}
	}
	
}
