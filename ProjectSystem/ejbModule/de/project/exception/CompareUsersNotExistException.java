package de.project.exception;

import de.project.enumerations.ReturnCode;

/**
 * 
 * @author Tobias Kappert
 *
 */
public class CompareUsersNotExistException extends ProjectException {

	private static final long serialVersionUID = -4147698608510860224L;

	public CompareUsersNotExistException(String message) {
		super(ReturnCode.ERROR,message);
	}

}
