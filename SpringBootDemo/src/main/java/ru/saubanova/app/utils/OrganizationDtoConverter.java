package ru.saubanova.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.saubanova.app.dto.OrganizationDto;
import ru.saubanova.app.models.Organization;
import ru.saubanova.app.repositories.OrganizationRepository;

@Component
public class OrganizationDtoConverter implements BaseDtoConverter<Organization, OrganizationDto> {
  @Autowired
  private OrganizationRepository organizationRepository;

  @Override
  public Organization toEntity(OrganizationDto dto) {
    if (dto==null) return null;
    Organization organization;
    if(dto.getId() == null) {
      organization = new Organization();
    }
    else
    {
      organization = organizationRepository.getOne(dto.getId());
    }
    organization.setName(dto.getName());
    organization.setCode(dto.getCode());
    if (dto.getParentId()!=null){
      organization.setOrganization(organizationRepository.getOne(dto.getParentId()));
    }
    return organization;
  }
}
