package de.project.dao.local;

import java.util.List;

import javax.ejb.Local;

import de.project.entities.Project;
import de.project.entities.User;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * Interface f�r die Project-Datenbankzugriffe. Die Local-Annotation macht dieses Interface f�r lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectProjectDAOLocal {
	
	public void updateProject(Project project);
	
	public List<Project> findProjects(User currentUser);
	
	public Project findProjectById(long projectId);
	
	public void cancelProject(Project projet);

	public Project createProject(Project project);
	
}
