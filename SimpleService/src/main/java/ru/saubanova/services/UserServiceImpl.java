package ru.saubanova.services;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.dto.UserDto;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;
import ru.saubanova.repositories.UsersRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
  @Autowired
  private UsersRepository usersRepository;
  @Autowired
  private UserAuthRepository userAuthRepository;
  @Autowired
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

  @Override
  public void addUser(UserDto userDto) {
    User user = User.builder().firstName(userDto.getFirstName())
            .lastName(userDto.getLastName()).build();
    usersRepository.save(user);
  }
}
