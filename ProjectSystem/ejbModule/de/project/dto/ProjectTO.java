package de.project.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import de.project.entities.*;
import de.project.enumerations.*;


public class ProjectTO implements Serializable{		
	private static final long serialVersionUID = 1L;
		private long id;
		private ProjectStatus projectStatus;
		private List<User> members;
		private List<Milestone> milestone;
		private Calendar updatedOn;
	
		public String toString() {
			return "Project [id=" + id + ", projectStatus=" + projectStatus
					+ ", member=" + members + "]";
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

		public List<Milestone> getMilestone() {
			return milestone;
		}

		public void setMilestone(List<Milestone> milestone) {
			this.milestone = milestone;
		}

		public Calendar getUpdatedOn() {
			return updatedOn;
		}

		public void setUpdatedOn(Calendar updatedOn) {
			this.updatedOn = updatedOn;
		}
		
		
		
}
	
	
