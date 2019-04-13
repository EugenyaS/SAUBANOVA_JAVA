package com.icl.ios.repository;

import com.icl.ios.models.StatusTask;

public interface StatusTaskRepository extends CrudRepository<StatusTask> {
  StatusTask findOneByName(String name);
}
