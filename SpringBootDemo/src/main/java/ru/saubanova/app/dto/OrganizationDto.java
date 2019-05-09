package ru.saubanova.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.saubanova.app.models.Organization;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
  Long id;
  String name;

  public OrganizationDto(Organization organization) {
    this.id = organization.getId();
    this.name = organization.getName();
  }
}
