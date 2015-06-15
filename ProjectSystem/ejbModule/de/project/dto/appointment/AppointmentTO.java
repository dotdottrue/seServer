package de.project.dto.appointment;

import java.io.Serializable;
import java.util.Date;

public class AppointmentTO implements Serializable {

	private static final long serialVersionUID = 4225307722069711177L;
	
	private long id;
	private String topic;
	private Date appointmentDate;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
