package alpar.szabados.demo.hello;

import alpar.szabados.demo.dao.UserDao;
import alpar.szabados.demo.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/db")
    public List<String> stringList() {
        return UserDao.getAllUsers().stream().map(User::toString).collect(Collectors.toList());
    }
}