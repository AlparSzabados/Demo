package alpar.szabados.demo.daos;

import alpar.szabados.demo.entities.User;
import org.ocpsoft.rewrite.annotation.Join;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ViewScoped
@ManagedBean(name = "userDao")
@Join(path = "/user", to = "/user-form.jsf")
public class UserDao {
	private final String DEFAULT_SELECT_QUERY = "SELECT u from User u";

	@PersistenceContext
	private EntityManager ENTITY_MANAGER;

	private User user = new User();

	public List<User> getAllUsers() {
		TypedQuery<User> selectAllQuery = ENTITY_MANAGER.createQuery(DEFAULT_SELECT_QUERY, User.class);
		return selectAllQuery.getResultList();
	}

	public User getEntityById(String id) {
		return ENTITY_MANAGER.find(User.class, id);
	}

	public String getEntityByName(String name) {
		TypedQuery<User> query = ENTITY_MANAGER.createQuery("select u from User u where userName = '" + name + "'", User.class);
		User user = query.getResultList().get(0);
		return user.toString();
	}

	@Transactional
	public String save() {
		ENTITY_MANAGER.persist(user);
		user = new User();
		return "/user-form.xhtml?faces-redirect=true";
	}

	@Transactional
	public void addNewUser(User user) {
		ENTITY_MANAGER.persist(user);
	}

	public User createNewUser(String user_name, String password) {
		return new User(user_name, password);
	}

	@Transactional
	public void deleteUser(User user) {
		if (user == null) // TODO is this really necessary
			return;
		User entity = ENTITY_MANAGER.contains(user) ? user : ENTITY_MANAGER.merge(user); // TODO why merge before a remove?
		ENTITY_MANAGER.remove(entity);
	}

	@Transactional
	public void updateUser(User user) {
		if (user == null)
			return;
		ENTITY_MANAGER.merge(user);
	}

	public User getUser() {
		return user;
	}
}
