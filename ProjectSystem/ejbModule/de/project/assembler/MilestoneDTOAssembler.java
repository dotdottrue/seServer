package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.MilestoneTO;
import de.project.entities.Milestone;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * Dieser Assembler baut aus einem Meilenstein-Objekt ein DataTransferObject welches zum Datenaustausch gedacht ist.
 */
@Stateless
public class MilestoneDTOAssembler {
	
	public MilestoneTO makeDTO(Milestone milestone) {
		MilestoneTO dto = new MilestoneTO();
		dto.setId(milestone.getId());
		dto.setMilestoneName(milestone.getMilestoneName());
		dto.setCreatedAt(milestone.getCreatedAt());
		dto.setStatus(milestone.getStatus());

		return dto;
	}
}
