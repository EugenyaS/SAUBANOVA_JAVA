package ru.saubanova.models;

import lombok.*;


@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserAuth {
  User user;
  String cookieValue;
}
