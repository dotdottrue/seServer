package de.project.exception;

import de.project.enumerations.ReturnCode;

/**
 * 
 * @author Tobias Kappert
 *
 */
public class UserRegistrationException extends Exception {

	private static final long serialVersionUID = -462705714948900424L;
	
	private ReturnCode returnCode;
	
	public UserRegistrationException(ReturnCode returnCode, String message) {
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
