package ru.saubanova.services;

import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;

import javax.servlet.http.Cookie;
import java.util.Optional;

public class UserAuthServiceImpl implements UserAuthService {
  UserAuthRepository userAuthRepository;

  public UserAuthServiceImpl(UserAuthRepository userAuthRepository) {
    this.userAuthRepository = userAuthRepository;
  }

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
