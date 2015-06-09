package de.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Project project;
	
	@ManyToMany
	private List<User> users;
	
	@OneToOne(mappedBy = "appointment")
	private Note shortNote;
	
	private String topic;
	private Date appointmentDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Note getShortNote() {
		return shortNote;
	}
	public void setShortNote(Note shortNote) {
		this.shortNote = shortNote;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
}
