package de.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.project.entities.Discussion;
import de.project.entities.Note;
import de.project.entities.Project;

public class UserTO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private Date registrationDate;
	private List<Project> projects;
	private List<Discussion> discussions;
	private List<Note> Notes;
	
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
	
	
}
