package ru.saubanova.repositories.jdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;

import java.util.Optional;

public class UserAuthRepositoryImpl implements UserAuthRepository {

  //language=SQL
  private final static String SQL_SELECT_BY_COOKIE = "select * from user_auth inner join service_user on user_auth.user_id=service_user.id where cookie_value= ?";

  //language=SQL
  private final static String SQL_INSERT_USER = "insert into user_auth(user_id,cookie_value) values (?, ?)";

  private JdbcTemplate jdbcTemplate;

  public UserAuthRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private RowMapper<UserAuth> rowMapper = (row, rowNumber) -> {
    UserAuth userAuth = UserAuth.builder().cookieValue(row.getString("cookie_value")).build();
    User user = User.builder().login(row.getString("login")).id(row.getLong("id")).build();
    userAuth.setUser(user);
    return userAuth;
  };

  @Override
  public void save(UserAuth model) {
    jdbcTemplate.update(SQL_INSERT_USER, model.getUser().getId(), model.getCookieValue());
  }

  @Override
  public Optional<UserAuth> getOneByCookie(String cookieValue) {
    try {
      return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE, rowMapper, cookieValue));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }
}
