package de.project.dto.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Aufbau des UserTransferObjects.
 *
 */
public class UserTO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private Date registrationDate;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
		
}
