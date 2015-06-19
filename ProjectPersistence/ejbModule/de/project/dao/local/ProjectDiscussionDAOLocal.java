package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Discussion;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Local
public interface ProjectDiscussionDAOLocal {

	public Discussion getDiscussionById(long id);
	
	public void updateDiscussion(Discussion discussion);
	
	public void removeDiscussion(Discussion discussion);
}
