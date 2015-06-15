package de.project.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.DiscussionTO;
import de.project.dto.MilestoneTO;
import de.project.dto.NoteTO;
import de.project.dto.appointment.AppointmentTO;
import de.project.dto.project.ProjectTO;
import de.project.dto.user.UserTO;
import de.project.entities.Appointment;
import de.project.entities.Discussion;
import de.project.entities.Milestone;
import de.project.entities.Note;
import de.project.entities.Project;
import de.project.entities.User;

@Stateless
public class UserDTOAssembler {
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	public UserTO makeDTO(User user){
		
		UserTO dto = new UserTO();
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setRegistrationDate(user.getRegistrationDate());
		dto.setProjects(makeDTO(user.getProjects()));
		
		return dto;
	}
	
	private List<ProjectTO> makeDTO(List<Project> projects) {
		
		List<ProjectTO> dto = new ArrayList<>();
		
		for (Project project : projects) {
			ProjectTO projectTO = new ProjectTO();
			projectTO.setId(project.getId());
			projectTO.setOwner(userDtoAssembler.makeDTO(project.getOwner()));
			projectTO.setProjectName(project.getProjectName());
			projectTO.setDescription(project.getDescription());
			projectTO.setProjectStatus(project.getProjectStatus());
			projectTO.setUpdatedOn(project.getUpdatedOn());
			projectTO.setAppointments(makeDTO2(project.getAppointments()));
			projectTO.setDiscussions(makeDTO3(project.getDiscussions()));
			projectTO.setMembers(makeDTO5(project.getMembers()));
			projectTO.setMilestones(makeDTO4(project.getMilestones()));
			
			dto.add(projectTO);		
		}
		return dto;
	}
	
	private List<AppointmentTO> makeDTO2(List<Appointment> appointments) {
		
		List<AppointmentTO> dto = new ArrayList<>();

		for (Appointment appointment : appointments) {
			AppointmentTO appointmentTO = new AppointmentTO();
			appointmentTO.setId(appointment.getId());
			appointmentTO.setTopic(appointment.getTopic());
			appointmentTO.setAppointmentDate(appointment.getAppointmentDate());
			
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
	
	private List<MilestoneTO> makeDTO4(List<Milestone> milestones) {
		
		List<MilestoneTO> dto = new ArrayList<>();
		
		for (Milestone milestone : milestones) {
			MilestoneTO milestoneTO = new MilestoneTO();
			milestoneTO.setId(milestone.getId());
			milestoneTO.setMilestoneName(milestone.getMilestoneName());
			milestoneTO.setStatus(milestone.getStatus());
			milestoneTO.setCreatedAt(milestone.getCreatedAt());
			
			dto.add(milestoneTO);		
		}
		return dto;
	}
	
	private List<UserTO> makeDTO5(List<User> members) {
		
		List<UserTO> dto = new ArrayList<>();

		for (User user : members) {
			UserTO userTO = new UserTO();
			userTO.setPhoneNumber(user.getPhoneNumber());
			userTO.setFirstName(user.getFirstName());
			userTO.setLastName(user.getLastName());
			userTO.setProjects(makeDTO(user.getProjects()));
			userTO.setRegistrationDate(user.getRegistrationDate());
			
			dto.add(userTO);
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
