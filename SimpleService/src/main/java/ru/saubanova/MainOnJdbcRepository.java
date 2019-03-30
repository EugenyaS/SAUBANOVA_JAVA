package ru.itpark;

import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;
import ru.itpark.repositories.jdbc.DataBaseConnector;
import ru.itpark.repositories.jdbc.UsersRepositoryJdbcImpl;
import ru.itpark.utils.UserFromConsoleRetriever;

import java.util.List;

public class MainOnJdbcRepository {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Zaq12wsx";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/my_service";

    public static void main(String[] args) {
        UserFromConsoleRetriever retriever = new UserFromConsoleRetriever();
        DataBaseConnector connector = new DataBaseConnector(DB_URL, DB_USER, DB_PASSWORD);
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connector);
        List<User> users = usersRepository.findAll();

        for (User user : users) {
            System.out.println(user);
        }
//        User user = retriever.retrieveUser();
//        usersRepository.save(user);
//        System.out.println(usersRepository.find(0L));
//        System.out.println(usersRepository.find(1L));
//        System.out.println(usersRepository.find(2L));
    }
}
