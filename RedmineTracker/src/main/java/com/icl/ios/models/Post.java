package com.icl.ios.models;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Post {
  public Long id;
  public String name;
}
