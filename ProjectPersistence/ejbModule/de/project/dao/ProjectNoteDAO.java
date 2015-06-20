package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectNoteDAOLocal;
import de.project.entities.Note;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * @Stateless macht aus diesem DataTransferObject welches fuer Datenbankzugriffe zustaendig ist eine zustandslose Session.
 *
 */
@Stateless
public class ProjectNoteDAO implements ProjectNoteDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Erstellen und Speichern einer Notiz/eins Beitrages in der Datenbank.
	 */
	@Override
	public void createNote(Note note) {
		em.persist(note);
	}
	
	/**
	 * Aendern eines Beitrages.
	 */
	@Override
	public void editNote(long noteId, String newNote) {
		Note notice = em.find(Note.class, noteId);
		notice.setNote(newNote);
		em.merge(notice);
	}

}
