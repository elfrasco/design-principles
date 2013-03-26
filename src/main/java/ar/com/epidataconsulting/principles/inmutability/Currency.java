package ar.com.epidataconsulting.principles.inmutability;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class Currency {

	private final String symbol;
	
	private final String code;
	
	public Currency(final String code, final String symbol) {
		this.symbol = symbol;
		this.code = code;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
    public boolean equals(Object obj) {
		if (obj == null || !Currency.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		Currency p = (Currency) obj;
		return (new EqualsBuilder().append(this.getCode(), p.getCode())).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getCode()).toHashCode();
    }
}
