package de.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserTO implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private Date registrationDate;
	private List<ProjectTO> projects;
	private List<DiscussionTO> discussions;
	private List<NoteTO> Notes;
	
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
	
	public List<ProjectTO> getProjects() {
		return projects;
	}
	
	public void setProjects(List<ProjectTO> projects) {
		this.projects = projects;
	}
	
	public List<DiscussionTO> getDiscussions() {
		return discussions;
	}
	
	public void setDiscussions(List<DiscussionTO> discussions) {
		this.discussions = discussions;
	}
	
	public List<NoteTO> getNotes() {
		return Notes;
	}
	
	public void setNotes(List<NoteTO> notes) {
		Notes = notes;
	}
	
	
}
