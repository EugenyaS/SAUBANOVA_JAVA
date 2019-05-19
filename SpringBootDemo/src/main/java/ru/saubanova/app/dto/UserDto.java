package ru.saubanova.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Organization;
import ru.saubanova.app.models.Role;
import ru.saubanova.app.models.User;
import ru.saubanova.app.models.UserProfile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto<User> {
  private Long id;
  private String login;
  private String password;
  private Role role;
  private OrganizationDictDto organization;
  private UserProfileDto userProfile;

  public UserDto(User user) {
    this.id = user.getId();
    this.login = user.getLogin();
    this.role=user.getRole();
    this.organization = user.getOrganization() == null ? null : new OrganizationDictDto(user.getOrganization());
    this.userProfile = user.getUserProfile() == null ? null : new UserProfileDto(user.getUserProfile());
  }

}
