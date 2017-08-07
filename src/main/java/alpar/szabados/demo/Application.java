package alpar.szabados.demo;

import alpar.szabados.demo.dao.UserDao;
import alpar.szabados.demo.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(alpar.szabados.demo.Application.class, args);
    }

//    private static void printUserEntries() {
//        UserDao.getAllUsers().forEach(System.out::println);
//    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            Arrays.stream(ctx.getBeanDefinitionNames())
                  .sorted()
                  .forEach(System.out::println);
        };
    }
}

