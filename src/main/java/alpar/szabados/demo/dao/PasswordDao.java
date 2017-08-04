package alpar.szabados.demo.dao;

import alpar.szabados.demo.Connection;
import alpar.szabados.demo.entities.Password;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PasswordDao {
    private static final EntityManager ENTITY_MANAGER = Connection.getConnection();
    private static final EntityTransaction TRANSACTION = ENTITY_MANAGER.getTransaction();

    public static Password getEntityById(String id) {
        return ENTITY_MANAGER.find(Password.class, id);
    }

    public static void addNewPassword(Password password) {
        TRANSACTION.begin();
        ENTITY_MANAGER.persist(password);
        TRANSACTION.commit();
    }

    public static Password createNewActivity(Long userId, char password) {
        return new Password(userId, password);
    }

    public static void deletePassword(Password password) {
        if (password == null) return;
        TRANSACTION.begin();
        ENTITY_MANAGER.remove(ENTITY_MANAGER.contains(password) ? password : ENTITY_MANAGER.merge(password));
        TRANSACTION.commit();
    }

    public static void updatePassword(Password password) {
        if (password == null) return;
        TRANSACTION.begin();
        ENTITY_MANAGER.merge(password);
        TRANSACTION.commit();
    }
}
