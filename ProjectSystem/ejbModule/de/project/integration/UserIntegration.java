package de.project.integration;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ReturncodeResponse;
import de.project.entities.User;

@Stateless
public class UserIntegration {
	
	@EJB(beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;

	public ReturncodeResponse login(String phoneNumber){
		User user = userDAO.findUserByNumber(phoneNumber);
		if(user == null){
			userDAO.createUser(phoneNumber);
		}
		return new ReturncodeResponse();
	}	
}
