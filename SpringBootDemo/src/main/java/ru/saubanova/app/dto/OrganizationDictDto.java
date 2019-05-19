package ru.saubanova.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Organization;
import ru.saubanova.app.models.Post;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDictDto extends BaseDto<Organization> {
  private String name;
  public OrganizationDictDto(Organization organization){
    super(organization);
    this.name = organization.getName();
  }

}
