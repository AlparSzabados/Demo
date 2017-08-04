package alpar.szabados.demo.dao;

import alpar.szabados.demo.Connection;
import alpar.szabados.demo.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {
    private static final String DEFAULT_SELECT_QUERY = "SELECT u from User u";
    private static final EntityManager ENTITY_MANAGER = Connection.getConnection();
    private static final EntityTransaction TRANSACTION = ENTITY_MANAGER.getTransaction();

    public static List<User> getAllUsers() {
        TypedQuery<User> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, User.class);
        return selectAllQuery.getResultList();
    }

    public static User getEntityById(String id) {
        return ENTITY_MANAGER.find(User.class, id);
    }

    public static void addNewUser(User user) {
        TRANSACTION.begin();
        ENTITY_MANAGER.persist(user);
        TRANSACTION.commit();
    }

    public static User createNewUser(String user_name, String password) {
        return new User(user_name, password);
    }

    public static void deleteUser(User user) {
        if (user == null) return;
        TRANSACTION.begin();
        ENTITY_MANAGER.remove(ENTITY_MANAGER.contains(user) ? user : ENTITY_MANAGER.merge(user));
        TRANSACTION.commit();
    }

    public static void updateUser(User user) {
        if (user == null) return;
        TRANSACTION.begin();
        ENTITY_MANAGER.merge(user);
        TRANSACTION.commit();
    }
}
