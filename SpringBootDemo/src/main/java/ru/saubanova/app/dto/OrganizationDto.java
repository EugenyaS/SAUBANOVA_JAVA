package ru.saubanova.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Organization;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto extends OrganizationDictDto{

  private String code;
  private Long parentId;
  private String parentName;

  public OrganizationDto(Organization organization) {
    super(organization);
    this.code = organization.getCode();
    if (organization.getOrganization()!=null){
      this.parentId=organization.getOrganization().getId();
      this.parentName=organization.getOrganization().getName();
    }
  }
}
