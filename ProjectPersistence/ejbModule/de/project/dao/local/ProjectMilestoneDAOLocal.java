package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Milestone;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 */
@Local
public interface ProjectMilestoneDAOLocal {
	
	public void createMilestone(Milestone milestone);
	
	public Milestone findMilestone(long milestoneId);
	
	public void finishMilestoneStatus(Milestone milestone);
	
	public void delayMilestone(Milestone milestone);
	
	public void inProgressMilestone(Milestone milestone);
	
}
