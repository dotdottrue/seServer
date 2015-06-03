package de.project.dto.user;

import java.io.Serializable;

public class UserTO implements Serializable {

	private static final long serialVersionUID = 2932088743448571474L;

	private String email;
	private String firstName;
	private String lastName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return email;
	}
	
}