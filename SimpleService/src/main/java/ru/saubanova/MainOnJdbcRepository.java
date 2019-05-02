package ru.saubanova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.saubanova.models.User;
import ru.saubanova.repositories.UsersRepository;

import java.util.List;

public class MainOnJdbcRepository {


  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("ru.saubanova.config\\context.xml");
    UsersRepository usersRepository = context.getBean(UsersRepository.class);

    List<User> users = usersRepository.findAll();

    for (User user : users) {
      System.out.println(user);
    }
  }
}
