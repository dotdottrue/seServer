package de.project.dto.user;

import java.io.Serializable;
import java.util.List;

public class UsersResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4472875215477094371L;
	
	
	List<UserTO> users;


	public List<UserTO> getUsers() {
		return users;
	}


	public void setUsers(List<UserTO> users) {
		this.users = users;
	}
	
	
	
	

}
