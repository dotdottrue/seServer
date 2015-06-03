package de.project.entities;

import java.util.Calendar;
import java.util.List;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import de.project.enumerations.ProjectStatus;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	public long id;
	
	@Enumerated(EnumType.ORDINAL)
	private ProjectStatus projectStatus;
	
	@ManyToMany
	//@JoinColumn(name = "member_id")
	private HashSet<User> members;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "project")
	private List<Milestone> milestone;
	
	private Calendar updatedOn;
	
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

	public HashSet<User> getMembers() {
		return members;
	}

	public void setMembers(HashSet<User> members) {
		this.members = members;
	}

	public List<Milestone> getMilestone() {
		return milestone;
	}

	public void setMilestone(List<Milestone> milestone) {
		this.milestone = milestone;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectStatus=" + projectStatus
				+ ", member=" + members + "]";
	}

	public Calendar getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Calendar updatedOn) {
		this.updatedOn = updatedOn;
	}	
	
}