package ru.saubanova.repositories.jdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.saubanova.models.User;
import ru.saubanova.repositories.UsersRepository;

import javax.sql.DataSource;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {

  //language=SQL
  private final static String SQL_SELECT_BY_ID = "select * from service_user where id = ? ";
  //language=SQL
  private final static String SQL_SELECT_BY_LOGIN = "select * from service_user where login= ?";

  //language=SQL
  private final static String SQL_SELECT_ALL = "select * from service_user";

  //language=SQL
  private final static String SQL_INSERT_USER = "insert into service_user(first_name,last_name,login,password) values (?, ?, ?, ?)";

  private JdbcTemplate jdbcTemplate;

  public UsersRepositoryJdbcImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  private RowMapper<User> usersRowMapper = (row, rowNumber) -> {
    return new User(row.getLong("id"),
            row.getString("first_name"),
            row.getString("last_name"),
            row.getString("login"),
            row.getString("password"));
  };


  @Override
  public void save(User model) {
    jdbcTemplate.update(SQL_INSERT_USER, model.getFirstName(), model.getLastName(), model.getLogin(), model.getPassword());
  }

  @Override
  public User find(Long id) {
    try {
      return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, usersRowMapper, id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(SQL_SELECT_ALL, usersRowMapper);
  }

  @Override
  public User findOneByLogin(String login) {
    try {
      return jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, usersRowMapper, login);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }
}
