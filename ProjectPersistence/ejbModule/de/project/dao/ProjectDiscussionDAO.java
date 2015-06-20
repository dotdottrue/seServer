package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectDiscussionDAOLocal;
import de.project.entities.Discussion;

/**
 * 
 * @author Eduard Schartner
 * 
 * @Stateless macht aus diesem DataTransferObject welches fuer Datenbankzugriffe zustaendig ist eine zustandslose Session.
 *
 */
@Stateless
public class ProjectDiscussionDAO implements ProjectDiscussionDAOLocal {

	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Suchen einer Diskussion in der Datenbank und Rueckgabe dieser Diskussion.
	 */
	@Override
	public Discussion getDiscussionById(long id) {		
		Discussion discussion = em.find(Discussion.class, id);	
		return discussion;
	}
	
	/**
	 * Updaten einer Diskussion in der Datenbank.
	 */
	@Override
	public void updateDiscussion(Discussion discussion) {
		em.merge(discussion);
	}
	
	/**
	 * Loeschen der Diskussion aus der Datenbank
	 */
	@Override
	public void removeDiscussion(Discussion discussion) {
		em.remove(discussion);
	}
	

}
