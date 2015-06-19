package de.project.exception;

import de.project.enumerations.ReturnCode;

public class InvalidLoginException extends Exception {
	
	private static final long serialVersionUID = 4163666524986284120L;
	
	private ReturnCode returnCode;

	public InvalidLoginException(ReturnCode returnCode, String message) {
		super(message);
		this.returnCode = returnCode;
	}

	public ReturnCode getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}

}
