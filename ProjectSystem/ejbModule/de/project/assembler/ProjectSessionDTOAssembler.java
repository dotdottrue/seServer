package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.ProjectSessionTO;
import de.project.entities.ProjectSession;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Stateless
public class ProjectSessionDTOAssembler {
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	public ProjectSessionTO makeDTO(ProjectSession projectSession) {
		ProjectSessionTO dto = new ProjectSessionTO();
		dto.setId(projectSession.getId());
		dto.setUser(userDtoAssembler.makeDTO(projectSession.getUser()));
		dto.setCreatedAt(projectSession.getCreatedAt());
		
		return dto;
	}
}
