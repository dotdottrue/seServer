package de.project.integration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.project.assembler.ProjectDTOAssembler;
import de.project.assembler.UserDTOAssembler;
import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.MilestoneTO;
import de.project.dto.ProjectResponse;
import de.project.dto.ProjectTO;
import de.project.dto.ReturncodeResponse;
import de.project.dto.UserTO;
import de.project.entities.Milestone;
import de.project.entities.Project;
import de.project.entities.User;
import de.project.exception.ProjectException;

@WebService
@WebContext(contextRoot = "/project")
@Stateless
public class ProjectIntegration {
	
	@EJB(beanInterface=de.project.dao.local.ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	@EJB(beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	@EJB
	private ProjectDTOAssembler projectassembler;

	private static final Logger LOGGER = Logger.getLogger(ProjectIntegration.class);

	
	public ReturncodeResponse createProject(String phoneNumber, ProjectTO project){
		//ReturncodeResponse response = new ReturncodeResponse(); 
		
		try{
			User user = userDAO.findUserByNumber(phoneNumber);
			Project newProject = new Project();
			
			List<User> users = new ArrayList<User>();
			List<UserTO> usersTO = new ArrayList<UserTO>();
			
			for(UserTO userto : usersTO){
				User u = new User();
				u.setPhoneNumber(userto.getPhoneNumber());
				u.setFirstName(userto.getFirstName());
				u.setLastName(userto.getLastName());
				users.add(u);
			}
			
			List<Milestone> milestones = new ArrayList<Milestone>();
			List<MilestoneTO> milestonesTO = new ArrayList<MilestoneTO>();
			
			for(MilestoneTO mileto : milestonesTO){
				Milestone m = new Milestone();
				m.setId(mileto.getId());
				m.setMilestoneName(mileto.getMilestoneName());
				m.setStatus(mileto.getStatus());			
			}
			
			newProject.setMembers(users);
			newProject.setOwner(user);
			newProject.setMilestones(milestones);
			newProject.setProjectName(project.getProjectName());
			newProject.setProjectStatus(project.getProjectStatus());
			newProject.setUpdatedOn(project.getUpdatedOn());
			
			projectDAO.createProject(newProject);
			
			LOGGER.info("Project wurde erfolgreich angelegt");
			
			
			
			}catch(Exception ex) {
				//response.setReturnCode(ex.getErrorCode());
				//response.setMessage(ex.getMessage());
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
