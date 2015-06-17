package de.project.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.project.dao.local.ProjectUserDAOLocal;
import de.project.entities.ProjectSession;
import de.project.entities.User;

@Stateless
public class ProjectUserDAO implements ProjectUserDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findUserByNumber(String phoneNumber) {
		return em.find(User.class, phoneNumber);
	}
	
	@Override
    public User createUser(String phoneNumber) {
    	User user = new User(phoneNumber, new Date());
    	em.persist(user);
    	return user;
    }
	
	

	/*@Override
	public List<User> searchUsers(String phoneNumber) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);
		cq.select(user);
		cq.where(cb.like(user.<String> get("phoneNumber"), phoneNumber));
		return em.createQuery(cq).getResultList();
	}*/
    
    public ProjectSession createSession(User user) {
    	ProjectSession session = new ProjectSession(user);
    	em.persist(session);
    	return session;
    }
    
    @Override
    public boolean endSession(int sessionId) {
    	ProjectSession session = em.find(ProjectSession.class, sessionId);
    	if(session != null) {
    		em.remove(session);
    		return true;
    	}else {
	    	return false;
    	}
    }
    
    @Override
    public ProjectSession getSession(int sessionId) {
    	ProjectSession session = em.find(ProjectSession.class, sessionId);
    	return session;
    }

	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> results = query.getResultList();
		
		return results;
	}

}
