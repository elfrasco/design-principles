package ar.com.epidataconsulting.principles.freesideeffect.before;

/**
 * 
 * Example extracted from the "Clean Code" book, of Robert C. Martin (Uncle Bob) 
 * 
 *
 */
public class UserValidator {

	private Cryptographer cryptographer;

	public boolean checkPassword(String userName, String password) {
		User user = UserGateway.findByName(userName);
		if (user != null) {
			String codedPhrase = user.getPhraseEncodedByPassword();
			String phrase = cryptographer.decrypt(codedPhrase, password);
			if ("Valid Password".equals(phrase)) {
				Session.initialize();
				return true;
			}
		}
		return false;
	}
	
}
