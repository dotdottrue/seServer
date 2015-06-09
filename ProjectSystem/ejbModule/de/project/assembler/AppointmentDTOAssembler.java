package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.AppointmentTO;
import de.project.entities.Appointment;

@Stateless
public class AppointmentDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	public AppointmentTO makeDTO(Appointment appointment) {
		AppointmentTO dto = new AppointmentTO();
		dto.setId(appointment.getId());
		dto.setAppointmentDate(appointment.getAppointmentDate());
		dto.setProject(projectDtoAssembler.makeDTO(appointment.getProject()));
		dto.setShortNote(appointment.getShortNote());
		dto.setTopic(appointment.getTopic());
		dto.setUsers(appointment.getUsers());
		
		return dto;
	}

}
