package de.project.assembler;

import javax.ejb.Singleton;

import de.project.dto.ProjectTO;
import de.project.dto.UserTO;
import de.project.entities.Project;
import de.project.entities.User;

@Singleton
public abstract class DtoAssembler {
	
	public UserTO makeDTO(User user){
		
		UserTO dto = new UserTO();
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setProjects(user.getProjects());
		dto.setRegistrationDate(user.getRegistrationDate());
		
		return dto;
	}
	
	public ProjectTO makeDTO(Project project){
		
		ProjectTO dto = new ProjectTO();
		dto.setId(project.getId());
		dto.setMembers(project.getMembers());
		dto.setMilestone(project.getMilestone());
		dto.setProjectStatus(project.getProjectStatus());
		dto.setUpdatedOn(project.getUpdatedOn());
		
		return dto;
	}

}
