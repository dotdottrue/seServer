package de.project.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String phoneNumber;
	private String firstName;
	private String lastName;

	private Calendar registrationDate;
	
	@ManyToMany(mappedBy = "members")
	private List<Project> projects;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String phoneNumber, Calendar registrationDate) {
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
	}
	
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

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@Override
	public String toString() {
		return "Die Telefonnummer lautet: " + phoneNumber;
	}

}