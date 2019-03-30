package ru.itpark.repositories.jdbc;

import ru.itpark.models.User;
import ru.itpark.repositories.RowMapper;
import ru.itpark.repositories.UsersRepository;
//import ru.itpark.repositories.UsersRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    //language=SQL
    private final static String SQL_SELECT_BY_ID = "select * from service_user where id = ";

    //language=SQL
    private final static String SQL_SELECT_ALL = "select * from service_user";

    private DataBaseConnector connector;

    private RowMapper<User> usersRowMapper = row -> new User(row.getLong("id"),
            row.getString("first_name"),
            row.getString("last_name"),
            row.getString("login"),
            row.getString("password"));

//    private UsersRowMapper usersRowMapper;

    public UsersRepositoryJdbcImpl(DataBaseConnector connector) {
        this.connector = connector;
//        this.usersRowMapper = new UsersRowMapper();
    }

    @Override
    public void save(User model) {
        //language=sql
        String insertQuery = "insert into service_user(first_name, last_name, login, password) " +
                "values ('" + model.getFirstName() + "','" + model.getLastName() + "','" + model.getLogin()
                + "','" + model.getPassword() + "');";

        System.out.println("RUN QUERY: " + insertQuery);

        if (!connector.executeUpdate(insertQuery)) {
            throw new IllegalStateException("Some error");
        }
    }

    @Override
    public User find(Long id) {
        ResultSet result = connector.executeQuery(SQL_SELECT_BY_ID + id + ";");
        try {
            if (result.next()) {
                return usersRowMapper.mapRow(result);
            } else return null;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {
        ResultSet result = connector.executeQuery(SQL_SELECT_ALL);
        List<User> users = new ArrayList<>();
        try {
            while (result.next()) {
                User user = usersRowMapper.mapRow(result);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
