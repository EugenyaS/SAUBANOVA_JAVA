package com.icl.ios.repository;

import com.icl.ios.models.Post;

public interface PostRepository extends CrudRepository<Post> {
  Post findOneByName(String name);
}
