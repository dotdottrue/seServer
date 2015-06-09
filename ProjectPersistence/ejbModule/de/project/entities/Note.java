package de.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Note {
	
	@Id
	@GeneratedValue
	private long id;
	private String note;
	private String createdAt;
	
	@ManyToOne
	@JoinColumn(name = "discussion_id") 
	private Discussion discussion;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private Appointment appointment;
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String userNote) {
		this.note = userNote;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}	

}
