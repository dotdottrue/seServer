package de.project.dao;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.project.entities.Appointment;
import de.project.entities.Note;
import de.project.entities.Project;
import de.project.entities.User;
import de.project.entities.Discussion;
import de.project.enumerations.ProjectStatus;

/**
 * 
 * @author Tobias Kappert | Edaurd Schartner
 *
 */
@Startup
@Singleton
public class DataBuilder {
	
	private static final Logger LOGGER = Logger.getLogger(DataBuilder.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	private String phoneNumber1, phoneNumber2, projectName, projectName2, projectName3, projectName4, 
				   discussionName, discussionName2, discussionName3, discussionName4, projectDescription
				   , appointmentName, appointmentName2, appointmentName3, appointmentName4, appointmentDiscription;
	
	@PostConstruct
	private void init() {
		User user1 = em.find(User.class, phoneNumber1); 
		if (user1 == null) {
			//Benutzer muss erst angelegt werden
			user1 = new User(phoneNumber1, new Date());
			em.persist(user1);		
		}
		LOGGER.info("Neu angelegt: " + user1);
		
		User user2 = em.find(User.class, phoneNumber2); 
		if (user2 == null) {
			//Benutzer muss erst angelegt werden
			user2 = new User(phoneNumber2, new Date());
			em.persist(user2);	
		}
		LOGGER.info("Neu angelegt: " + user2);	
	
		String[] phoneNumbers = { phoneNumber1, phoneNumber2 };
		String[] projectNames = { projectName, projectName2, projectName3, projectName4 };
		User[] users = { user1, user2 };
		String[] discussionNames = { discussionName, discussionName2, discussionName3, discussionName4 };
	
	    for(int i = 0; i < 4; i++){
			Project project = new Project();
			project.setOwner(users[i%2]);
			project.setUpdatedOn(new Date());
			project.setProjectName(projectNames[i]);
			project.setDescription(projectDescription);	
			project.setProjectStatus(ProjectStatus.INTIME);
			ArrayList<Discussion> discussionsList = new ArrayList<>();
			for(int j = 0; j < 4; j++){
				Discussion discussion = new Discussion(discussionNames[i], new Date());
				discussionsList.add(discussion);
			}
			
			ArrayList<Appointment> appointments = new ArrayList<>();
			for(int k = 0; k < 4; k++){
				appointments.add(new Appointment(appointmentName, appointmentDiscription, new Date()));
			}
			
			ArrayList<Note> notes = new ArrayList<>();
			for(int l = 0; l < 5; l++){
				notes.add(new Note(
									"BeispielNotiz",
									new Date(),
									phoneNumbers[i%2]
								));
			}
			
			for(int m = 0; m < 4; m++){
				Discussion d = discussionsList.get(m);
				d.setNotes(notes);
				discussionsList.set(i, d);
			}
			
			project.setDiscussions(discussionsList);
			project.setAppointments(appointments);

			ArrayList<User> membersList = new ArrayList<>();
			membersList.add(users[i%2]);
			
			project.setMembers(membersList);
			
			
			em.persist(project);
			LOGGER.info("Project mit dem Namen: " + projectNames[i] + " wurde angelegt!" );
	    }
	}
}
