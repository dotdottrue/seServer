package de.project.project;

import javax.ejb.EJB;

import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dto.ReturncodeResponse;

public class ProjectIntegration {
	
	@EJB(beanName="ProjectProjectDAO", beanInterface=de.project.dao.local.ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	

	
	public ReturncodeResponse createProject(int userID){
		
		
		return new ReturncodeResponse();
		
		
	}
	

}
