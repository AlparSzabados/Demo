package alpar.szabados.demo.daos;

import alpar.szabados.demo.entities.User;
import org.ocpsoft.rewrite.annotation.Join;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.TypedQuery;
import java.util.List;

import static alpar.szabados.demo.utils.RunTransaction.ENTITY_MANAGER;
import static alpar.szabados.demo.utils.RunTransaction.runTransaction;

@ViewScoped
@ManagedBean(name = "userDao")
@Join(path = "/user", to = "/user-form.jsf")
public class UserDao {
	private User user = new User();

	private static final String DEFAULT_SELECT_QUERY = "SELECT u from User u";

	public static List<User> getAllUsers() {
		TypedQuery<User> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, User.class);
		return selectAllQuery.getResultList();
	}

	public static User getEntityById(String id) {
		return ENTITY_MANAGER.find(User.class, id);
	}

	public static String getEntityByName(String name) {
		TypedQuery<User> query = ENTITY_MANAGER.createQuery("select u from User u where userName = '" + name + "'", User.class);
		User user = query.getResultList().get(0);
		return user.toString();
	}

	public String save() {
		runTransaction(() -> ENTITY_MANAGER.persist(user));
		user = new User();
		return "/user-form.xhtml?faces-redirect=true";
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

	public User getUser() {
		return user;
	}
}
