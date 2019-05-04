package ru.saubanova.services;

import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.dto.UserDto;
import ru.saubanova.models.User;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface UserAuthService {
  void signUp (UserDto userDto);
  Optional<String> signInAndCreateCookie(AuthUserDto userDto) ;
  Optional<User> findUserByCookie(Cookie cookie);
}
