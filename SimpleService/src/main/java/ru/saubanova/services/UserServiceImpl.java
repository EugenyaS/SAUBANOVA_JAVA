package ru.saubanova.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;
import ru.saubanova.repositories.UsersRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {
  private UsersRepository usersRepository;
  private UserAuthRepository userAuthRepository;
  private PasswordEncoder encoder;

  public UserServiceImpl(UsersRepository usersRepository, UserAuthRepository userAuthRepository, PasswordEncoder encoder) {
    this.usersRepository = usersRepository;
    this.encoder = encoder;
    this.userAuthRepository = userAuthRepository;
  }

  @Override
  public void signUp(AuthUserDto userDto) {
    String passwordHash = encoder.encode(userDto.getPassword());
    User newUser = User.builder().login(userDto.getLogin()).passwordHash(passwordHash).build();
    usersRepository.save(newUser);
  }

  @Override
  public Optional<String> signInAndCreateCookie(AuthUserDto userDto) {
    Optional<User> userCandidate = usersRepository.findOneByLogin(userDto.getLogin());
    if (userCandidate.isPresent()) {
      User user = userCandidate.get();
      if (encoder.matches(userDto.getPassword(), user.getPasswordHash())) {
        String cookieValue=UUID.randomUUID().toString();
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
  public boolean isExistByCookie(String cookieValue) {
    Optional<UserAuth> userAuth = userAuthRepository.getOneByCookie(cookieValue);
    return userAuth.isPresent();
  }

  @Override
  public List<User> getAllUsers() {
    return usersRepository.findAll();
  }
}
