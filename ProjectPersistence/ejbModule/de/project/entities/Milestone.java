package de.project.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.project.enumerations.MilestoneStatus;

@Entity
public class Milestone {
	
	@Id
	@GeneratedValue
	private long id;	
	
	@ManyToOne//oder doch ManyToMany
	private Project project;
	
	private Calendar createdAt;
	
	@Enumerated(EnumType.ORDINAL)
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