package de.project.dto.project;

import java.io.Serializable;
import java.util.List;

public class ProjectResponse implements Serializable{
	
	private static final long serialVersionUID = -1385458680913542434L;
	
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
