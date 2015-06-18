package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.appointment.AppointmentTO;
import de.project.entities.Appointment;

@Stateless
public class AppointmentDTOAssembler {
	
	public AppointmentTO makeDTO(Appointment appointment) {
		AppointmentTO dto = new AppointmentTO();
		dto.setId(appointment.getId());
		dto.setTopic(appointment.getTopic());
		dto.setAppointmentDate(appointment.getAppointmentDate().getTime());
		dto.setDescription(appointment.getDescription());
		
		return dto;
	}
	
}
