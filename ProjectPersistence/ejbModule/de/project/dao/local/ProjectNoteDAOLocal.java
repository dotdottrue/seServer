package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Note;

@Local
public interface ProjectNoteDAOLocal {
	
	public void createNote(Note note);
	
	public void editNote(long noteId, String newNote);
	
}
