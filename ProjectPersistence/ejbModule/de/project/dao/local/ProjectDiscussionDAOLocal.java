package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Discussion;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface f�r die Dicussion-Datenbankzugriffe. @Local macht dieses Interface f�r lokale Zugriffe erreichbar.
 *
 */
@Local
public interface ProjectDiscussionDAOLocal {

	public Discussion getDiscussionById(long id);
	
	public void updateDiscussion(Discussion discussion);
	
	public void removeDiscussion(Discussion discussion);
}
