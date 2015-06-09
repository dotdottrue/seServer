package de.project.dto;

import java.io.Serializable;
import java.util.Date;

import de.project.entities.Project;
import de.project.entities.User;
import de.project.enumerations.RequestStatus;

public class RequestTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private User sourceUser;
	private Project targetUser;
	private Project project;
	private String note;
	private Date updatedAt;
	private RequestStatus status;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public User getSourceUser() {
		return sourceUser;
	}
	
	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}
	
	public Project getTargetUser() {
		return targetUser;
	}
	
	public void setTargetUser(Project targetUser) {
		this.targetUser = targetUser;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project2) {
		this.project = project2;
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
