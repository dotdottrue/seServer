package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.RequestTO;
import de.project.entities.Request;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Stateless
public class RequestDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	public RequestTO makeDTO(Request request) {
		RequestTO dto = new RequestTO();
		dto.setId(request.getId());
		dto.setNote(request.getNote());
		dto.setProject(projectDtoAssembler.makeDTO(request.getProject()));
		dto.setSourceUser(userDtoAssembler.makeDTO(request.getSourceUser()));
		dto.setStatus(request.getStatus());
		dto.setTargetUser(userDtoAssembler.makeDTO(request.getTargetUser()));
		dto.setUpdatedAt(request.getUpdatedAt());
		
		return dto;
	}
}
