package de.project.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.project.enumerations.RequestStatus;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Entity
public class Request {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Project project;
	
	@Enumerated(EnumType.ORDINAL)
	private RequestStatus status;
	
	private User sourceUser;
	private User targetUser;
	private String note;
	private Date updatedAt;

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

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
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