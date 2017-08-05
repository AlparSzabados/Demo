package alpar.szabados.demo.dao;

import alpar.szabados.demo.entities.User;

import javax.persistence.TypedQuery;
import java.util.List;

import static alpar.szabados.demo.utils.RunTransaction.ENTITY_MANAGER;
import static alpar.szabados.demo.utils.RunTransaction.runTransaction;

public class UserDao {
    private static final String DEFAULT_SELECT_QUERY = "SELECT u from User u";

    public static List<User> getAllUsers() {
        TypedQuery<User> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, User.class);
        return selectAllQuery.getResultList();
    }

    public static User getEntityById(String id) {
        return ENTITY_MANAGER.find(User.class, id);
    }

    public static void addNewUser(User user) {
        runTransaction(() -> ENTITY_MANAGER.persist(user));
    }

    public static User createNewUser(String user_name, String password) {
        return new User(user_name, password);
    }

    public static void deleteUser(User user) {
        if (user == null) // TODO is this really necessary
            return;
        User entity = ENTITY_MANAGER.contains(user) ? user : ENTITY_MANAGER.merge(user); // TODO why merge before a remove?
        runTransaction(() -> ENTITY_MANAGER.remove(entity));
    }

    public static void updateUser(User user) {
        if (user == null)
            return;
        runTransaction(() -> ENTITY_MANAGER.merge(user));
    }
}
