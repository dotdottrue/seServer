package de.project.integration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.project.assembler.ProjectDTOAssembler;
import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.MilestoneTO;
import de.project.dto.ReturncodeResponse;
import de.project.dto.project.ProjectResponse;
import de.project.dto.project.ProjectTO;
import de.project.dto.user.UserTO;
import de.project.entities.Milestone;
import de.project.entities.Project;
import de.project.entities.ProjectSession;
import de.project.entities.User;
import de.project.enumerations.ReturnCode;
import de.project.exception.ProjectValidationException;

@WebService
@WebContext(contextRoot = "/project")
@Stateless
public class ProjectIntegration {
	
	@EJB(beanName = "ProjectProjectDAO", beanInterface = ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	@EJB(beanName = "ProjectUserDAO", beanInterface = ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	@EJB
	private ProjectDTOAssembler projectassembler;

	private static final Logger LOGGER = Logger.getLogger(ProjectIntegration.class);

	
	public ReturncodeResponse createProject(String phoneNumber, ProjectTO project, int sessionId) {
		ReturncodeResponse response = new ReturncodeResponse(); 
		
		try{
			ProjectSession session = userDAO.getSession(sessionId);
			Project newProject = new Project();
			
			List<User> users = new ArrayList<User>();
			List<UserTO> usersTO = new ArrayList<UserTO>();
			
			for(UserTO userTO : usersTO) {
				User u = new User();
				u.setPhoneNumber(userTO.getPhoneNumber());
				u.setFirstName(userTO.getFirstName());
				u.setLastName(userTO.getLastName());
				users.add(u);
			}
			
			List<Milestone> milestones = new ArrayList<Milestone>();
			List<MilestoneTO> milestonesTO = new ArrayList<MilestoneTO>();
			
			for(MilestoneTO milestoneTO : milestonesTO) {
				Milestone m = new Milestone();
				m.setId(milestoneTO.getId());
				m.setMilestoneName(milestoneTO.getMilestoneName());
				m.setStatus(milestoneTO.getStatus());			
			}
			
			newProject.setMembers(users);
			newProject.setOwner(session.getUser());
			newProject.setMilestones(milestones);
			newProject.setProjectName(project.getProjectName());
			newProject.setProjectStatus(project.getProjectStatus());
			newProject.setUpdatedOn(project.getUpdatedOn());
			
			if(newProject.projectValidation()) {
				projectDAO.createProject(newProject);
				LOGGER.info("Project wurde erfolgreich angelegt");
			}else {
				LOGGER.info("Project wurde nicht angelegt da die Pflichtfelder nicht gefüllt waren.");
				throw new ProjectValidationException(ReturnCode.ERROR, "Es wurden nicht alle Pflichfelder gefüllt");
			}
			
			}catch(ProjectValidationException ex) {
				response.setReturnCode(ex.getErrorCode());
				response.setMessage(ex.getMessage());
			}
		return new ReturncodeResponse();
	}
	
	public ProjectResponse getProjectsByPhone(String phonenumber){
		
		try {
			
			User user = userDAO.findUserByNumber(phonenumber);
			List<Project> projects = projectDAO.findProjects(user);
			ProjectResponse response = new ProjectResponse();
			List<ProjectTO> projectsTO = new ArrayList<ProjectTO>();
			
			for(Project p : projects){
				projectsTO.add(projectassembler.makeDTO(p));
			}
					
			response.setProjects(projectsTO);
			response.setPhonenumber(phonenumber);
			
			return response;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	

}
