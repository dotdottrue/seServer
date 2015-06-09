package de.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.project.entities.Note;

public class DiscussionTO implements Serializable{

	private static final long serialVersionUID = -7131993484423007681L;
	
	private long id;
	private List<UserTO> users;
	private ProjectTO project;
	private List<Note> notes;
	private String topic;
	private Date createdAt;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public List<UserTO> getUsers() {
		return users;
	}
	
	public void setUsers(List<UserTO> users) {
		this.users = users;
	}
	
	public ProjectTO getProject() {
		return project;
	}
	
	public void setProject(ProjectTO projectTO) {
		this.project = projectTO;
	}
	
	public List<Note> getNotes() {
		return notes;
	}
	
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
