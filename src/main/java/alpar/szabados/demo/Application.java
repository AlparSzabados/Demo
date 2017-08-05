package alpar.szabados.demo;

import alpar.szabados.demo.dao.UserDao;
import alpar.szabados.demo.entities.User;

public class Application {
    public static void main(String... args) {
        UserDao.addNewUser(new User("Anca", "1234"));
        printUserEntries();
    }

    private static void printUserEntries() {
        UserDao.getAllUsers().forEach(System.out::println);
    }
}

