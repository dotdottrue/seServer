package de.project.dto.project;

import de.project.dto.ReturncodeResponse;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Diese Klasse sorgt dafuer, dass ein Projekt versendet werden kann mit zusaetzlichem StatusCode.
 *
 */
public class ProjectResponse extends ReturncodeResponse{
	
	private static final long serialVersionUID = -1385458680913542434L;
	
	private ProjectTO project;

	public ProjectTO getProject() {
		return project;
	}

	public void setProject(ProjectTO project) {
		this.project = project;
	}
	
}
