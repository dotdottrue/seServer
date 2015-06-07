package de.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectMilestoneDAOLocal;
import de.project.entities.Milestone;
import de.project.enumerations.MilestoneStatus;

public class ProjectMilestoneDAO implements ProjectMilestoneDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createMilestone(Milestone milestone) {
		em.persist(milestone);
	}

	@Override
	public Milestone findMilestone(long milestoneId) {
		return em.find(Milestone.class, milestoneId);
	}

	@Override
	public void finishMilestoneStatus(Milestone milestone) {
		milestone.setStatus(MilestoneStatus.DONE);
		em.persist(milestone);
	}

	@Override
	public void delayMilestone(Milestone milestone) {
		milestone.setStatus(MilestoneStatus.DELAYED);
	}

	@Override
	public void inProgressMilestone(Milestone milestone) {
		milestone.setStatus(MilestoneStatus.INPROGRESS);
	}

}
