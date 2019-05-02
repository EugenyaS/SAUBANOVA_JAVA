package ru.saubanova.repositories;

import ru.saubanova.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
  Optional<User> findOneByLogin(String login);
  List<User> findAll();
}
