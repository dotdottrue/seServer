package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.NoteTO;
import de.project.entities.Note;

@Stateless
public class NoteDTOAssembler {
	
	public NoteTO makeDTO(Note note) {
		NoteTO dto = new NoteTO();
		dto.setId(note.getId());
		dto.setNote(note.getNote());
		dto.setUser(note.getUser());
		dto.setCreatedAt(note.getCreatedAt());
		
		return dto;
	}
}
