package de.project.dto.appointment;

import java.io.Serializable;
import java.util.List;

import de.project.dto.ReturncodeResponse;

public class AppointmentResponse extends ReturncodeResponse implements Serializable {


	private static final long serialVersionUID = -4823223693859736921L;
	
	List<AppointmentTO> appointments;

	public List<AppointmentTO> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentTO> appointments) {
		this.appointments = appointments;
	}
	
	

	
}
