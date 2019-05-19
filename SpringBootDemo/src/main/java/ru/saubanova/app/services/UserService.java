package ru.saubanova.app.services;


import ru.saubanova.app.dto.UserDto;

import java.util.List;

public interface UserService {
  public List<UserDto> getAllUsers();
  UserDto saveUser(UserDto userDto);
}
