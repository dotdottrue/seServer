package de.project.exception;

import de.project.enumerations.ReturnCode;

/**
 * 
 * @author Tobias Kappert
 *
 */
public class UserLogoutException extends Exception {

	private static final long serialVersionUID = 8938078844630133924L;
	
	private ReturnCode returnCode;

	public UserLogoutException(ReturnCode returnCode, String message) {
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
