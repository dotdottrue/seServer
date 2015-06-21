package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.Appointment;

/**
 * 
 * @author Tobias Kappert
 *
 * Interface für die Appointment-Datenbankzugriffe. Die Local-Annotation macht dieses Interface für lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectAppointmentDAOLocal {
	
	public Appointment findAppointmentById(long id);
	
	public void updateAppointment(Appointment appointment);
	
	public void removeAppointment(Appointment appointment);
}
