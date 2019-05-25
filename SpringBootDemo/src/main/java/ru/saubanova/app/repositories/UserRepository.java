package ru.saubanova.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.saubanova.app.models.User;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> getUserById(Long id);
  Optional<User> findFirstByLoginIgnoreCase(String login);

}
