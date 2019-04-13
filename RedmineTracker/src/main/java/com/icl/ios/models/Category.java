package com.icl.ios.models;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Category {
  public Long id;
  public String name;
}
