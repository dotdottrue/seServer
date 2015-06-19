package de.project.exception;

import de.project.enumerations.ReturnCode;

public class ProjectException extends Exception {

	private static final long serialVersionUID = 3780882325084047970L;
	
	private ReturnCode errorCode;
	
	public ProjectException(ReturnCode errorCode, String message){
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
