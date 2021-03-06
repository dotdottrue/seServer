package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Appointment;

/**
 * 
 * @author Tobias Kappert
 *
 * Interface f�r die Appointment-Datenbankzugriffe. @Local macht dieses Interface f�r lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectAppointmentDAOLocal {
	
	public Appointment findAppointmentById(long id);
	
	public void updateAppointment(Appointment appointment);
	
	public void removeAppointment(Appointment appointment);
}
