package ar.com.epidataconsulting.principles.database;

import java.text.MessageFormat;

public class UnknownSchemaException extends RuntimeException {

	private static final long serialVersionUID = 1739153250125764065L;

	public UnknownSchemaException(String schemaName) {
		super(MessageFormat.format(
				"Unknown schema: {0}", schemaName));
	}
	
}
