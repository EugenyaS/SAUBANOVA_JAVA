package ru.saubanova.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saubanova.app.models.User;
import ru.saubanova.app.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository usersRepository;

  @Override
  public List<User> getAllUsers() {
    return usersRepository.findAll();
  }

  @Override
  public void saveUser(User user) {
    usersRepository.save(user);
  }
}
