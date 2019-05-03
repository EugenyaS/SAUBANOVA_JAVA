package ru.saubanova.repositories;

import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;

import java.util.List;
import java.util.Optional;

public interface UserAuthRepository extends  CrudRepository<UserAuth>{
   Optional<UserAuth> getOneByCookie(String cookieValue);
   UserAuth find(Long id);
   List<UserAuth> findAll();
}
