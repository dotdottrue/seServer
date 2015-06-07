package de.project.dto;

import java.io.Serializable;

public class NoteTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String userNote;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserNote() {
		return userNote;
	}
	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
