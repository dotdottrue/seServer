package de.project.dto;

import java.io.Serializable;
import java.util.Date;

import de.project.enumerations.RequestStatus;

public class RequestTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private UserTO sourceUser;
	private UserTO targetUser;
	private ProjectTO project;
	private String note;
	private Date updatedAt;
	private RequestStatus status;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public UserTO getSourceUser() {
		return sourceUser;
	}
	
	public void setSourceUser(UserTO sourceUser) {
		this.sourceUser = sourceUser;
	}
	
	public UserTO getTargetUser() {
		return targetUser;
	}
	
	public void setTargetUser(UserTO targetUser) {
		this.targetUser = targetUser;
	}
	
	public ProjectTO getProject() {
		return project;
	}
	
	public void setProject(ProjectTO project) {
		this.project = project;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date date) {
		this.updatedAt = date;
	}
	
	public RequestStatus getStatus() {
		return status;
	}
	
	public void setStatus(RequestStatus status) {
		this.status = status;
	}	
}
