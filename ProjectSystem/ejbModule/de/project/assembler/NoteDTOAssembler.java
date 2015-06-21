package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.note.NoteTO;
import de.project.entities.Note;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *Dieser Assembler baut aus einem Note-Objekt ein DataTransferObject welches zum Datenaustausch gedacht ist.
 */
@Stateless
public class NoteDTOAssembler {
	
	/**
	 * Methode zum Umwandeln des objektes.
	 * @param note = Objekt vom Typ Note.
	 * @return = Rueckgabe des DataTransferObjects.
	 */
	public NoteTO makeDTO(Note note) {
		NoteTO dto = new NoteTO();
		dto.setId(note.getId());
		dto.setNote(note.getNote());
		dto.setCreatedAt(note.getCreatedAt());
		dto.setUser(note.getUser());
		
		return dto;
	}

}
