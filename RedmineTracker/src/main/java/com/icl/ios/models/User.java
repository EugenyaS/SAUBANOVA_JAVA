package com.icl.ios.models;
import lombok.*;

@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class User {
  public Long id;
  public String firstName;
  public String lastName;
  public String patronymicName;
  public Organization organization;
  public Post post;
  public Region region;
}
