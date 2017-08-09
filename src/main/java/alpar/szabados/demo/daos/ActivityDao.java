package alpar.szabados.demo.daos;

import alpar.szabados.demo.entities.Activity;
import alpar.szabados.demo.utils.TaskStatus;
import org.ocpsoft.rewrite.annotation.Join;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RequestScoped
@ManagedBean(name = "activityList")
@Join(path = "/activity", to = "/activity-list.jsf")
public class ActivityDao {
	private final String DEFAULT_SELECT_QUERY = "SELECT u from Activity u";

	@PersistenceContext
	private EntityManager ENTITY_MANAGER;

	private Activity activity = new Activity();

	public List<Activity> getAllActivities() {
		TypedQuery<Activity> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, Activity.class);
		return selectAllQuery.getResultList();
	}

	public Activity getEntityById(String id) {
		return ENTITY_MANAGER.find(Activity.class, id);
	}

	@Transactional
	public void addNewActivity(Activity activity) {
		ENTITY_MANAGER.persist(activity);
	}

	public Activity createNewActivity(Long userId, String activityName, LocalDate activityDate, TaskStatus taskStatus) {
		return new Activity(userId, activityName, activityDate, taskStatus);
	}

	@Transactional
	public void deleteActivity(Activity activity) {
		if (activity == null) // TODO is this really necessary
			return;
		Activity entity = ENTITY_MANAGER.contains(activity) ? activity : ENTITY_MANAGER.merge(activity); // TODO why merge before a remove?
		ENTITY_MANAGER.remove(entity);
	}

	@Transactional
	public void updateActivity(Activity activity) {
		if (activity == null)
			return;
		ENTITY_MANAGER.merge(activity);
	}

	public Activity getActivity() {
		return activity;
	}
}

