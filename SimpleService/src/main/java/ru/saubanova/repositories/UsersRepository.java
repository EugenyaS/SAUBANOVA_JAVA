package ru.saubanova.repositories;

import ru.saubanova.models.User;

import java.util.List;

public interface UsersRepository extends CrudRepository<User> {
  User findOneByLogin(String login);
}
