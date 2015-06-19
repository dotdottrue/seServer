package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectMilestoneDAOLocal;
import de.project.entities.Milestone;
import de.project.enumerations.MilestoneStatus;

/**
 * 
 * @author Tobias Kappert
 *
 */
@Stateless
public class ProjectMilestoneDAO implements ProjectMilestoneDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Erstellen eines Meilensteines und abspeichern in der Datenbank.
	 */
	@Override
	public void createMilestone(Milestone milestone) {
		em.persist(milestone);
	}
	
	/**
	 * Finden von Meilensteinen anhand einer MeilensteinId in der Daenbank.
	 */
	@Override
	public Milestone findMilestone(long milestoneId) {
		return em.find(Milestone.class, milestoneId);
	}
	
	/**
	 * Aktualisieren eines Meilensteinstatuses zu Erledigt.
	 */
	@Override
	public void finishMilestoneStatus(Milestone milestone) {
		milestone.setStatus(MilestoneStatus.DONE);
		em.merge(milestone);
	}
	
	/**
	 * Aktualisieren eines Meilensteinstatuses zu verzšgert.
	 */
	@Override
	public void delayMilestone(Milestone milestone) {
		milestone.setStatus(MilestoneStatus.DELAYED);
		em.merge(milestone);
	}
	
	/**
	 * Aktualisieren eines Meilensteinstatuses zu in Arbeit.
	 */
	@Override
	public void inProgressMilestone(Milestone milestone) {
		milestone.setStatus(MilestoneStatus.INPROGRESS);
		em.merge(milestone);
	}

}
