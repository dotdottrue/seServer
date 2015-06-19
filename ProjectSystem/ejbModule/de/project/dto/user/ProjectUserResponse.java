package de.project.dto.user;

import de.project.dto.ProjectSessionTO;
import de.project.dto.ReturncodeResponse;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Diese Klasse sorgt dafuer, dass eine BenutzerSession versendet werden kann mit zusaetzlichem StatusCode.
 *
 */
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
