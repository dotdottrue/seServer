package de.project.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.project.dto.discussion.DiscussionTO;
import de.project.dto.note.NoteTO;
import de.project.entities.Discussion;
import de.project.entities.Note;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * Dieser Assembler baut aus einem Discussion-Objekt ein DataTransferObject welches zum Datenaustausch gedacht ist.
 */
@Stateless
public class DiscussionDTOAssembler {
	
	/**
	 * Methode zum Umwandeln des objektes.
	 * @param discussion = Objekt vom Typ Discussion
	 * @return = Das umgewandelte DataTransferObject.
	 */
	public DiscussionTO makeDTO(Discussion discussion){	
		DiscussionTO dto = new DiscussionTO();
		dto.setId(discussion.getId());
		dto.setTopic(discussion.getTopic());
		dto.setCreatedAt(discussion.getCreatedAt());
		dto.setNotes(makeDTO(discussion.getNotes(), dto));
		
		return dto;
	}
	
	/**
	 * Erstellung der internen Listen dieses DTO's.
	 * @param notes = Object vom Typ Liste<Note>.
	 * @param discussionTO = Das DataTransferObject.
	 * @return Das Umgewandelte DataTransferObject.
	 */
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
