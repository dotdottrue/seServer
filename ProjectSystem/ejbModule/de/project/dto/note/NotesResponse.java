package de.project.dto.note;

import java.util.List;

import de.project.dto.ReturncodeResponse;

public class NotesResponse extends ReturncodeResponse {

	private static final long serialVersionUID = 2385393882387556600L;
	
	private List<NoteTO> notes;

	public List<NoteTO> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteTO> notes) {
		this.notes = notes;
	}
	
}
