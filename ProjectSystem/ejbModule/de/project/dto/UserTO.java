package de.project.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import de.project.entities.Note;
import de.project.entities.Project;

public class UserTO implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private String phoneNumber;
		private String firstName;
		private String lastName;
		private Calendar registrationDate;
		private List<Project> projects;
		private List<Note> notes;
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Calendar getRegistrationDate() {
			return registrationDate;
		}
		public void setRegistrationDate(Calendar registrationDate) {
			this.registrationDate = registrationDate;
		}
		public List<Project> getProjects() {
			return projects;
		}
		public void setProjects(List<Project> projects) {
			this.projects = projects;
		}
		public List<Note> getNotes() {
			return notes;
		}
		public void setNotes(List<Note> notes) {
			this.notes = notes;
		}
}
