package de.project.dto.discussion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import de.project.dto.note.NoteTO;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Aufbau des DiscussionTransferObjects.
 *
 */
public class DiscussionTO implements Serializable{

	private static final long serialVersionUID = -7131993484423007681L;
	
	private long id;
	private List<NoteTO> notes;
	private String topic;
	private Date createdAt;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public List<NoteTO> getNotes() {
		return notes;
	}
	
	public void setNotes(List<NoteTO> notes) {
		this.notes = notes;
	}
	
	public String getTopic() {
		return topic;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
