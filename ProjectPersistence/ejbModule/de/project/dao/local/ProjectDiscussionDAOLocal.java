package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Discussion;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface fuer die Dicussion-Datenbankzugriffe. Die Local-Annotation macht dieses Interface fuer lokale Zugriffe erreichbar.
 *
 */
@Local
public interface ProjectDiscussionDAOLocal {

	public Discussion getDiscussionById(long id);
	
	public void updateDiscussion(Discussion discussion);
	
	public void removeDiscussion(Discussion discussion);
}
