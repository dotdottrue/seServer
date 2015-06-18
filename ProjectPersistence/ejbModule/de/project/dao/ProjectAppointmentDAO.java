package de.project.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.project.dao.local.ProjectAppointmentDAOLocal;
import de.project.entities.Appointment;

@Stateless
public class ProjectAppointmentDAO implements ProjectAppointmentDAOLocal {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Appointment findAppointmentById(long id) {
		return em.find(Appointment.class, id);
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		em.merge(appointment);
	}

	@Override
	public void removeAppointment(Appointment appointment) {
		// TODO Auto-generated method stub

	}

}
