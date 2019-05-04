package ru.saubanova.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.dto.UserDto;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;
import ru.saubanova.repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserAuthServiceImpl implements UserAuthService {
  @Autowired
  UsersRepository usersRepository;
  @Autowired
  UserAuthRepository userAuthRepository;
  @Autowired
  private PasswordEncoder encoder;

  @Override
  public void signUp(UserDto userDto) {
    String passwordHash = encoder.encode(userDto.getPassword());
    User newUser = User.builder()
            .login(userDto.getLogin())
            .passwordHash(passwordHash)
            .firstName(userDto.getFirstName())
            .lastName(userDto.getLastName()).build();
    usersRepository.save(newUser);
  }

  @Override
  public Optional<String> signInAndCreateCookie(AuthUserDto userDto) {
    Optional<User> userCandidate = usersRepository.findOneByLogin(userDto.getLogin());
    if (userCandidate.isPresent()) {
      User user = userCandidate.get();
      if (encoder.matches(userDto.getPassword(), user.getPasswordHash())) {
        String cookieValue= UUID.randomUUID().toString();
        UserAuth userAuth = UserAuth.builder()
                .user(user)
                .cookieValue(cookieValue).build();
        userAuthRepository.save(userAuth);
        return Optional.of(cookieValue);
      }
    }
    return Optional.empty();


  }

  @Override
  public Optional<User> findUserByCookie(Cookie cookie) {
    Optional<UserAuth> userAuth = userAuthRepository.getOneByCookie(cookie.getValue());
    return userAuth.map(UserAuth::getUser);
  }
}
