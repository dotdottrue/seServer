package de.project.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.project.enumerations.RequestStatus;

@Entity
public class Request {
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private User sourceUser;
	private Project targetUser;
	
	@ManyToOne
	private Project project;
	
	
	private String note;
	private Calendar updatedAt;
	
	@Enumerated(EnumType.ORDINAL)
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

	public void setProject(Project project) {
		this.project = project;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Anfrage: " + id + "von " + sourceUser+ " an " + targetUser + " für das Projekt " + project;
	}
	
	
	
}