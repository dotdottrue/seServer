package de.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.CascadeType;

import de.project.enumerations.ProjectStatus;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	private ProjectStatus projectStatus;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> members;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Milestone> milestones;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Discussion> discussions;
	
	@ManyToOne
	private User owner;
	
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

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Discussion> getDiscussions() {
		return discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	@Override
	public String toString() {
		return "Project: " + id + "von " + owner ;
	}
	
	public boolean projectValidation() {
		if((projectName != null) && (owner != null)) 
			return true;
		else
			return false;			
	}
	
}