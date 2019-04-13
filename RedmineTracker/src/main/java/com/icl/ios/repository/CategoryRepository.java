package com.icl.ios.repository;

import com.icl.ios.models.Category;

public interface CategoryRepository extends CrudRepository<Category> {
  Category findOneByName(String name);
}
