package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Discussion;

@Local
public interface ProjectDiscussionDAOLocal {

	public Discussion getDisccusionById(long id);
	
	public void updateDiscussion(Discussion discussion);
}
