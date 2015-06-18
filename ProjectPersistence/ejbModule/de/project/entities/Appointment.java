package de.project.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private long id;
		
	/*@OneToOne(mappedBy = "appointment")
	private Note shortNote;
	*/ 
	
	private String topic;
	private String description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
