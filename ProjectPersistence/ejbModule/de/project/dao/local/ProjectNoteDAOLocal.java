package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Note;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface für die Note-Datenbankzugriffe. Die Local-Annotation macht dieses Interface für lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectNoteDAOLocal {
	
	public void createNote(Note note);
	
	public void editNote(long noteId, String newNote);
	
}
