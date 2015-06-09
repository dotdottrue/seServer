package de.project.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.project.entities.Note;
import de.project.entities.User;

public class AppointmentTO implements Serializable {

	private static final long serialVersionUID = 4225307722069711177L;
	
	private long id;
	private ProjectTO project;
	private List<User> users;
	private Note shortNote;
	private String topic;
	private Date appointmentDate;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public ProjectTO getProject() {
		return project;
	}
	
	public void setProject(ProjectTO project) {
		this.project = project;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> list) {
		this.users = list;
	}
	
	public Note getShortNote() {
		return shortNote;
	}
	
	public void setShortNote(Note note) {
		this.shortNote = note;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
