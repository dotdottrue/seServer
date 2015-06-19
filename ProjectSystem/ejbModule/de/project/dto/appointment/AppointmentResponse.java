package de.project.dto.appointment;

import java.util.List;

import de.project.dto.ReturncodeResponse;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Diese Klasse sorgt dafuer, dass ein Termin/Meilensteinobjekt versendet werden kann mit zusaetzlichem StatusCode.
 *
 */
public class AppointmentResponse extends ReturncodeResponse {


	private static final long serialVersionUID = -4823223693859736921L;
	
	List<AppointmentTO> appointments;

	public List<AppointmentTO> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentTO> appointments) {
		this.appointments = appointments;
	}
	
	

	
}
