package de.project.dao.local;

import javax.ejb.Local;

import de.project.entities.ProjectSession;
import de.project.entities.User;

@Local
public interface ProjectUserDAOLocal {

    public User findUserByNumber(String phoneNumber);

    public ProjectSession createSession(User user);

    public User createUser(String phoneNumber, String firstName, String lastName);

    public boolean endSession(int sessionId);

    //public List<User> searchUsers(String phoneNumber);

    public ProjectSession getSession(int sessionId);

}
