/*package de.project.integration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ProjectTO;
import de.project.dto.ReturncodeResponse;
import de.project.entities.Project;
import de.project.entities.User;
import de.project.exception.ProjectException;

@WebService
@WebContext(contextRoot = "/project")
@Stateless
public class ProjectIntegration {
	
	@EJB(beanName="ProjectProjectDAO", beanInterface=de.project.dao.local.ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	@EJB(beanName="ProjectUserDAO", beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;

	private static final Logger LOGGER = Logger.getLogger(ProjectIntegration.class);

	
	public ReturncodeResponse createProject(String phoneNumber, ProjectTO project){
		ReturncodeResponse response = new ReturncodeResponse(); 
		
		try {
			User user = userDAO.findUserByNumber(phoneNumber);
			Project newProject = new Project();
			newProject.setMembers(project.getMembers());
			newProject.setOwner(user);
			newProject.setMilestones(project.getMilestones());
			newProject.setProjectName(project.getProjectName());
			newProject.setProjectStatus(project.getProjectStatus());
			newProject.setUpdatedOn(project.getUpdatedOn());
			
			projectDAO.createProject(newProject);
			
			return new ReturncodeResponse();
			LOGGER.info("Project wurde erfolgreich angelegt");
		}catch(ProjectException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
		
	}
	

}
*/