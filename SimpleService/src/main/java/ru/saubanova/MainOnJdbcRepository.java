package ru.saubanova;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.saubanova.models.User;
import ru.saubanova.repositories.UsersRepository;
import ru.saubanova.repositories.jdbc.UsersRepositoryJdbcImpl;

import java.util.List;

public class MainOnJdbcRepository {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://192.168.83.102:5432/my_service";

    public static void main(String[] args) {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
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
