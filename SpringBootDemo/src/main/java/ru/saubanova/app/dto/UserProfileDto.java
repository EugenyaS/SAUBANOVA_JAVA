package ru.saubanova.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.UserProfile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto extends BaseDto<UserProfile> {

  private Long userId;
  private String lastName;
  private String firstName;
  private String patronymic;
  private String email;
  private PostDictDto post;

  public UserProfileDto(UserProfile userProfile){
    super(userProfile);
    this.userId=userProfile.getUser().getId();
    this.email=userProfile.getEmail();
    this.firstName=userProfile.getFirstName();
    this.lastName=userProfile.getLastName();
    this.patronymic=userProfile.getPatronymic();
    this.post= userProfile.getPost() == null ? null : new PostDictDto(userProfile.getPost());
    }
}
