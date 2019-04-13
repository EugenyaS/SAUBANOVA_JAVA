package com.icl.ios.repository;

import com.icl.ios.models.Version;

public interface VersionRepository extends CrudRepository<Version> {
  Version findOneByName(String name);
}
