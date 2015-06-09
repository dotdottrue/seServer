package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.AppointmentTO;

@Stateless
public class AppointmentDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler privateDtoAssembler;
	
	public AppointmentTO makeDTO(AppointmentTO appointment) {
		AppointmentTO dto = new AppointmentTO();
		dto.setId(appointment.getId());
		dto.setAppointmentDate(appointment.getAppointmentDate());
		dto.setProject(privateDtoAssembler.makeDTO(appointment.getProject()));
		dto.setShortNote(appointment.getShortNote());
		dto.setTopic(appointment.getTopic());
		dto.setUsers(appointment.getUsers());
		
		return dto;
	}

}
