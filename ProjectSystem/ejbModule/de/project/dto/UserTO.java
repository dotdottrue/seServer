package de.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.project.entities.Note;
import de.project.entities.Project;

public class UserTO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private Date registrationDate;
	private List<Project> projects;
	private List<Note> notes;
	
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
	
	public void setRegistrationDate(Date date) {
		this.registrationDate = date;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Note> getNotes() {
		return notes;
	}
	
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
