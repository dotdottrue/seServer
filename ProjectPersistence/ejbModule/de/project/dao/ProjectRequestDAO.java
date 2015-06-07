package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectRequestDAOLocal;
import de.project.entities.Request;

@Stateless
public class ProjectRequestDAO implements ProjectRequestDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createRequest(Request request) {
		em.persist(request);
	}

	@Override
	public void deleteRequest(Request request) {
		em.remove(request);
		
	}

	@Override
	public Request getRequestById(long id) {
		return em.find(Request.class, id);		
	}

}
