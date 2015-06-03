package de.project.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.entities.Milestone;
import de.project.entities.Project;

@Stateless
public class ProjectProjectDAO implements ProjectProjectDAOLocal {

		@PersistenceContext
		private EntityManager em;
		
		@Override
		public Project getProject(long projectId){
			return em.find(Project.class, projectId);
		}

		@Override
		public Project findProjectById(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Project createProject(String projectName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Project> findProjects(String searchString) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Project cancelProject(long ProjectId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Milestone getMilestones(int milestoneId) {
			// TODO Auto-generated method stub
			return null;
		}
}