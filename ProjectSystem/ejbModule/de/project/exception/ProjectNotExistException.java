package de.project.exception;

import de.project.enumerations.ReturnCode;

public class ProjectNotExistException extends ProjectException {

	private static final long serialVersionUID = 5220235703722100074L;
	
	public ProjectNotExistException(String message) {
		super(ReturnCode.ERROR, message);
	}
}
