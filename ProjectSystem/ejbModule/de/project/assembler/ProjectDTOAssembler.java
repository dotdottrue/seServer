package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.ProjectTO;
import de.project.entities.Project;

@Stateless
public class ProjectDTOAssembler {
	
	public ProjectTO makeDTO(Project project){
		
		ProjectTO dto = new ProjectTO();
		dto.setId(project.getId());
		dto.setMembers(project.getMembers());
		dto.setMilestones(project.getMilestones());
		dto.setProjectStatus(project.getProjectStatus());
		dto.setUpdatedOn(project.getUpdatedOn());
		
		return dto;
	}
}
