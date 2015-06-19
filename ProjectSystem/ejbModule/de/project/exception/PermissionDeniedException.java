package de.project.exception;

import de.project.enumerations.ReturnCode;

public class PermissionDeniedException extends ProjectException {

	private static final long serialVersionUID = 5519151063188089873L;

	public PermissionDeniedException(String message) {
		super(ReturnCode.PERMISSION_DENIED, message);

	}	
	
}
