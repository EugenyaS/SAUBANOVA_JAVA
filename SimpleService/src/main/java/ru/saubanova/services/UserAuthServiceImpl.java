package ru.saubanova.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;

import javax.servlet.http.Cookie;
import java.util.Optional;

@Component
public class UserAuthServiceImpl implements UserAuthService {
  @Autowired
  UserAuthRepository userAuthRepository;

  @Override
  public Optional<User> findUserByCookie(Cookie cookie) {
    Optional<UserAuth> userAuth = userAuthRepository.getOneByCookie(cookie.getValue());
//    if (userAuth.isPresent()) {
//      return Optional.of(userAuth.get().getUser());
//    } else {
//      return Optional.empty();
//    }
    return userAuth.map(UserAuth::getUser);
  }
}
