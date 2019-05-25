package ru.saubanova.app.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.saubanova.app.models.User;
import ru.saubanova.app.repositories.UserRepository;

import java.util.Optional;

@Service(value="customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Optional<User> userCandidate = userRepository.findFirstByLoginIgnoreCase(login);
    if (userCandidate.isPresent()){
      User user = userCandidate.get();
      return new UserDetailsImpl(user);
    }
    throw new UsernameNotFoundException("Пользователь <"+login+"> не найден");
  }
}
