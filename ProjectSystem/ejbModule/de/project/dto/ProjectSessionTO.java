package de.project.dto;

import java.io.Serializable;
import java.util.Calendar;

import de.project.entities.User;


public class ProjectSessionTO implements Serializable{

	
	private static final long serialVersionUID = 1L;	
	private int id;
	private User user;
	private Calendar createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	
}
