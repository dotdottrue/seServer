package de.project.dto;

import java.io.Serializable;
import java.util.Date;

import de.project.dto.user.UserTO;

/**
 * @author Eduard Schartner
 * DTO-Objekt zur Übertragung und Nutzung auf dem Client
 */
public class ProjectSessionTO implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	private int id;
	private UserTO user;
	private Date createdAt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public UserTO getUser() {
		return user;
	}
	
	public void setUser(UserTO user) {
		this.user = user;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return String.valueOf(id);
	}
}
