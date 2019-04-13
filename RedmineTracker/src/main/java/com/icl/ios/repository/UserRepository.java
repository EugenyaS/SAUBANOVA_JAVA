package com.icl.ios.repository;

import com.icl.ios.models.*;

import java.util.List;

public interface UserRepository extends CrudRepository<User> {
  User findOneByLogin(String login);
  List<User> findAllByOrganization(Organization organization);
  List<User> findAllByRegion(Region region);
  List<User> findAllByPost(Post post);
  List<User> findAllByFullName(String firstName, String lastName, String patronymicName);
}
