package de.project.integration;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.assembler.ProjectDTOAssembler;
import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ProjectResponse;
import de.project.dto.ProjectTO;
import de.project.dto.ReturncodeResponse;
import de.project.entities.Project;
import de.project.entities.User;

@Stateless
public class ProjectIntegration {
	
	@EJB(beanInterface=de.project.dao.local.ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	@EJB(beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;

	@EJB
	private ProjectDTOAssembler assembler;
	
	public ReturncodeResponse createProject(String phoneNumber, ProjectTO project){
		
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
	}
	
	public ProjectResponse getProjectsByPhoneNumber(String phoneNumber){
		
		User user = userDAO.findUserByNumber(phoneNumber);

		// Projekte finden und in DTOs wandeln
		List<Project> projects = projectDAO.findProjects(user);
		List<ProjectTO> projectsTO = new ArrayList<ProjectTO>();
		for(Project project : projects){
			projectsTO.add(assembler.makeDTO(project));
		}
		
		// Response Objekt erzeugen
		ProjectResponse response = new ProjectResponse();
		response.setPhonenumber(phoneNumber);
		response.setProjects(projectsTO);
		
		return response;
		
	}
	

}
