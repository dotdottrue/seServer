package de.project.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.project.dto.DiscussionTO;
import de.project.dto.NoteTO;
import de.project.entities.Discussion;
import de.project.entities.Note;

@Stateless
public class DiscussionDTOAssembler {
	
	public DiscussionTO makeDTO(Discussion discussion){	
		DiscussionTO dto = new DiscussionTO();
		dto.setId(discussion.getId());
		dto.setTopic(discussion.getTopic());
		dto.setCreatedAt(discussion.getCreatedAt());
		dto.setNotes(makeDTO(discussion.getNotes(), dto));
		
		return dto;
	}
	
	private List<NoteTO> makeDTO(List<Note> notes, DiscussionTO discussionTO) {

		List<NoteTO> dto = new ArrayList<>();

		for (Note note : notes) {
			NoteTO noteTO = new NoteTO();
			noteTO.setId(note.getId());
			noteTO.setNote(note.getNote());
			noteTO.setCreatedAt(note.getCreatedAt());
			
			dto.add(noteTO);
		}
		return dto;
	}
	
}
