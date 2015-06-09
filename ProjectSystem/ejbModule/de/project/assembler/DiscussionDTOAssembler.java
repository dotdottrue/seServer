package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.DiscussionTO;

@Stateless
public class DiscussionDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	public DiscussionTO makeDTO(DiscussionTO discussion){	
		DiscussionTO dto = new DiscussionTO();
		dto.setId(discussion.getId());
		dto.setTopic(discussion.getTopic());
		dto.setCreatedAt(discussion.getCreatedAt());
		dto.setTopic(discussion.getTopic());
		dto.setProject(projectDtoAssembler.makeDTO(discussion.getProject()));
		dto.setNotes(discussion.getNotes());
		
		return dto;
	}
	
}
