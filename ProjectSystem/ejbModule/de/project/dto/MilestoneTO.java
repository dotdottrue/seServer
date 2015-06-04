package de.project.dto;

import javax.persistence.ManyToOne;

import de.project.entities.*;
import de.project.enumerations.*;

public class MilestoneTO {
	
	private static final long serialVersionUID = 1L;
	private long id;	
	private Project project;
	private Calendar createdAt;
	private MilestoneStatus status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	public MilestoneStatus getStatus() {
		return status;
	}
	public void setStatus(MilestoneStatus status) {
		this.status = status;
	}
	
	
}
