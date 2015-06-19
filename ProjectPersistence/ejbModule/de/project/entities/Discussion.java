package de.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Entity
public class Discussion implements Serializable{

	private static final long serialVersionUID = -6256616602720915105L;

	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Note> notes;
	
	private String topic;
	private Date createdAt;

	public Discussion() {
		super();
	}

	public Discussion(String topic, Date createdAt) {
		this.topic = topic;
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Diskussion mit der ID: " + id + "wurde dem Projekt zugeordnet.";
	}
	
}
