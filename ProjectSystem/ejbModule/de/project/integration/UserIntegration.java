package de.project.integration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.ws.api.annotation.WebContext;

import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ReturncodeResponse;
import de.project.entities.User;

@WebService
@WebContext(contextRoot = "/user")
@Stateless
public class UserIntegration {
	
	@EJB(beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	public ReturncodeResponse registerUser(String phonenumber){
		
		ReturncodeResponse response = new ReturncodeResponse();
		
		User user = userDAO.findUserByNumber(phonenumber);
		if(user == null){
			userDAO.createUser(phonenumber);
			response.setMessage("New user created!");
		}else{
			response.setMessage("User already exists!");
		}
			
		return response;
	}
}
