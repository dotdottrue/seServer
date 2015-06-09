package de.project.assembler;

import javax.ejb.Stateless;

import de.project.dto.UserTO;
import de.project.entities.User;

@Stateless
public abstract class UserDTOAssembler {
	
	public UserTO makeDTO(User user){
		
		UserTO dto = new UserTO();
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setProjects(user.getProjects());
		dto.setRegistrationDate(user.getRegistrationDate());
		dto.setNotes(user.getNotes());
		return dto;
	}

}
