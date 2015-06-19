package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectRequestDAOLocal;
import de.project.entities.Request;

/**
 * 
 * @author Tobias Kappert
 *
 */
@Stateless
public class ProjectRequestDAO implements ProjectRequestDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Speichern einer Request in der Datenbank.
	 */
	@Override
	public void createRequest(Request request) {
		em.persist(request);
	}
	
	/**
	 * Lšschen eines Requests aus der Datenbank.
	 */
	@Override
	public void deleteRequest(Request request) {
		em.remove(request);
		
	}
	
	/**
	 * Finden eines Requestes anhand der ID.
	 */
	@Override
	public Request getRequestById(long id) {
		return em.find(Request.class, id);		
	}

}
