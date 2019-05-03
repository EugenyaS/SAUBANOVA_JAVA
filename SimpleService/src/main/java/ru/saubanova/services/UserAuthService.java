package ru.saubanova.services;

import ru.saubanova.models.User;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface UserAuthService {
  Optional<User> findUserByCookie(Cookie cookie);
}
