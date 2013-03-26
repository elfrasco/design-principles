package ar.com.epidataconsulting.principles.database;

import java.text.MessageFormat;

public class UnknownCollectionException extends RuntimeException {

	private static final long serialVersionUID = 4043601774909611677L;

	public UnknownCollectionException(String collectionName) {
		super(MessageFormat.format(
				"ERROR: Unknown Collection: {0}", collectionName));
	}
	
}
