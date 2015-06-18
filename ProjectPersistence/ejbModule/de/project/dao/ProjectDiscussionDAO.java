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
 */
@Stateless
public class ProjectDiscussionDAO implements ProjectDiscussionDAOLocal {

	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Suchen einer Diskussion in der Datenbank und RŸckgabe dieser Diskussion.
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
	

}
