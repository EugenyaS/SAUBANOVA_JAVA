package ru.saubanova.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.saubanova.app.dto.UserDto;
import ru.saubanova.app.models.Organization;
import ru.saubanova.app.models.Role;
import ru.saubanova.app.models.User;
import ru.saubanova.app.repositories.UserRepository;
import ru.saubanova.app.utils.UserDtoConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository usersRepository;
  @Autowired
  private UserDtoConverter userDtoConverter;


  @Override
  public List<UserDto> getAllUsers() {
    return usersRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
  }

  @Override
  public void saveUser(UserDto userDto) {
      usersRepository.save(userDtoConverter.toEntity(userDto));
  }
}
