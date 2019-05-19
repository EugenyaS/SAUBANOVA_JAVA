package ru.saubanova.app.services;


import ru.saubanova.app.dto.UserDto;
import ru.saubanova.app.models.User;

import java.util.List;

public interface UserService {
  public List<UserDto> getAllUsers();
  void saveUser(UserDto userDto);
}
