package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.RequestTO;
import de.project.entities.Request;

@Stateless
public class RequestDTOAssembler {
	
	public RequestTO makeDTO(Request request) {
		RequestTO dto = new RequestTO();
		dto.setId(request.getId());
		dto.setNote(request.getNote());
		dto.setProject(request.getProject());
		dto.setSourceUser(request.getSourceUser());
		dto.setStatus(request.getStatus());
		dto.setTargetUser(request.getTargetUser());
		dto.setUpdatedAt(request.getUpdatedAt());
		
		return dto;
	}
}
