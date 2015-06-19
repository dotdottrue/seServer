package de.project.assembler;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.user.UserTO;

import de.project.entities.User;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * Dieser Assembler baut aus einem User-Objekt ein DataTransferObject welches zum Datenaustausch gedacht ist.
 */
@Stateless
public class UserDTOAssembler {
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	public UserTO makeDTO(User user){
		
		UserTO dto = new UserTO();
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setRegistrationDate(user.getRegistrationDate());
		
		return dto;
	}
}