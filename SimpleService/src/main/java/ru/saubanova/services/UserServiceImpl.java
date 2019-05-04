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



  public UserServiceImpl(UsersRepository usersRepository, UserAuthRepository userAuthRepository, PasswordEncoder encoder) {
    this.usersRepository = usersRepository;
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
