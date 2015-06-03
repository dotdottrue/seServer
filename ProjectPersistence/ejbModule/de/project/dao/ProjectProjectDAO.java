package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.entities.Project;

@Stateless
public class ProjectProjectDAO {

		@PersistenceContext
		private EntityManager em;
		
		@Override
		public Project getProject(long projectId){
			return em.find(Project.class, projectId);
		}
}