package alpar.szabados.demo.dao;

import alpar.szabados.demo.Connection;
import alpar.szabados.demo.entities.Activity;
import alpar.szabados.demo.utils.Complete;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ActivityDao {
    private static final String DEFAULT_SELECT_QUERY = "SELECT u from Activity u";
    private static final EntityManager ENTITY_MANAGER = Connection.getConnection();
    private static final EntityTransaction TRANSACTION = ENTITY_MANAGER.getTransaction();

    public static List<Activity> getAllActivities() {
        TypedQuery<Activity> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, Activity.class);
        return selectAllQuery.getResultList();
    }

    public static Activity getEntityById(String id) {
        return ENTITY_MANAGER.find(Activity.class, id);
    }

    public static void addNewActivity(Activity activity) {
        TRANSACTION.begin();
        ENTITY_MANAGER.persist(activity);
        TRANSACTION.commit();
    }

    public static Activity createNewActivity(Long userId, String activityName, LocalDate activityDate, Complete complete) {
        return new Activity(userId, activityName, activityDate, complete);
    }

    public static void deleteActivity(Activity activity) {
        if (activity == null) return;
        TRANSACTION.begin();
        ENTITY_MANAGER.remove(ENTITY_MANAGER.contains(activity) ? activity : ENTITY_MANAGER.merge(activity));
        TRANSACTION.commit();
    }

    public static void updateActivity(Activity activity) {
        if (activity == null) return;
        TRANSACTION.begin();
        ENTITY_MANAGER.merge(activity);
        TRANSACTION.commit();
    }
}
