package de.project.integration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ReturncodeResponse;
import de.project.entities.ProjectSession;
import de.project.entities.User;

@WebService
@WebContext(contextRoot = "/user")
@Stateless
public class UserIntegration {
	
	private static final Logger LOGGER = Logger.getLogger(UserIntegration.class);
	
	@EJB(beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	public ReturncodeResponse registerUser(String phonenumber){
		
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			User user = userDAO.findUserByNumber(phonenumber);
			if(user == null){
				user = userDAO.createUser(phonenumber);
				LOGGER.info("Benutzer " + user+ " erfolgreich angelegt.");
				response.setMessage("New user created!");
			}else{
				response.setMessage("User already exists!");
				LOGGER.info("Registrierung fehlgeschlagen. Benutzer existiert bereits:");
			}
		}catch(Exception ex){
			//response.setReturnCode(ex.getErrorCode());
			//response.setMessage(ex.getMessage());
		}
			
		return response;
	}
	
	public ReturncodeResponse login(String phonenumber){
		
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			User user = userDAO.findUserByNumber(phonenumber);
			if(user != null){
				ProjectSession session = userDAO.createSession(user);
				LOGGER.info("Benutzer wurde erfolgreich eingeloggt. Die Session lautet: "+ session);
				response.setMessage("Login Erfolgreich!");
			}else{
				response.setMessage("Login fehlgeschlagen!");
				LOGGER.info("Login fehlgeschlagen. Benutzer existiert noch nicht.");
			}
		}catch(Exception ex){
			//response.setReturnCode(e.getErrorCode());
			//response.setMessage(ex.getMessage());
		}
			
		return response;
	}
}
