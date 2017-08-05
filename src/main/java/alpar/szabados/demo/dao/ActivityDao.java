package alpar.szabados.demo.dao;

import alpar.szabados.demo.entities.Activity;
import alpar.szabados.demo.utils.TaskStatus;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

import static alpar.szabados.demo.utils.RunTransaction.ENTITY_MANAGER;
import static alpar.szabados.demo.utils.RunTransaction.runTransaction;

public class ActivityDao {
    private static final String DEFAULT_SELECT_QUERY = "SELECT u from Activity u";

    public static List<Activity> getAllActivities() {
        TypedQuery<Activity> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, Activity.class);
        return selectAllQuery.getResultList();
    }

    public static Activity getEntityById(String id) {
        return ENTITY_MANAGER.find(Activity.class, id);
    }

    public static void addNewActivity(Activity activity) {
        runTransaction(() -> ENTITY_MANAGER.persist(activity));
    }

    public static Activity createNewActivity(Long userId, String activityName, LocalDate activityDate, TaskStatus taskStatus) {
        return new Activity(userId, activityName, activityDate, taskStatus);
    }

    public static void deleteActivity(Activity activity) {
        if (activity == null) // TODO is this really necessary
            return;
        Activity entity = ENTITY_MANAGER.contains(activity) ? activity : ENTITY_MANAGER.merge(activity); // TODO why merge before a remove?
        runTransaction(() -> ENTITY_MANAGER.remove(entity));
    }

    public static void updateActivity(Activity activity) {
        if (activity == null)
            return;
        runTransaction(() -> ENTITY_MANAGER.merge(activity));
    }
}
