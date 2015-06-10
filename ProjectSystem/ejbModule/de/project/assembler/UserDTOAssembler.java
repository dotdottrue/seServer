package de.project.assembler;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import de.project.dto.AppointmentTO;
import de.project.dto.DiscussionTO;
import de.project.dto.MilestoneTO;
import de.project.dto.NoteTO;
import de.project.dto.ProjectTO;
import de.project.dto.UserTO;
import de.project.entities.Appointment;
import de.project.entities.Discussion;
import de.project.entities.Milestone;
import de.project.entities.Note;
import de.project.entities.Project;
import de.project.entities.User;

@Stateless
public class UserDTOAssembler {
	
	@EJB
	private ProjectDTOAssembler projectDtoAssembler;
	
	@EJB
	private NoteDTOAssembler noteDtoAssembler;
	
	@EJB
	private UserDTOAssembler userDtoAssembler;
	
	@EJB
	private DiscussionDTOAssembler discussionDtoAssembler;
	
	@EJB
	private AppointmentDTOAssembler appointmentDtoAssembler;
	
	public UserTO makeDTO(User user){
		
		UserTO dto = new UserTO();
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setProjects(makeDTO(user.getProjects(), dto));
		dto.setRegistrationDate(user.getRegistrationDate());
		dto.setNotes(makeDTO1(user.getNotes(), dto));
		return dto;
	}
	
	private List<ProjectTO> makeDTO(List<Project> projects, UserTO dto2) {

		List<ProjectTO> dto = new ArrayList<>();

		for (Project project : projects) {
			ProjectTO projectTO = new ProjectTO();
			projectTO.setId(project.getId());
			projectTO.setOwner(userDtoAssembler.makeDTO(project.getOwner()));
			projectTO.setProjectName(project.getProjectName());
			projectTO.setProjectStatus(project.getProjectStatus());
			projectTO.setUpdatedOn(project.getUpdatedOn());
			projectTO.setAppointments(makeDTO10(project.getAppointments(), dto));
			projectTO.setDiscussions(makeDTO9(project.getDiscussions(), dto));
			projectTO.setMembers(makeDTO13(project.getMembers(), dto));
			projectTO.setMilestones(makeDTO12(project.getMilestones(), dto));
			
			dto.add(projectTO);
		}
		return dto;
	}
	
	private List<NoteTO> makeDTO1(List<Note> notes, UserTO dto2) {

		List<NoteTO> dto = new ArrayList<>();

		for (Note note : notes) {
			NoteTO noteTO = new NoteTO();
			noteTO.setId(note.getId());
			noteTO.setNote(note.getNote());
			noteTO.setCreatedAt(note.getCreatedAt());
			noteTO.setUser(userDtoAssembler.makeDTO(note.getUser()));
			noteTO.setDiscussion(discussionDtoAssembler.makeDTO(note.getDiscussion()));
			noteTO.setAppointment(appointmentDtoAssembler.makeDTO(note.getAppointment()));
			
			dto.add(noteTO);
		}
		return dto;
	}
	
	private List<DiscussionTO> makeDTO2(List<Discussion> discussions, List<UserTO> dto2) {

		List<DiscussionTO> dto = new ArrayList<>();

		for (Discussion discussion : discussions) {
			DiscussionTO discussionTO = new DiscussionTO();
			discussionTO.setId(discussion.getId());
			discussionTO.setTopic(discussion.getTopic());
			discussionTO.setCreatedAt(discussion.getCreatedAt());
			discussionTO.setProject(projectDtoAssembler.makeDTO(discussion.getProject()));
			discussionTO.setNotes(makeDTO3(discussion.getNotes(), dto));
			discussionTO.setUsers(makeDTO4(discussion.getUsers(), dto));
			
			dto.add(discussionTO);
		}
		return dto;
	}
	
	private List<NoteTO> makeDTO3(List<Note> notes, List<DiscussionTO> dto2) {

		List<NoteTO> dto = new ArrayList<>();

		for (Note note : notes) {
			NoteTO noteTO = new NoteTO();
			noteTO.setId(note.getId());
			noteTO.setNote(note.getNote());
			noteTO.setCreatedAt(note.getCreatedAt());
			noteTO.setUser(userDtoAssembler.makeDTO(note.getUser()));
			noteTO.setDiscussion(discussionDtoAssembler.makeDTO(note.getDiscussion()));
			noteTO.setAppointment(appointmentDtoAssembler.makeDTO(note.getAppointment()));
			
			dto.add(noteTO);
		}
		return dto;
	}
	
	private List<UserTO> makeDTO4(List<User> users, List<DiscussionTO> dto2) {

		List<UserTO> dto = new ArrayList<>();

		for (User user : users) {
			UserTO userTO = new UserTO();
			userTO.setPhoneNumber(user.getPhoneNumber());
			userTO.setFirstName(user.getFirstName());
			userTO.setLastName(user.getLastName());
			userTO.setRegistrationDate(user.getRegistrationDate());
			userTO.setDiscussions(makeDTO2(user.getDiscussions(), dto));
			userTO.setNotes(makeDTO5(user.getNotes(), dto));
			userTO.setProjects(makeDTO7(user.getProjects(), dto));
			
			dto.add(userTO);
		}
		return dto;
	}
	
	private List<NoteTO> makeDTO5(List<Note> notes, List<UserTO> dto2) {

		List<NoteTO> dto = new ArrayList<>();

		for (Note note : notes) {
			NoteTO noteTO = new NoteTO();
			noteTO.setId(note.getId());
			noteTO.setNote(note.getNote());
			noteTO.setCreatedAt(note.getCreatedAt());
			noteTO.setUser(userDtoAssembler.makeDTO(note.getUser()));
			noteTO.setDiscussion(discussionDtoAssembler.makeDTO(note.getDiscussion()));
			noteTO.setAppointment(appointmentDtoAssembler.makeDTO(note.getAppointment()));
			
			dto.add(noteTO);
		}
		return dto;
	}
	
	private List<UserTO> makeDTO6(List<User> users, List<DiscussionTO> dto2) {

		List<UserTO> dto = new ArrayList<>();

		for (User user : users) {
			UserTO userTO = new UserTO();
			userTO.setPhoneNumber(user.getPhoneNumber());
			userTO.setFirstName(user.getFirstName());
			userTO.setLastName(user.getLastName());
			userTO.setRegistrationDate(user.getRegistrationDate());
			userTO.setDiscussions(makeDTO2(user.getDiscussions(), dto));
			userTO.setNotes(makeDTO5(user.getNotes(), dto));
			userTO.setProjects(makeDTO7(user.getProjects(), dto));
			
			dto.add(userTO);
		}
		return dto;
	}
	
	private List<ProjectTO> makeDTO7(List<Project> projects, List<UserTO> dto2) {

		List<ProjectTO> dto = new ArrayList<>();

		for (Project project : projects) {
			ProjectTO projectTO = new ProjectTO();
			projectTO.setId(project.getId());
			projectTO.setOwner(userDtoAssembler.makeDTO(project.getOwner()));
			projectTO.setProjectName(project.getProjectName());
			projectTO.setProjectStatus(project.getProjectStatus());
			projectTO.setUpdatedOn(project.getUpdatedOn());
			projectTO.setAppointments(makeDTO10(project.getAppointments(), dto));
			projectTO.setDiscussions(makeDTO9(project.getDiscussions(), dto));
			projectTO.setMembers(makeDTO13(project.getMembers(), dto));
			projectTO.setMilestones(makeDTO12(project.getMilestones(), dto));
			
			dto.add(projectTO);
		}
		return dto;
	}

	private List<DiscussionTO> makeDTO9(List<Discussion> discussions, List<ProjectTO> dto2) {

		List<DiscussionTO> dto = new ArrayList<>();

		for (Discussion discussion : discussions) {
			DiscussionTO discussionTO = new DiscussionTO();
			discussionTO.setId(discussion.getId());
			discussionTO.setCreatedAt(discussion.getCreatedAt());
			discussionTO.setTopic(discussion.getTopic());
			discussionTO.setProject(projectDtoAssembler.makeDTO(discussion.getProject()));
			discussionTO.setNotes(makeDTO3(discussion.getNotes(), dto));
			discussionTO.setUsers(makeDTO6(discussion.getUsers(), dto));
			
			dto.add(discussionTO);
		}
		return dto;
	}
	
	private List<AppointmentTO> makeDTO10(List<Appointment> appointments, List<ProjectTO> dto2) {

		List<AppointmentTO> dto = new ArrayList<>();

		for (Appointment appointment : appointments) {
			AppointmentTO appointmentTO = new AppointmentTO();
			appointmentTO.setId(appointment.getId());
			appointmentTO.setAppointmentDate(appointment.getAppointmentDate());
			appointmentTO.setProject(projectDtoAssembler.makeDTO(appointment.getProject()));
			appointmentTO.setTopic(appointment.getTopic());
			appointmentTO.setShortNote(noteDtoAssembler.makeDTO(appointment.getShortNote()));
			appointmentTO.setUsers(makeDTO11(appointment.getUsers(), dto));
			
			dto.add(appointmentTO);
		}
		return dto;
	}
	
	private List<UserTO> makeDTO11(List<User> users, List<AppointmentTO> dto2) {

		List<UserTO> dto = new ArrayList<>();

		for (User user : users) {
			UserTO userTO = new UserTO();
			userTO.setFirstName(user.getFirstName());
			userTO.setLastName(user.getLastName());
			userTO.setPhoneNumber(user.getPhoneNumber());
			userTO.setRegistrationDate(user.getRegistrationDate());
			userTO.setDiscussions(makeDTO2(user.getDiscussions(), dto));
			userTO.setNotes(makeDTO5(user.getNotes(), dto));
			userTO.setProjects(makeDTO7(user.getProjects(), dto));
			
			dto.add(userTO);
		}
		return dto;
	}
	
	private List<MilestoneTO> makeDTO12(List<Milestone> milestones, List<ProjectTO> dto2) {

		List<MilestoneTO> dto = new ArrayList<>();

		for (Milestone milestone : milestones) {
			MilestoneTO milestoneTO = new MilestoneTO();
			milestoneTO.setId(milestone.getId());
			milestoneTO.setCreatedAt(milestone.getCreatedAt());
			milestoneTO.setStatus(milestone.getStatus());
			milestoneTO.setMilestoneName(milestone.getMilestoneName());
			milestoneTO.setProject(projectDtoAssembler.makeDTO(milestone.getProject()));
			
			dto.add(milestoneTO);
		}
		return dto;
	}
	
	private List<UserTO> makeDTO13(List<User> members, List<ProjectTO> dto2) {

		List<UserTO> dto = new ArrayList<>();

		for (User user : members) {
			UserTO userTO = new UserTO();
			userTO.setPhoneNumber(user.getPhoneNumber());
			userTO.setFirstName(user.getFirstName());
			userTO.setLastName(user.getLastName());
			userTO.setRegistrationDate(user.getRegistrationDate());
			userTO.setDiscussions(makeDTO2(user.getDiscussions(), dto));
			userTO.setNotes(makeDTO5(user.getNotes(), dto));
			userTO.setProjects(makeDTO7(user.getProjects(), dto));
			
			dto.add(userTO);
		}
		return dto;
	}
}
