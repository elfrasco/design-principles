package ar.com.epidataconsulting.principles.inmutability;

import java.text.MessageFormat;

public class DifferentCurrenciesException extends RuntimeException {

	private static final long serialVersionUID = -6315249708334530082L;

	public DifferentCurrenciesException(Currency c1, Currency c2) {
		super(MessageFormat.format("ERROR: Currencies {0} and {1} ARE NOT EQUALS",
				c1.getCode(), c2.getCode()));
	}
}
