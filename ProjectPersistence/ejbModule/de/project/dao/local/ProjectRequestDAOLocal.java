package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Request;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Local
public interface ProjectRequestDAOLocal {
	
	public void createRequest(Request request);
	
	public void deleteRequest(Request request);
	
	public Request getRequestById(long id);
	
}
