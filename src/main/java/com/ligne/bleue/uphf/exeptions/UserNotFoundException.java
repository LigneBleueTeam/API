package com.ligne.bleue.uphf.exeptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2720575730945781647L;

	public UserNotFoundException(Long id) {
		super("Aucun utilisateur avec l'id : " + id + " n'a été trouvé.");
	}

	public UserNotFoundException() {
		super("Aucun utilisateur n'a été trouvé.");
	}

}
