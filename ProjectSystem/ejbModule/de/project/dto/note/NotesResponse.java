package de.project.dto.note;

import java.io.Serializable;
import java.util.List;

public class NotesResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<NoteTO> notes;

	public List<NoteTO> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteTO> notes) {
		this.notes = notes;
	}
	
	

}
