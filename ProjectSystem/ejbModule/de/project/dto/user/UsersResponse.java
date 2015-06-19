package de.project.dto.user;

import java.util.List;

import de.project.dto.ReturncodeResponse;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Diese Klasse sorgt dafuer, dass Benutzer versendet werden kann mit zusaetzlichem StatusCode.
 *
 */
public class UsersResponse extends ReturncodeResponse{

	private static final long serialVersionUID = -4472875215477094371L;	
	
	List<UserTO> users;

	public List<UserTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserTO> users) {
		this.users = users;
	}

}
