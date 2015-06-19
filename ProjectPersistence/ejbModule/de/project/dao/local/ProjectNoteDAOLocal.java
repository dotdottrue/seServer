package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Note;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface f�r die Note-Datenbankzugriffe. @Local macht dieses Interface f�r lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectNoteDAOLocal {
	
	public void createNote(Note note);
	
	public void editNote(long noteId, String newNote);
	
}
