package ru.saubanova.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.saubanova.app.dto.UserDto;
import ru.saubanova.app.models.Role;
import ru.saubanova.app.models.User;
import ru.saubanova.app.repositories.OrganizationRepository;
import ru.saubanova.app.repositories.UserRepository;

@Component
public class UserDtoConverter implements BaseDtoConverter<User, UserDto> {

  @Autowired
  private PasswordEncoder encoder;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private OrganizationRepository organizationRepository;
  @Autowired
  private UserProfileDtoConverter userProfileDtoConverter;

  @Override
  public User toEntity(UserDto dto) {
    User user;
    if (dto.getId() == null) {
      user = new User();
    } else {
      user = userRepository.getOne(dto.getId());
    }
    user.setLogin(dto.getLogin().toLowerCase());
    if (dto.getPassword() != null) {
      user.setPassword(encoder.encode(dto.getPassword()));
    }
    user.setOrganization(organizationRepository.getOne(dto.getOrganization().getId()));
    if (user.getRole() != Role.ADMIN) {
      user.setRole(Role.USER);
    } ;
    user.setUserProfile(userProfileDtoConverter.toEntity(dto.getUserProfile()));

    return user;
  }
}
