package de.project.dao;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.project.entities.ProjectSession;
import de.project.entities.User;

@Stateless
public class ProjectUserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@override
	public User findUserByName(String user) {
		return em.find(User.class, user);
	}
	
	@Override
    public User createUser(String phoneNumber) {
    	User user = new User(phoneNumber, new GregorianCalendar());
    	em.persist(user);
    	return user;
    }

	@Override
	public List<User> searchUsers(String info) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);
		cq.select(user);
		cq.where(cb.like(user.<String> get("phoneNumber"), "%" + info + "%"));
		return em.createQuery(cq).getResultList();
	}
    
    public ProjectSession createSession(User user) {
    	ProjectSession session = new ProjectSession(user);
    	em.persist(session);
    	return session;
    }
    
    @Override
    public boolean closeSession(int sessionId) {
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
}