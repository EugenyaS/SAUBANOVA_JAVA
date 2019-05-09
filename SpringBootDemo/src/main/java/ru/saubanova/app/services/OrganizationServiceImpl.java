package ru.saubanova.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.saubanova.app.dto.OrganizationDto;
import ru.saubanova.app.repositories.OrganizationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {
  @Autowired
  OrganizationRepository organizationRepository;
  @Override
  public List<OrganizationDto> getOrganizations() {
    return organizationRepository.findAll().stream().map(OrganizationDto::new).collect(Collectors.toList());
  }
}
