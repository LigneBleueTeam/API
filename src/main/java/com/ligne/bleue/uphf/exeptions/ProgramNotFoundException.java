package com.ligne.bleue.uphf.exeptions;

public class ProgramNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 894371023156857176L;

	public ProgramNotFoundException(Long id) {
		super("Aucun programme avec l'id : " + id + " n'a été trouvé.");
	}

	public ProgramNotFoundException() {
		super("Aucun program n'a été trouvé.");
	}
}