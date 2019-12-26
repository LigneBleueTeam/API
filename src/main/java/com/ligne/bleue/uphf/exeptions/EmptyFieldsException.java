package com.ligne.bleue.uphf.exeptions;

public class EmptyFieldsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7522556488135991400L;

	public EmptyFieldsException() {
		super("Paramètre manquant ou invalide.");
	}

}