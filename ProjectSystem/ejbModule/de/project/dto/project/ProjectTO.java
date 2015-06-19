package de.project.dto.project;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.project.dto.MilestoneTO;
import de.project.dto.appointment.AppointmentTO;
import de.project.dto.discussion.DiscussionTO;
import de.project.dto.user.UserTO;
import de.project.enumerations.*;


public class ProjectTO implements Serializable{		
	
	private static final long serialVersionUID = 1L;

	private long id;
	private ProjectStatus projectStatus;
	private List<UserTO> members;
	private List<MilestoneTO> milestones;
	private List<AppointmentTO> appointments;
	private List<DiscussionTO> discussions;
	private UserTO owner;
	private Date updatedOn;
	private String projectName;
	private String description;
	
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
	
	public List<UserTO> getMembers() {
		return members;
	}
	
	public void setMembers(List<UserTO> members) {
		this.members = members;
	}
	
	public List<MilestoneTO> getMilestones() {
		return milestones;
	}
	
	public void setMilestones(List<MilestoneTO> milestones) {
		this.milestones = milestones;
	}
	
	public List<AppointmentTO> getAppointments() {
		return appointments;
	}
	
	public void setAppointments(List<AppointmentTO> appointments) {
		this.appointments = appointments;
	}
	
	public List<DiscussionTO> getDiscussions() {
		return discussions;
	}
	
	public void setDiscussions(List<DiscussionTO> discussions) {
		this.discussions = discussions;
	}
	
	public UserTO getOwner() {
		return owner;
	}
	
	public void setOwner(UserTO owner) {
		this.owner = owner;
	}
	
	public Date getUpdatedOn() {
		return updatedOn;
	}
	
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
			
}
	
	
