package de.project.dto.note;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Aufbau eines NoteTransferObjects.
 *
 */
public class NoteTO implements Serializable{
	
	private static final long serialVersionUID = -4781277771288533285L;
	
	private long id;
	private String note;
	private Date createdAt;
	private String user;
	
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
