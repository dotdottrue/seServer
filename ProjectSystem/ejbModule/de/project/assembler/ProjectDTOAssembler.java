package de.project.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.appointment.AppointmentTO;
import de.project.dto.discussion.DiscussionTO;
import de.project.dto.note.NoteTO;
import de.project.dto.project.ProjectTO;
import de.project.dto.user.UserTO;
import de.project.entities.Appointment;
import de.project.entities.Discussion;
import de.project.entities.Note;
import de.project.entities.Project;
import de.project.entities.User;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 * Dieser Assembler baut aus einem Project-Objekt ein DataTransferObject welches zum Datenaustausch gedacht ist.
 */
@Stateless
public class ProjectDTOAssembler {
	
	/**
	 * EJB zum erzeugen des DataTransferObjects.
	 */
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	/**
	 * Methode zum Umwandeln des objektes.
	 * @param project Objekt vom Typ Project
	 * @return Das umgewandelte DataTransferObject.
	 */
	public ProjectTO makeDTO(Project project){
		
		ProjectTO dto = new ProjectTO();
		dto.setId(project.getId());
		dto.setOwner(userDtoAssembler.makeDTO(project.getOwner()));
		dto.setProjectName(project.getProjectName());
		dto.setDescription(project.getDescription());
		dto.setProjectStatus(project.getProjectStatus());
		dto.setUpdatedOn(project.getUpdatedOn());
		dto.setMembers(makeDTO(project.getMembers()));
		dto.setAppointments(makeDTO2(project.getAppointments()));
		dto.setDiscussions(makeDTO3(project.getDiscussions()));

		return dto;
	}
	
	private List<UserTO> makeDTO(List<User> members) {
		
		List<UserTO> dto = new ArrayList<>();

		for (User user : members) {
			UserTO userTO = new UserTO();
			userTO.setPhoneNumber(user.getPhoneNumber());
			userTO.setFirstName(user.getFirstName());
			userTO.setLastName(user.getLastName());
			userTO.setRegistrationDate(user.getRegistrationDate());
			
			dto.add(userTO);
		}
		return dto;
	}
	
	private List<AppointmentTO> makeDTO2(List<Appointment> appointments) {
		
		List<AppointmentTO> dto = new ArrayList<>();

		for (Appointment appointment : appointments) {
			AppointmentTO appointmentTO = new AppointmentTO();
			appointmentTO.setId(appointment.getId());
			appointmentTO.setTopic(appointment.getTopic());
			appointmentTO.setAppointmentDate(appointment.getAppointmentDate().getTime());
			
			dto.add(appointmentTO);
		}
		return dto;
	}
	
	private List<DiscussionTO> makeDTO3(List<Discussion> discussions) {
		
		List<DiscussionTO> dto = new ArrayList<>();

		for (Discussion discussion : discussions) {
			DiscussionTO discussionTO = new DiscussionTO();
			discussionTO.setId(discussion.getId());
			discussionTO.setTopic(discussion.getTopic());
			discussionTO.setNotes(makeDTO6(discussion.getNotes()));
			discussionTO.setCreatedAt(discussion.getCreatedAt());
			
			dto.add(discussionTO);
		}
		return dto;
	}
	
	
	private List<NoteTO> makeDTO6(List<Note> notes) {
		
		List<NoteTO> dto = new ArrayList<>();

		for (Note note : notes) {
			NoteTO noteTO = new NoteTO();
			noteTO.setId(note.getId());
			noteTO.setNote(note.getNote());
			noteTO.setCreatedAt(note.getCreatedAt());
			
			dto.add(noteTO);
		}
		return dto;
	}
}
