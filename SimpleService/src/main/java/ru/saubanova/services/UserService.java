package ru.saubanova.services;

import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.dto.UserDto;
import ru.saubanova.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
   void signUp (AuthUserDto userDto);
   Optional<String> signInAndCreateCookie(AuthUserDto userDto) ;
   boolean isExistByCookie(String cookieValue);
   List<User> getAllUsers();

   void addUser(UserDto userDto);
}
