package com.icl.ios.repository;

import com.icl.ios.models.*;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task> {
  Task findOneByNumber(Integer numberOfTask);
  List<Task> findAllByCategory(Category category);
  List<Task> findAllByRegion(Region region);
  List<Task> findAllByStatus(StatusTask status);
  List<Task> findAllByVersion(Version version);
  List<Task> findAllByPartOfSubject(String partOfsubject);
}
