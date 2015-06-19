package de.project.dto.appointment;

import java.io.Serializable;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Aufbau des AppointmentTransferObjects.
 *
 */
public class AppointmentTO implements Serializable {

	private static final long serialVersionUID = 4225307722069711177L;
	
	private long id;
	private String topic;
	private String description;
	private long appointmentDate;
	
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
	
	public long getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(long appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
