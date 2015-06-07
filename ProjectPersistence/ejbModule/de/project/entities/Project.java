package de.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import de.project.enumerations.ProjectStatus;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	private ProjectStatus projectStatus;
	
	@ManyToMany
	private List<User> members;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	private List<Milestone> milestones;
	
	private Date updatedOn;
	private String projectName;
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<Milestone> milestone) {
		this.milestones = milestone;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectStatus=" + projectStatus
				+ ", member=" + members + "]";
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}	
	
}