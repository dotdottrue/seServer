package de.project.dto;

import java.io.Serializable;

import de.project.entities.User;

public class NoteTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String note;
	private User user;
	private String createdAt;
	private DiscussionTO discussion;
	private AppointmentTO appointment;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DiscussionTO getDiscussion() {
		return discussion;
	}

	public void setDiscussion(DiscussionTO discussionTO) {
		this.discussion = discussionTO;
	}

	public AppointmentTO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentTO appointment) {
		this.appointment = appointment;
	}
	
}
