package de.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = -6846170565657858908L;
	
	@Id
	//@GeneratedValue
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private Date registrationDate;
	
	@ManyToMany(mappedBy="members")
	private List<Project> projects;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String phoneNumber, String firstName, String lastName, Date registrationDate) {
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
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