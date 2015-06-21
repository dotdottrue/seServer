package de.project.integration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.project.assembler.ProjectSessionDTOAssembler;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ReturncodeResponse;
import de.project.dto.user.ProjectUserResponse;
import de.project.entities.ProjectSession;
import de.project.entities.User;
import de.project.enumerations.ReturnCode;
import de.project.exception.InvalidLoginException;
import de.project.exception.UserLogoutException;
import de.project.exception.UserRegistrationException;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 *Diese Klasse haelt die Schnittstellen/Methoden fuer die Userspezifischen UseCases bereit.
 *
 */
@WebService
@WebContext(contextRoot = "/project")
@Stateless
public class UserIntegration {
	
	private static final Logger LOGGER = Logger.getLogger(UserIntegration.class);
	
	/**
	 * Referenz auf die EJB wird via Dependency Injection erzeugt. Die EJB ist fuer Datenbankabfragen gedacht.
	 */
	@EJB(beanName= "ProjectUserDAO", beanInterface = ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	/**
	 * DataTransferObject wird via EJB erzeugt.
	 */
	@EJB
	private ProjectSessionDTOAssembler projectSessionDtoAssembler;
	
	/**
	 * Schnittstelle/Methode zum Registrieren von Benutzern.
	 * @param phonenumber Uebergabeparameter ist die telefonnummer womit der Anwender Registriert wird.
	 * @return Rueckgabe ist ein OK-Code bei erfolgreicher Registrierung ansosten ein ERROR-Code.
	 */
	public ProjectUserResponse registerUser(String phonenumber) {
		ProjectUserResponse response = new ProjectUserResponse();
		try {
			User user = this.userDAO.findUserByNumber(phonenumber);
			if(user == null && phonenumber.matches( "[0123456789]*")){
				user = this.userDAO.createUser(phonenumber);
				LOGGER.info("Benutzer " + user + " erfolgreich angelegt.");
				
				ProjectSession session = userDAO.createSession(user);
				LOGGER.info("Session mit dem Benutzer " + user + " wurde aufgebaut");
			
				response.setSession(projectSessionDtoAssembler.makeDTO(session));
			}else{
				LOGGER.info("Registrierung fehlgeschlagen. Benutzer existiert bereits:");
				
				throw new UserRegistrationException(ReturnCode.ERROR, "Der Benutzer Existiert bereits");
			}
		}catch(UserRegistrationException ex){
			response.setReturnCode(ex.getReturnCode());
			response.setMessage(ex.getMessage());
		}
			
		return response;
	}
	
	/**
	 * 
	 * Methode zum Einloggen in die APP.
	 * @param phonenumber Uebergabeparameter ist die Telefonnummer zum Einloggen.
	 * @return Rueckgabe ist ein OK-Code bei erfolgreicher Registrierung ansosten ein ERROR-Code. 
	 * Zusaetzlich wird eine Session uebergeben.
	 * 
	 */
	public ProjectUserResponse login(String phonenumber){
		
		ProjectUserResponse response = new ProjectUserResponse();
		try {
			User user = userDAO.findUserByNumber(phonenumber);
			if(user != null){
				ProjectSession session = userDAO.createSession(user);
				LOGGER.info("Benutzer wurde erfolgreich eingeloggt. Die Session lautet: "+ session);
				
				response.setSession(projectSessionDtoAssembler.makeDTO(session));
			}else{
				LOGGER.info("Login fehlgeschlagen. Benutzer existiert noch nicht.");
				throw new InvalidLoginException(ReturnCode.ERROR, "Die Nummer bzw. der Benutzer existiert noch nicht!");
			}
		}catch(InvalidLoginException ex){
			response.setReturnCode(ex.getReturnCode());
			response.setMessage(ex.getMessage());
		}
			
		return response;
	}
	
	/**
	 * Schnittstelle/Abmeldung aus der App.
	 * @param sessionId Uebergabe der SessionId um sich aus der App abzumelden.
	 * @return Rueckgabe ist ein OK-Code bei erfolgreicher Registrierung ansosten ein ERROR-Code.
	 */
	public ReturncodeResponse logout(int sessionId){
		
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			boolean userSession = userDAO.endSession(sessionId);
			if(userSession){
				LOGGER.info("Benutzer wurde erfolgreich ausgeloggt.");
			}else{
				LOGGER.info("logout fehlgeschlagen. Benutzer wurde nicht ausgeloggt.");
				throw new UserLogoutException(ReturnCode.ERROR, "Es existiert keine aktive Session mit der SessionId: " + sessionId + ".");
			}
		}catch(UserLogoutException ex){
			response.setReturnCode(ex.getReturnCode());
			response.setMessage(ex.getMessage());
		}
			
		return response;
	}
}
