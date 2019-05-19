package ru.saubanova.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.saubanova.app.dto.UserProfileDto;
import ru.saubanova.app.models.UserProfile;
import ru.saubanova.app.repositories.PostRepository;
import ru.saubanova.app.repositories.UserProfileRepository;
import ru.saubanova.app.repositories.UserRepository;

@Component
public class UserProfileDtoConverter implements BaseDtoConverter<UserProfile, UserProfileDto> {
  @Autowired
  private UserProfileRepository userProfileRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;

  @Override
  public UserProfile toEntity(UserProfileDto dto) {
    if (dto == null) return null;
    UserProfile userProfile;
    if (dto.getId() == null) {
      userProfile = new UserProfile();
    } else {
      userProfile = userProfileRepository.getOne(dto.getId());
    }
    userProfile.setEmail(dto.getEmail());
    userProfile.setFirstName(dto.getFirstName());
    userProfile.setLastName(dto.getLastName());
    userProfile.setPatronymic(dto.getPatronymic());
    userProfile.setPost(postRepository.getOne(dto.getPost().getId()));
    if (dto.getUserId()!=null) {
      userProfile.setUser(userRepository.getOne(dto.getUserId()));
    }
    return userProfile;
  }
}
