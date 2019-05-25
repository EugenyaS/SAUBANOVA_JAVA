package ru.saubanova.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.saubanova.app.dto.OrganizationDto;
import ru.saubanova.app.dto.PostDto;
import ru.saubanova.app.services.OrganizationService;
import ru.saubanova.app.services.PostService;

import java.util.List;

@RestController
public class OrganizationController {
  @Autowired
  OrganizationService organizationService;

  @RequestMapping(value = "/orgs", method = RequestMethod.GET)
  @PreAuthorize("isAuthenticated()")
  public List<OrganizationDto> getOrganization() {
    return organizationService.getOrganizations();
  }

}
