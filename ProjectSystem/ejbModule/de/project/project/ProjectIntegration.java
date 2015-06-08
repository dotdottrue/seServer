package de.project.project;

import javax.ejb.EJB;

import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ProjectTO;
import de.project.dto.ReturncodeResponse;
import de.project.entities.Project;
import de.project.entities.User;

public class ProjectIntegration {
	
	@EJB(beanName="ProjectProjectDAO", beanInterface=de.project.dao.local.ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	@EJB(beanName="ProjectUserDAO", beanInterface=de.project.dao.local.ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;

	
	public ReturncodeResponse createProject(String phoneNumber, ProjectTO project){
		
		User user = userDAO.findUserByNumber(phoneNumber);
		Project newProject = new Project();
		newProject.setId(project.getId());
		newProject.setMembers(project.getMembers());
		newProject.setOwner(user);
		newProject.setMilestones(project.getMilestone());
		newProject.setProjectName(project.getProjectName());
		newProject.setProjectStatus(project.getProjectStatus());
		newProject.setUpdatedOn(project.getUpdatedOn());
		
		projectDAO.createProject(newProject, newProject.getProjectName(), newProject.getMembers());
		
		return new ReturncodeResponse();
		
		
	}
	

}
