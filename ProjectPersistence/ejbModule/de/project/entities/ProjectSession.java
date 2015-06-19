package de.project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Entity
public class ProjectSession {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private User user;
	private Date createdAt;
	
	public ProjectSession() {
		super();
		this.createdAt = new Date();
	}
	
	public ProjectSession(User user) {
		this.user = user;
		this.createdAt = new Date();
	}
	
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