package de.project.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.DiscussionTO;
import de.project.dto.NoteTO;
import de.project.entities.Discussion;
import de.project.entities.Note;

@Stateless
public class DiscussionDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	@EJB
	private DiscussionDTOAssembler discussionDtoAssembler;
	
	@EJB
	private AppointmentDTOAssembler appointmentDtoAssembler;
	
	public DiscussionTO makeDTO(Discussion discussion){	
		DiscussionTO dto = new DiscussionTO();
		dto.setId(discussion.getId());
		dto.setTopic(discussion.getTopic());
		dto.setCreatedAt(discussion.getCreatedAt());
		dto.setTopic(discussion.getTopic());
		dto.setProject(projectDtoAssembler.makeDTO(discussion.getProject()));
		dto.setNotes(makeDTO(discussion.getNotes(), dto));
		
		return dto;
	}
	
	private List<NoteTO> makeDTO(List<Note> notes, DiscussionTO dto2) {

		List<NoteTO> dto = new ArrayList<>();

		for (Note note : notes) {
			NoteTO noteTO = new NoteTO();
			noteTO.setId(note.getId());
			noteTO.setNote(note.getNote());
			noteTO.setCreatedAt(note.getCreatedAt());
			noteTO.setUser(userDtoAssembler.makeDTO(note.getUser()));
			noteTO.setDiscussion(discussionDtoAssembler.makeDTO(note.getDiscussion()));
			noteTO.setAppointment(appointmentDtoAssembler.makeDTO(note.getAppointment()));
			
			dto.add(noteTO);
		}
		return dto;
	}
	
}
