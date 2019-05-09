package ru.saubanova.app.services;

import ru.saubanova.app.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
  List<OrganizationDto> getOrganizations();
}
