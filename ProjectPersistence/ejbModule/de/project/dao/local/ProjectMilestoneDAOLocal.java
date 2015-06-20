package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Milestone;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface f�r die Milestone-Datenbankzugriffe. @Local macht dieses Interface f�r lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectMilestoneDAOLocal {
	
	public void createMilestone(Milestone milestone);
	
	public Milestone findMilestone(long milestoneId);
	
	public void finishMilestoneStatus(Milestone milestone);
	
	public void delayMilestone(Milestone milestone);
	
	public void inProgressMilestone(Milestone milestone);
	
}
