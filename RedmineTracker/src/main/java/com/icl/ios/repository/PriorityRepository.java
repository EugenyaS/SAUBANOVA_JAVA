package com.icl.ios.repository;

import com.icl.ios.models.Priority;

public interface PriorityRepository extends CrudRepository<Priority> {
  Priority findOneByName(String name);
}
