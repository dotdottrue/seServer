package de.project.exception;

import de.project.enumerations.ReturnCode;

public class NotesNotExistException extends ProjectException {

	private static final long serialVersionUID = -2878040927917546056L;

	public NotesNotExistException(String message) {
		super(ReturnCode.ERROR, message);
	}

}
