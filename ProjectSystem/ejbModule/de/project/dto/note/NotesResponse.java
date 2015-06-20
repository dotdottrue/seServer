package de.project.dto.note;

import java.util.List;

import de.project.dto.ReturncodeResponse;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * 
 * Diese Klasse sorgt dafuer, dass eine Notizen versendet werden koennen mit zusaetzlichem StatusCode.
 *
 */
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
