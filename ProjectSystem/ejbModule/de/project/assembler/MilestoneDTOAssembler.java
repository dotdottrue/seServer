package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.MilestoneTO;
import de.project.entities.Milestone;

@Stateless
public class MilestoneDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	public MilestoneTO makeDTO(Milestone milestone) {
		MilestoneTO dto = new MilestoneTO();
		dto.setId(milestone.getId());
		dto.setCreatedAt(milestone.getCreatedAt());
		dto.setProject(projectDtoAssembler.makeDTO(milestone.getProject()));
		dto.setMilestoneName(milestone.getMilestoneName());
		dto.setStatus(milestone.getStatus());
		
		return dto;
	}
}
