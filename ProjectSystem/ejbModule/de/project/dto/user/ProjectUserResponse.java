package de.project.dto.user;

import de.project.dto.ProjectSessionTO;
import de.project.dto.ReturncodeResponse;

public class ProjectUserResponse extends ReturncodeResponse {

	private static final long serialVersionUID = -4701857755366908754L;
	
	private ProjectSessionTO session;

	public ProjectSessionTO getSession() {
		return session;
	}

	public void setSession(ProjectSessionTO session) {
		this.session = session;
	}
	
}
