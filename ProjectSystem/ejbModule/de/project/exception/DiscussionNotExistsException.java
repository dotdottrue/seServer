package de.project.exception;

import de.project.enumerations.ReturnCode;

public class DiscussionNotExistsException extends ProjectException {

	private static final long serialVersionUID = -4038108912008697111L;

	public DiscussionNotExistsException(String message) {
		super(ReturnCode.ERROR, message);
	}	
	
}
