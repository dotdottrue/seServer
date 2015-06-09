package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.NoteTO;
import de.project.entities.Note;

@Stateless
public class NoteDTOAssembler {
	
	@EJB
	private DiscussionDTOAssembler discussionDtoAssembler;

	@EJB
	private AppointmentDTOAssembler appointmentDtoAssembler;
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	public NoteTO makeDTO(Note note) {
		NoteTO dto = new NoteTO();
		dto.setId(note.getId());
		dto.setNote(note.getNote());
		dto.setDiscussion(discussionDtoAssembler.makeDTO(note.getDiscussion()));
		dto.setUser(userDtoAssembler.makeDTO(note.getUser()));
		dto.setCreatedAt(note.getCreatedAt());
		dto.setAppointment(appointmentDtoAssembler.makeDTO(note.getAppointment()));

		return dto;
	}

}
