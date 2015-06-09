package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.NoteTO;

@Stateless
public class NoteDTOAssembler {
	
	@EJB
	private DiscussionDTOAssembler discussionDtoAssembler;

	@EJB
	private AppointmentDTOAssembler appointmentDtoAssembler;
	
	public NoteTO makeDTO(NoteTO note) {
		NoteTO dto = new NoteTO();
		dto.setId(note.getId());
		dto.setNote(note.getNote());
		dto.setDiscussion(discussionDtoAssembler.makeDTO(note.getDiscussion()));
		dto.setUser(note.getUser());
		dto.setCreatedAt(note.getCreatedAt());
		dto.setAppointment(appointmentDtoAssembler.makeDTO(note.getAppointment()));

		return dto;
	}

}
