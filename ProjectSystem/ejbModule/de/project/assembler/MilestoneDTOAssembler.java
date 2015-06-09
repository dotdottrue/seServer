package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.MilestoneTO;

@Stateless
public class MilestoneDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	public MilestoneTO makeDTO(MilestoneTO milestone) {
		MilestoneTO dto = new MilestoneTO();
		dto.setId(milestone.getId());
		dto.setCreatedAt(milestone.getCreatedAt());
		dto.setProject(projectDtoAssembler.makeDTO(milestone.getProject()));
		dto.setMilestoneName(milestone.getMilestoneName());
		dto.setStatus(milestone.getStatus());
		
		return dto;
	}
}
