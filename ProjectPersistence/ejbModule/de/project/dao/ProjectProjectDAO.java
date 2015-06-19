package de.project.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.entities.Milestone;
import de.project.entities.Project;
import de.project.entities.User;
import de.project.enumerations.ProjectStatus;

/**
 * 
 * @author Tobias Kappert
 *
 */
@Stateless
public class ProjectProjectDAO implements ProjectProjectDAOLocal {

		@PersistenceContext
		private EntityManager em;
		
		/**
		 * Suchen eines Projektes anhand der ProjektID in der Datenbank.
		 */
		@Override
		public Project findProjectById(long projectId){
			return em.find(Project.class, projectId);
		}
		
		/**
		 * Speichern eines Projektes in der Datenbank.
		 */
		@Override
		public Project createProject(Project project) {
			project.setProjectStatus(ProjectStatus.INTIME);
			em.persist(project);
			
			return project;
		}
		
		/**
		 * Finden von Projekten wo der angefragte Benutzer entweder der Besitzer
		 * oder Projektmitglied ist.
		 */
		@Override
		public List<Project> findProjects(User currentUser) {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Project> cq = cb
				.createQuery(Project.class);
			Root<Project> locationQuery = cq.from(Project.class);
			cq.select(locationQuery);
			
			List<Project> projects = em.createQuery(cq).getResultList();
			List<Project> yourProjectList = new ArrayList<Project>(); 
			
			for (Project projectSearch : projects) {
				List<User> projectMember = projectSearch.getMembers();
				if (projectMember.contains(currentUser)) {
					yourProjectList.add(projectSearch);
				}
			}
				
			return yourProjectList;
		}
		
		/**
		 * €ndern des Projektstatuses auf Erledigt/Abgeschlossen.
		 */
		@Override
		public void cancelProject(Project project) {
			project.setProjectStatus(ProjectStatus.FINISHED);
			project.setUpdatedOn(new Date());
			em.persist(project);
		}
		
		/**
		 * Finden von Meilensteinen in einem Projekt. Suche in der Datenbank.
		 */
		@Override
		public List<Milestone> getMilestones(Project project) {
			List<Milestone> projectMilestones = project.getMilestones();
			return projectMilestones;
		}
		
		/**
		 * Speichern eines Aktualisierten zustandes eines Projektes.
		 */
		@Override
		public void updateProject(Project project) {
			project.setUpdatedOn(new Date());
			em.merge(project);		
		}

}