package de.project.dto;

import java.io.Serializable;
import java.util.Date;

import de.project.enumerations.*;

public class MilestoneTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Date createdAt;
	private String milestoneName;
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
	
	public String getMilestoneName() {
		return milestoneName;
	}
	
	public void setMilestoneName(String milestoneName) {
		this.milestoneName = milestoneName;
	}
	
	public MilestoneStatus getStatus() {
		return status;
	}
	
	public void setStatus(MilestoneStatus status) {
		this.status = status;
	}
	
}
