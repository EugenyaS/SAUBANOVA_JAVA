package com.icl.ios.repository;

import com.icl.ios.models.Organization;

public interface OrganizationRepository extends CrudRepository<Organization> {
  Organization findOneByName(String name);
}
