package com.icl.ios.repository;

import com.icl.ios.models.Region;

public interface RegionRepository extends CrudRepository<Region> {
  Region findOneByName(String name);
}
