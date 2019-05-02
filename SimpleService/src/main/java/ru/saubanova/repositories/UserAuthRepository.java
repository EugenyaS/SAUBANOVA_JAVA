package ru.saubanova.repositories;

import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;

import java.util.Optional;

public interface UserAuthRepository {
   void save(UserAuth model);
   Optional<UserAuth> getOneByCookie(String cookieValue);
}
