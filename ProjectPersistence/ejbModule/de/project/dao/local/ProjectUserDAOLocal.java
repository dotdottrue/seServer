package de.project.dao.local;

import java.util.List;

import javax.ejb.Local;

import de.project.entities.ProjectSession;
import de.project.entities.User;

/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 *Interface fuer die User-Datenbankzugriffe. Die Local-Annotation macht dieses Interface fuer lokale Zugriffe erreichbar.
 */
@Local
public interface ProjectUserDAOLocal {

    public User findUserByNumber(String phoneNumber);

    public ProjectSession createSession(User user);

    public User createUser(String phoneNumber);

    public boolean endSession(int sessionId);
    
    public List<User> findAllUsers();

    //public List<User> searchUsers(String phoneNumber);

    public ProjectSession getSession(int sessionId);

}
