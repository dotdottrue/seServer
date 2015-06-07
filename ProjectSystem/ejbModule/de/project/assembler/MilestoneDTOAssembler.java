package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.MilestoneTO;
import de.project.entities.Milestone;

@Stateless
public class MilestoneDTOAssembler {
	
	public MilestoneTO makeDTO(Milestone milestone) {
		MilestoneTO dto = new MilestoneTO();
		dto.setId(milestone.getId());
		dto.setCreatedAt(milestone.getCreatedAt());
		dto.setProject(milestone.getProject());
		dto.setStatus(milestone.getStatus());
		
		return dto;
	}
}
