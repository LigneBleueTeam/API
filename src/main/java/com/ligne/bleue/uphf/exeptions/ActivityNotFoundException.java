package com.ligne.bleue.uphf.exeptions;

public class ActivityNotFoundException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 35444369353940035L;

	public ActivityNotFoundException(Long id) {
        super("Aucune activité avec l'id : " + id+" n'a été trouvée.");
    }
	
	public ActivityNotFoundException() {
		super("Aucune activité n'a été trouvée.");
	}

}