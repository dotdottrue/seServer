package de.project.dao.local;

import java.util.List;

import javax.ejb.Local;

import de.project.entities.Milestone;
import de.project.entities.Project;

@Local
public interface ProjectProjectDAOLocal {

	public Project findProjectById(long id);
	
	public Project createProject(String projectName);
	
	public List<Project> findProjects(String searchString);
	
	public Project getProject(long projectId);
	
	public Project cancelProject(long ProjectId);
	
    public Milestone  getMilestones(int milestoneId);
	
}
