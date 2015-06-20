package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectAppointmentDAOLocal;
import de.project.entities.Appointment;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 * @Stateless macht aus diesem DataTransferObject welches für Datenbankzugriffe zustaendig ist eine zustandslose Session.
 *
 */
@Stateless
public class ProjectAppointmentDAO implements ProjectAppointmentDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Finden der Termine in der Datenbank.
	 */
	@Override
	public Appointment findAppointmentById(long id) {
		return em.find(Appointment.class, id);
	}
	
	/**
	 * Aktualisieren der Termine in der Datenbank.
	 */
	@Override
	public void updateAppointment(Appointment appointment) {
		em.merge(appointment);
	}
	
	/**
	 * Entfernen eines Termines aus der Datenbank
	 */
	@Override
	public void removeAppointment(Appointment appointment) {
		em.remove(appointment);
	}

}
