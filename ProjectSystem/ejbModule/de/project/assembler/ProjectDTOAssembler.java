package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.ProjectTO;

@Stateless
public class ProjectDTOAssembler {
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	public ProjectTO makeDTO(ProjectTO project){
		
		ProjectTO dto = new ProjectTO();
		dto.setId(project.getId());
		dto.setMembers(project.getMembers());
		dto.setMilestone(project.getMilestones());
		dto.setProjectStatus(project.getProjectStatus());
		dto.setUpdatedOn(project.getUpdatedOn());
		
		return dto;
	}
}
