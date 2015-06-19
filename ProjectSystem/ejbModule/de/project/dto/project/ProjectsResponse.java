package de.project.dto.project;

import java.util.List;

import de.project.dto.ReturncodeResponse;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Diese Klasse sorgt dafuer, dass Projekte versendet werden kann mit zusaetzlichem StatusCode.
 *
 */
public class ProjectsResponse extends ReturncodeResponse{

	private static final long serialVersionUID = 8173234950970923486L;
	
	private String phonenumber;
	private List<ProjectTO> projects;
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<ProjectTO> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectTO> projects) {
		this.projects = projects;
	}
	
}
