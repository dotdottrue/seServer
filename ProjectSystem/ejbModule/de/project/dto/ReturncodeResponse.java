package de.project.dto;

import java.io.Serializable;

import de.project.enumerations.ReturnCode;

public class ReturncodeResponse implements Serializable{

	private static final long serialVersionUID = -9201142429630293568L;
	
	private ReturnCode returnCode;
	private String message;
	
	public ReturncodeResponse() {
		this.returnCode = ReturnCode.OK;
	}

	public ReturnCode getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(ReturnCode returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
