package alpar.szabados.demo;

import alpar.szabados.demo.dao.UserDao;
import alpar.szabados.demo.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/")
    public String logIn() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/db/{name}")
    public @ResponseBody
    String getName(@PathVariable String name) {
        return UserDao.getEntityByName(name);
    }

    @RequestMapping(value = "/db")
    public List<User> getDatabaseContent() {
        return UserDao.getAllUsers();
    }
}
