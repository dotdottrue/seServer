package de.project.dao.local;

import java.util.List;

import javax.ejb.Local;

import de.project.entities.ProjectSession;
import de.project.entities.User;

@Local
public interface ProjectUserDAOLocal {

    public User findUserByName(String username);

    public ProjectSession createSession(User user);

    public User createUser(String phoneNumber);

    public boolean closeSession(int sessionId);

    public List<User> searchUsers(String info);

    public ProjectSession getSession(int sessionId);

}