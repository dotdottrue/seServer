package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectNoteDAOLocal;
import de.project.entities.Note;

@Stateless
public class ProjectNoteDAO implements ProjectNoteDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createNote(Note note) {
		em.persist(note);
	}

	@Override
	public void editNote(long noteId, String newNote) {
		Note notice = em.find(Note.class, noteId);
		notice.setNote(newNote);
	}

}
