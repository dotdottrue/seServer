package de.project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import de.project.enumerations.MilestoneStatus;

@Entity
public class Milestone {

	@Id
	@GeneratedValue
	private long id;
	
	private Date createdAt;
	private String milestoneName;

	@Enumerated(EnumType.ORDINAL)
	private MilestoneStatus status;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public MilestoneStatus getStatus() {
		return status;
	}

	public void setStatus(MilestoneStatus status) {
		this.status = status;
	}
	
	public String getMilestoneName() {
		return milestoneName;
	}

	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	
}