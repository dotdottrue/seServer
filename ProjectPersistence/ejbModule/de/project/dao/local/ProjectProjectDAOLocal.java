package de.project.dao.local;

import java.util.List;

import javax.ejb.Local;

import de.project.entities.Milestone;
import de.project.entities.Project;
import de.project.entities.User;

@Local
public interface ProjectProjectDAOLocal {

	public Project findProjectById(long id);
	
	public void updateProject(Project project);
	
	public List<Project> findProjects(User currentUser);
	
	public Project getProject(long projectId);
	
	public void cancelProject(Project projet);
	
    public List<Milestone> getMilestones(Project project);

	public Project createProject(Project project);
	
}
