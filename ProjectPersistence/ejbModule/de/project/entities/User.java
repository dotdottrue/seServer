package de.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue
	private String phoneNumber;
	private String firstName;
	private String lastName;

	private Date registrationDate;
	
	@ManyToMany
	private List<Project> projects;
	
	@ManyToMany
	private List<Discussion> discussions;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	private List<Note> Notes;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String phoneNumber, Date registrationDate) {
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
	
	
	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public List<Note> getNotes() {
		return Notes;
	}

	public void setNotes(List<Note> notes) {
		Notes = notes;
	}

	@Override
	public String toString() {
		return "Die Telefonnummer lautet: " + phoneNumber;
	}

}