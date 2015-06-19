package de.project.dao.local;

import java.util.List;

import javax.ejb.Local;

import de.project.entities.Milestone;
import de.project.entities.Project;
import de.project.entities.User;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface für die Project-Datenbankzugriffe. @Local macht dieses Interface für lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectProjectDAOLocal {
	
	public void updateProject(Project project);
	
	public List<Project> findProjects(User currentUser);
	
	public Project findProjectById(long projectId);
	
	public void cancelProject(Project projet);
	
    public List<Milestone> getMilestones(Project project);

	public Project createProject(Project project);
	
}
