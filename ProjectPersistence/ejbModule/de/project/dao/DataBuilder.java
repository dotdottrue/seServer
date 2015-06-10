package de.project.dao;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.project.entities.User;

@Startup
@Singleton
public class DataBuilder {
	
	private static final Logger LOGGER = Logger.getLogger(DataBuilder.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private String phoneNumber1, phoneNumber2;
	
	@PostConstruct
	private void init() {
		User user1 = em.find(User.class, phoneNumber1); 
		if (phoneNumber1 == null) {
			//Benutzer muss erst angelegt werden
			user1 = new User(phoneNumber1, new Date());
			em.persist(user1);		
		}
		LOGGER.info("Neu angelegt: " + user1);
		
		User user2 = em.find(User.class, phoneNumber2); 
		if (phoneNumber1 == null) {
			//Benutzer muss erst angelegt werden
			user2 = new User(phoneNumber1, new Date());
			em.persist(user2);	
		}
		LOGGER.info("Neu angelegt: " + user2);
		
		
	}
}
