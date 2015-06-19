package de.project.exception;

import de.project.enumerations.ReturnCode;

/**
 * 
 * @author Tobias Kappert
 *
 */
public class ProjectValidationException extends Exception{

	private static final long serialVersionUID = -8848399920233582452L;
	
	private ReturnCode errorCode;
	
	public ProjectValidationException(ReturnCode errorCode, String message){
		super(message);
		this.errorCode = errorCode;		
	}

	public ReturnCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ReturnCode errorCode) {
		this.errorCode = errorCode;
	}	
}