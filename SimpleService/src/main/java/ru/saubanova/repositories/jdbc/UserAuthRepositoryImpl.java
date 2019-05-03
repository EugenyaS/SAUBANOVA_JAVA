package ru.saubanova.repositories.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserAuthRepositoryImpl implements UserAuthRepository {

  //language=SQL
  private final static String SQL_SELECT_BY_COOKIE =
          "select user_auth.id auth_id, user_auth.user_id, user_auth.cookie_value, "+
                  " service_user.login "+
                  " from user_auth " +
                        "inner join service_user on user_auth.user_id=service_user.id" +
                  " where cookie_value= ?";
  //language=SQL
  private final static String SQL_SELECT_BY_ID =
          "select user_auth.id auth_id, user_auth.user_id, user_auth.cookie_value, "+
                  " service_user.login "+
                  " from user_auth " +
                  "inner join service_user on user_auth.user_id=service_user.id" +
                  " where user_auth.id= ?";

  //language=SQL
  private final static String SQL_INSERT_USER = "insert into user_auth(user_id,cookie_value) values (?, ?)";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<UserAuth> rowMapper = (row, rowNumber) -> {
    UserAuth userAuth = UserAuth.builder().cookieValue(row.getString("cookie_value")).build();
    User user = User.builder().login(row.getString("login")).id(row.getLong("user_id")).build();
    userAuth.setUser(user);
    return userAuth;
  };

  @Override
  public void save(UserAuth model) {
    jdbcTemplate.update(SQL_INSERT_USER, model.getUser().getId(), model.getCookieValue());
  }

  @Override
  public UserAuth find(Long id) {
    try {
      return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, rowMapper, id);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public Optional<UserAuth> getOneByCookie(String cookieValue) {
    try {
      return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE, rowMapper, cookieValue));
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }
  @Override
  public List<UserAuth> findAll() {
    return null;
  }
}
