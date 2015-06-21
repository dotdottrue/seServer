package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Discussion;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface für die Dicussion-Datenbankzugriffe. Die Local-Annotation macht dieses Interface für lokale Zugriffe erreichbar.
 *
 */
@Local
public interface ProjectDiscussionDAOLocal {

	public Discussion getDiscussionById(long id);
	
	public void updateDiscussion(Discussion discussion);
	
	public void removeDiscussion(Discussion discussion);
}
