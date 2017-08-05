package alpar.szabados.demo.utils;

import alpar.szabados.demo.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RunTransaction {
    public static final EntityManager ENTITY_MANAGER = Connection.getConnection();
    public static final EntityTransaction TRANSACTION = ENTITY_MANAGER.getTransaction();

    public static void runTransaction(Runnable transaction) {
        try { // TODO find a better way
            TRANSACTION.begin();
            transaction.run();
            TRANSACTION.commit();
        } catch (Exception e) {
            TRANSACTION.rollback();
        }
    }
}
