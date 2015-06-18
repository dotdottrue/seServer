package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Appointment;

/**
 * 
 * @author Tobias Kappert
 *
 */
@Local
public interface ProjectAppointmentDAOLocal {
	
	public Appointment findAppointmentById(long id);
	
	public void updateAppointment(Appointment appointment);
	
	public void removeAppointment(Appointment appointment);
}
